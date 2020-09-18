package com.auc.face.service.impl;

import com.auc.face.mapper.UserFaceInfoMapper;
import com.auc.face.pojo.UserFaceInfo;
import com.auc.face.service.UserFaceInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jerry
 */
@Service
public class UserFaceInfoServiceImpl implements UserFaceInfoService {

    @Resource
    private UserFaceInfoMapper userFaceInfoMapper;

    @Override
    public int insertSelective(UserFaceInfo userFaceInfo) {
        int result = userFaceInfoMapper.insertUserFaceInfo(userFaceInfo);
        if (result > 0) {
            return result;
        }
        return 0;
    }

    @Override
    public List<UserFaceInfo> findUserFaceInfoList() {
        return userFaceInfoMapper.findUserFaceInfoList();
    }
}
