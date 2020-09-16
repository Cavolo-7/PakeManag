package com.auc.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 */

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000116679961";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCCpqc7OA9HxC6M0FzKlB2esomUvyssUU67oYb33cEZjl+ZwdtUAtizoq6oJWzJNDE4SlGLGwubgM0rcYTMI/+I0+MOhc9OED+vearSnYOagvDSO3JyG39YWH4Zm2TmoOoEydayZ3Lloigi6aFtqJZsRkAFFv3+quL62nm4XvrJLxGYNoyBU4/hp4hm7vORZ3Gb7eAG2pQJxsjlotg1NikRw7ZsWlThuNNY7djUerh7hQBbNu7TbapUmHhX2VzCYpQVE9cN1OZbCmlke+P5PYQB64TfiBH3Bfy0u6wEI2PetSxtjhY+iov2TGW1jtPC6Fh+pvTMhVYVBROGIxIdpUDbAgMBAAECggEAHwcM+BdcKaMBmxdwsfty/VlRKy4rRp8Yn57AuuTDExqowY80U0NJy397ExuwNiha+A9ORkbp/sgb8ZFIBGMYMJqBddV5YgSh2z59vv8BXhRytLrBdy/okkaRy+sHj23vpat5fWzr8HUOKxxo5e3/qz8TvSG0uGJE/WYdOhf0XwqgzY9SaLdYAMUU3sfB6XY3StxlUB6OrOGzCl+IVKSsjJcImPAbvwOF67lmktv2ZEI7uxbG7F8vSYKmGn11tCfIt96TH5G7RoTKuBi3cmtOnwiv8tvGAZ1jBZjCOYGHD5pzmO1QK+S6ZdF/x4TFnM3zOpt26XMyvWhO+4uMu8ylQQKBgQDs3W9OgjI7RgW3lPu1VFAxvE/eqs/wytmJ3+Y9dobpRavuVeiYX9rxAhiBf3PhzCgr0RdeBwZEG2H2A/FnDUhfDHGzhWEvS2OlfbNNJWdRKoSgfvCsTRSzdeWe4w63VGdb3ZbwKB4iDvIWbqZEdAHOd4Tywb7Na0TjHOz+fBJ4eQKBgQCNNJ/mB+rocU83/E95K0JEADCWxEJzKRPNVMcFZGZ2c0eHFbV94w4HdXAuAovqv4mRzchsO0vFnJgWFGxU8uxVzeRXzZYT9N9kfLwYldCF9w9F0vGmlBv5px8VlEnCbkBXHnUwmDfOuOebQEEZLyE50TRF/ba9jPL5isor/DaW8wKBgQC5Pjxsk9ohDRQvjO6F05icLP/xznitgpc7AsYXz3iXOwvJa5pqgJzD27W6oSjJsFbCXdX+jVPTM+8a7d5/j53H5/2MPoXQ7Q7TQElXzibNDYmH03754ZaM+2lHJ6A8tF/ZMqV20Ikwbava61JROsCm7kYlbGyCTqAjVl3qcLIpUQKBgGA3K30ih/46ty/+zGhUAaM0Ped9c4nkw4l16ubRsr+jbWmucSyGOlj6vKWdNpmOSb7/6UFWZhsQyNDCuc5oeIE++giaHVkb0dw24jQeYSfnYJDDW8WVxjomlheuI1RIq66xIkkqb1x8wdQXxEPUyV8MHgJTDuG52RYQbBHsmYXhAoGBANdMvgWcistAqUdwkhuXSE97ZzHLeQWi6ulJqFrxB5u2FG9KyksntTy62tqbivhJGRVm2d8cs0VPHCYd3yE1ErAGFZhz5eSQZGT6NUz0RN7VQF9nD54IUYH+JqwqDNN/K/NqdMQI/w1B24LYEZ4sZoB6E8HUODsWD5ijUiYw6E+o";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4sTLqXdgCMi4xku5HvBeyr6SUmB3rFjS/dQ4UPd9pisZtqzsVjq/I905BLzhk+H1Ofwxh5rX77JRn/PwsfO+qQB8Yzalr+AoMrYsNTeTZcWh41mIdRwkrMQw8HLNDJjwCi77JDIIJ9lLZK0xDIm4NCh4tFCqD/7f9J+ZGjv6weyS6rJD2adsFICxBVZRGt+RvBcMz0Sb/6cH16LMy3qpxLdEqc/3NaigBNGI/Sr6olTndICZLtvuF+Q5MixmDfcvcS+JexpPz9caQ6IJjMDvHGZlc/npdMH8JyzEf9PRtWuHOgjfW+O2W37au2Dlg10vRw5gvevcWbahcBwbO8E4wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://acsk.free.idcfengye.com/car/alipayNotify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://acsk.free.idcfengye.com/car/alipayReturnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 字符编码格式
    public static String format = "JSON";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

