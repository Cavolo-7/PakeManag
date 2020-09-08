package com.auc.controller;


import com.auc.service.impl.AuthServiceImpl;
import com.auc.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @基本功能:
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-08 08:58:29
 **/
@Controller
@RequestMapping("/car")
public class CarControl {

    @Autowired
    private CarServiceImpl carServiceImpl;
    @Autowired
    private AuthServiceImpl authServiceImpl;


    /**
      * @Author: TheBigBlue
      * @Description:  车辆入场
      * @Date: 2020/9/8
      * @Param request:
      * @Param file:
      * @return: void
      **/
    @RequestMapping("/carin")
    @ResponseBody
    public void carIn(HttpServletRequest request,MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();//获取文件名
        String prefix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1); //获取后缀名（格式）
        String uuid = UUID.randomUUID().toString();//使用UUID+后缀名保存
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = df.format(date);
        String savePath = request.getSession().getServletContext().getRealPath("/upload");//保存路径
        //要保存的路径和文件名
        String projectPath = savePath + File.separator + dateStr + File.separator + uuid + "." + prefix;
        System.out.println("保存路径：" + projectPath);
        File files = new File(projectPath);
        //判断目录是否存在
        if (!files.getParentFile().exists()) {
            files.getParentFile().mkdirs();
        }
        file.transferTo(files);// 将接收的文件保存到指定文件中

        String accessToken = authServiceImpl.getAuth();//获取accessToken，调用车牌识别接口
        carServiceImpl.carIn(accessToken);//车辆入库业务
    }

}