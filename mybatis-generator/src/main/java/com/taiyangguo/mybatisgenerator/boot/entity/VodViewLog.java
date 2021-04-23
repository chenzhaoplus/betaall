package com.taiyangguo.mybatisgenerator.boot.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 点播记录表
 * </p>
 *
 * @author sinosoft
 * @since 2020-02-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VodViewLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;
    /**
     * 点播者id
     */
    private String userId;

    /**
     * 视频id
     */
    private String vid;

    /**
     * 是否删除(0=未删除,1=已删除)
     */
    private Integer dr;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改者
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
