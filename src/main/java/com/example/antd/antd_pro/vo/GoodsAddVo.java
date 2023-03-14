package com.example.antd.antd_pro.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class GoodsAddVo {
    private List<Long> catId;
    private String description;
    private String details;
    private BigDecimal price;
    private Integer stock;
    private String title;
    private List<Cover> cover;

    @Data
    public static class Cover {
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
