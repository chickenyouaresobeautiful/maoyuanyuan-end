package com.example.antd.antd_pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.antd.antd_pro.constant.ErrorEnum;
import com.example.antd.antd_pro.constant.TokenConstant;
import com.example.antd.antd_pro.entity.UserEntity;
import com.example.antd.antd_pro.service.UserService;
import com.example.antd.antd_pro.mapper.UserMapper;
import com.example.antd.antd_pro.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author admin
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-02-24 16:28:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String login(UserEntity userEntity) {
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return ErrorEnum.USERNAME_AND_PASSWORD_CANNOT_BE_EMPTY.getMessage();
        }
        UserEntity loginUserEntity = this.getOne(
                new QueryWrapper<UserEntity>()
                        .eq("username", username)
                        .eq("password", password)
        );
        if (loginUserEntity == null) {
            return ErrorEnum.WRONG_USER_NAME_OR_PASSWORD.getMessage();
        }
        if (loginUserEntity.getStatus() == 1) {
            return ErrorEnum.USER_IS_DISABLED.getMessage();
        }
        String token = JwtUtils.generateToken(username);
        redisTemplate.opsForValue().set(TokenConstant.REDIS_TOKEN_PRE + username, token, TokenConstant.EXPIRATION_TIME, TimeUnit.MILLISECONDS);
        return token;
    }

    @Override
    public UserEntity getUserInfoByToken(String token) {
        String username = JwtUtils.getUsernameFromToken(token);
        String redisToken = redisTemplate.opsForValue().get(TokenConstant.REDIS_TOKEN_PRE + username);
        if (!StringUtils.isEmpty(redisToken)) {
            return this.getOne(new QueryWrapper<UserEntity>().eq("username", username));
        }
        return null;
    }

    @Override
    public void outLogin(String username) {
        redisTemplate.delete(TokenConstant.REDIS_TOKEN_PRE + username);
    }

    @Override
    public long iKunCount() {
        return this.count();
    }

    @Override
    public Page<UserEntity> getUserList(Map<String, Object> params) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        if (params.get("username") != null) {
            String username = params.get("username").toString();
            queryWrapper.eq("username", username);
        }
        if (params.get("email") != null) {
            String email = params.get("email").toString();
            queryWrapper.eq("email", email);
        }
        if (params.get("phone") != null) {
            String phone = params.get("phone").toString();
            queryWrapper.eq("phone", phone);
        }
        long current = Long.parseLong(params.get("current").toString());
        long pageSize = Long.parseLong(params.get("pageSize").toString());
        Page<UserEntity> page = this.page(new Page<>(current, pageSize), queryWrapper);
        page.setTotal(page.getRecords().size());
        return page;
    }

    @Override
    public void updateStatus(String uid) {
        UserEntity user = this.getById(uid);
        if (user.getStatus() == 0) {
            user.setStatus(1);
        } else {
            user.setStatus(0);
        }
        this.updateById(user);
    }
}




