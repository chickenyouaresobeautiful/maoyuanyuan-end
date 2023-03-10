package com.example.antd.antd_pro.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.antd.antd_pro.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.antd.antd_pro.vo.UserAddVo;

import java.util.List;
import java.util.Map;

/**
* @author admin
* @description 针对表【user】的数据库操作Service
* @createDate 2023-02-24 16:28:10
*/
public interface UserService extends IService<UserEntity> {

    String login(UserEntity userEntity);

    UserEntity getUserInfoByToken(String token);

    void outLogin(String username);

    long iKunCount();

    Page<UserEntity> getUserList(Map<String, Object> params);

    void updateStatus(String uid);

    void addUser(UserAddVo userAddVo);

    void updateUser(String uid, UserAddVo userAddVo);
}
