package com.yupi.springbootinit.model.dto.chart;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Tom Smile
 * @version 1.0
 * @description: 生成图表需传入参数
 * @date 2024/6/8 21:54
 */
@Data
public class GenChartByAiRequest implements Serializable {
    /**
     * 指定图表（提示词）
     */
    private String goal;

    /**
     * 指定生成图表的类型
     */
    private String chartType;

    /**
     * 指定图表的名称
     */
    private String chartName;

    private static final long serialVersionUID = 1L;

}
