package com.example.antd.antd_pro.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.antd.antd_pro.constant.ErrorEnum;
import com.example.antd.antd_pro.entity.UserEntity;
import com.example.antd.antd_pro.service.UserService;
import com.example.antd.antd_pro.utils.R;
import com.example.antd.antd_pro.vo.UserAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("list")
    public R list(@RequestParam Map<String, Object> params) {
        Page<UserEntity> userPage = userService.getUserList(params);
        return R.ok().put("userPage", userPage);
    }

    @PostMapping("login")
    public R login(@RequestBody UserEntity userEntity) {
        String message = userService.login(userEntity);
        if (message.equals(ErrorEnum.USERNAME_AND_PASSWORD_CANNOT_BE_EMPTY.getMessage())) {
            return R.error(ErrorEnum.USERNAME_AND_PASSWORD_CANNOT_BE_EMPTY.getCode(), ErrorEnum.USERNAME_AND_PASSWORD_CANNOT_BE_EMPTY.getMessage());
        } else if (message.equals(ErrorEnum.WRONG_USER_NAME_OR_PASSWORD.getMessage())) {
            return R.error(ErrorEnum.WRONG_USER_NAME_OR_PASSWORD.getCode(), ErrorEnum.WRONG_USER_NAME_OR_PASSWORD.getMessage());
        } else if (message.equals(ErrorEnum.USER_IS_DISABLED.getMessage())) {
            return R.error(ErrorEnum.USER_IS_DISABLED.getCode(), ErrorEnum.USER_IS_DISABLED.getMessage());
        } else {
            return R.ok().put("token", message);
        }
    }

    @GetMapping("currentUser")
    public R currentUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (!StringUtils.isEmpty(token)) {
            UserEntity userEntity = userService.getUserInfoByToken(token);
            if (userEntity != null) {
                return R.ok().put("userInfo", userEntity);
            }
        }
        return R.error("请先登录");
    }

    @PostMapping("outLogin")
    public R outLogin(@RequestParam("username") String username) {
        userService.outLogin(username);
        return R.ok();
    }

    @GetMapping("iKunCount")
    public R iKunCount() {
        long count = userService.iKunCount();
        return R.ok().put("count", count);
    }

    @PutMapping("{uid}/updateStatus")
    public R updateStatus(@PathVariable("uid") String uid) {
        userService.updateStatus(uid);
        return R.ok();
    }

    @PostMapping("/add")
    public R addUser(@RequestBody UserAddVo userAddVo) {
        try {
            userService.addUser(userAddVo);
            return R.ok();
        } catch (Exception e) {
            return R.error(ErrorEnum.FAILED_TO_ADD_USER.getCode(), ErrorEnum.FAILED_TO_ADD_USER.getMessage());
        }
    }

    @GetMapping("/{uid}")
    public R getUserInfo(@PathVariable("uid") String uid) {
        UserEntity user = userService.getById(uid);
        return R.ok().put("userInfo", user);
    }

    @PutMapping("/{uid}/update")
    public R updateUser(@PathVariable("uid") String uid, @RequestBody UserAddVo userAddVo) {
        try {
            userService.updateUser(uid, userAddVo);
            return R.ok();
        } catch (Exception e) {
            return R.error(ErrorEnum.FAILED_TO_UPDATE_USER.getCode(), ErrorEnum.FAILED_TO_UPDATE_USER.getMessage());
        }
    }
}
