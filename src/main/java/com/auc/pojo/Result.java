package com.auc.pojo;

/**
 * @基本功能:  车牌识别接口返回参数车牌相关信息
 * @program:
 * @author:acsk
 * @create:2020-09-08 09:51:21
 **/
public class Result {

    private String log_id;//请求标识码，随机数，唯一
    private String error_msg;//错误信息
    private String error_code;//错误代码
    private WordsResult words_result;//查询结果信息（车牌相关信息）

    public Result() {
    }

    public Result(String log_id, String error_msg, String error_code, WordsResult words_result) {
        this.log_id = log_id;
        this.error_msg = error_msg;
        this.error_code = error_code;
        this.words_result = words_result;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public WordsResult getWords_result() {
        return words_result;
    }

    public void setWords_result(WordsResult words_result) {
        this.words_result = words_result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "log_id=" + log_id +
                ", error_msg='" + error_msg + '\'' +
                ", error_code=" + error_code +
                ", words_result=" + words_result +
                '}';
    }
}