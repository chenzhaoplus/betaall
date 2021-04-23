package com.sinosoft.elasticsearch.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class EmpiMiddleSearchDto implements Serializable {

    /**
     *  主键
     */
    private String id;

    /**
     * 内容
     */
    private String content;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    private String createTime;

    private String sameSimilar;

}
