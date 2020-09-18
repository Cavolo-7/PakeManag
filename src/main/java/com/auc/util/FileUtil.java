package com.auc.util;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 文件读取工具类 ----车牌识别
 */
public class FileUtil {

    /**
     * 读取文件内容，作为字符串返回
     */
    public static String readFileAsString(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        }

        if (file.length() > 1024 * 1024 * 1024) {
            throw new IOException("File is too large");
        }

        StringBuilder sb = new StringBuilder((int) (file.length()));
        // 创建字节输入流  
        FileInputStream fis = new FileInputStream(filePath);
        // 创建一个长度为10240的Buffer
        byte[] bbuf = new byte[10240];
        // 用于保存实际读取的字节数  
        int hasRead = 0;
        while ((hasRead = fis.read(bbuf)) > 0) {
            sb.append(new String(bbuf, 0, hasRead));
        }
        fis.close();
        return sb.toString();
    }

    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }


    /**
     * 文件上传工具类 返回保存路径
     */
    public static String uploadFile(HttpServletRequest request, MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();//获取文件名
        String prefix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1); //获取后缀名（格式）
        String uuid = UUID.randomUUID().toString();//使用UUID+后缀名保存
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = df.format(date);
        String savePath = request.getSession().getServletContext().getRealPath("/upload");//保存路径
        //要保存的路径和文件名
        String projectPath = savePath + File.separator + dateStr + File.separator + uuid + "." + prefix;
        File files = new File(projectPath);
        //判断目录是否存在
        if (!files.getParentFile().exists()) {
            files.getParentFile().mkdirs();
        }
        file.transferTo(files);// 将接收的文件保存到指定文件中
        return projectPath;
    }

    /**
     * 识别车牌 返回车牌识别结果
     */
    public static Result getCarNumber(String path, String accessToken) {
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate";// 请求url
        Result carInfo = new Result();
        try {
            byte[] imgData = new byte[0];//要识别的图片路径
            imgData = FileUtil.readFileByBytes(path);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            String result = HttpUtil.post(url, accessToken, param);//得到车牌信息
            carInfo = JSON.parseObject(result, Result.class);//车牌信息Json字符串转成Result
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carInfo;
    }


}
