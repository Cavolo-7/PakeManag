package com.auc.face.mapper;


import com.auc.face.dto.FaceUserInfo;
import com.auc.face.pojo.UserFaceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jerry
 */
@Mapper
@Repository  //将这个类注入spring容器
public interface UserFaceInfoMapper {

    /**
     *  获取用户全部信息
     * @return
     */
    List <UserFaceInfo> findUserFaceInfoList();


    /**
     *  新增用户信息
     * @param userFaceInfo
     * @return
     */
    int insertUserFaceInfo(UserFaceInfo userFaceInfo);

    /**
     *  根据分组id获取用户信息
     * @param groupId
     * @return
     */
    List<FaceUserInfo> getUserFaceInfoByGroupId(Integer groupId);

}
