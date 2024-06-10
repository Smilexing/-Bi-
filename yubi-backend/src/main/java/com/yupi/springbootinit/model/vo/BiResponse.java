package com.yupi.springbootinit.model.vo;

import lombok.Data;

/**
 * @author Tom Smile
 * @version 1.0
 * @description: 返回给前端的Ai调用结果
 * @date 2024/6/9 19:22
 */
@Data
public class BiResponse {
    private String genChart;
    private String genResult;
    private Long chartId;
}
