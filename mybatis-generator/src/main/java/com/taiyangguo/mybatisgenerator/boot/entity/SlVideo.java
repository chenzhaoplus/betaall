package com.taiyangguo.mybatisgenerator.boot.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author sinosoft
 * @since 2020-02-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SlVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("VID")
    private Integer vid;

    @TableField("ORGFILENAME")
    private String orgfilename;

    @TableField("USERFILENAME")
    private String userfilename;

    @TableField("TYPE")
    private Integer type;

    @TableField("UPLOADURL")
    private String uploadurl;

    @TableField("SNAPSHOTURL")
    private String snapshoturl;

    @TableField("XNOSTOKEN")
    private String xnostoken;

    @TableField("CODE")
    private Integer code;

    @TableField("MSG")
    private String msg;

    @TableField("STATUS")
    private String status;

    @TableField("DESCRIPTION")
    private String description;

    @TableField("ISRELEASE")
    private Integer isrelease;

    @TableField("SNAPLOCALURL")
    private String snaplocalurl;

    @TableField("UUID")
    private String uuid;

    @TableField("CREATER")
    private String creater;

    @TableField("CREATETIME")
    private LocalDateTime createtime;

    @TableField("UPDATER")
    private String updater;

    @TableField("UPDATETIME")
    private LocalDateTime updatetime;


}
