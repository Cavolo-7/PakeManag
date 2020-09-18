package com.auc.face.dto;

import com.auc.face.pojo.UserFaceInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jerry
 */
@Getter
@Setter
public class FaceUserInfo extends UserFaceInfo {

    private String faceId;
    private String name;
    private Integer similarValue;
    private byte[] faceFeature;

    @Override
    public String getFaceId() {
        return faceId;
    }

    @Override
    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Integer getSimilarValue() {
        return similarValue;
    }

    public void setSimilarValue(Integer similarValue) {
        this.similarValue = similarValue;
    }

    @Override
    public byte[] getFaceFeature() {
        return faceFeature;
    }

    @Override
    public void setFaceFeature(byte[] faceFeature) {
        this.faceFeature = faceFeature;
    }
}
