package com.sinosoft.elasticjob.boot.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.TableId;
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
* @since 2020-05-08
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("T_EMPI_MIDDLE")
    public class TEmpiMiddle implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("ID")
    private String id;

        @TableField("STATUS")
    private String status;

        @TableField("CONTENT")
    private String content;

        @TableField("CREATE_TIME")
    private LocalDateTime createTime;

        @TableField("SAME_SIMILAR")
    private String sameSimilar;

        @TableField("MODIFY_DATE")
    private LocalDateTime modifyDate;


}
