package com.example.antd.antd_pro.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserAddVo {
    private String username;
    private String password;
    private String phone;
    private String email;
    private List<Avatar> avatar;

    @Data
    public static class Avatar {
        private String name;
        private Response response;

        @Data
        public static class Response {
            private int code;
            private String imageUrl;
            private String msg;
        }
    }
}
