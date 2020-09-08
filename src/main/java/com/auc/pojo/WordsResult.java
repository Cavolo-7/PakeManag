package com.auc.pojo;

import java.util.Arrays;

/**
 * @基本功能:  车牌识别接口返回参数
 * @program:
 * @author:acsk
 * @create:2020-09-08 09:56:31
 **/
public class WordsResult {

    private String color;//车牌颜色（支持blue、green、yellow）
    private String number;//车牌号
    private String[] probability;//车牌中每个字符的置信度
    private String[] vertexes_location;//返回文字外接多边形顶点位置

    public WordsResult() {
    }

    public WordsResult(String color, String number, String[] probability, String[] vertexes_location) {
        this.color = color;
        this.number = number;
        this.probability = probability;
        this.vertexes_location = vertexes_location;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String[] getProbability() {
        return probability;
    }

    public void setProbability(String[] probability) {
        this.probability = probability;
    }

    public String[] getVertexes_location() {
        return vertexes_location;
    }

    public void setVertexes_location(String[] vertexes_location) {
        this.vertexes_location = vertexes_location;
    }

    @Override
    public String toString() {
        return "WordsResult{" +
                "color='" + color + '\'' +
                ", number='" + number + '\'' +
                ", probability=" + Arrays.toString(probability) +
                ", vertexes_location=" + Arrays.toString(vertexes_location) +
                '}';
    }
}