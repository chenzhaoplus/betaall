package com.sinosoft.elasticsearch.boot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Document(indexName = "empi_middle", type = "doc", shards = 1, replicas = 0)
@Setting(settingPath = "UnderlineAnalyzer.json")
public class EmpiMiddleSearch implements Serializable {
    /**
     *  主键
     */
    @Field(name = "id", type = FieldType.Text)
    @Id
    private String id;

    /**
     * 内容
     */
    @Field(name = "content", type = FieldType.Text, analyzer = "underline")
//    @Field(name = "content", type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
//    @Field(name = "content", type = FieldType.Text)
    private String content;

    /**
     * 状态
     */
    @Field(name = "status", type = FieldType.Text)
    private String status;

    /**
     * 创建时间
     */
//    @Field(name = "create_time", type = FieldType.Date, pattern = "strict_date_optional_time||epoch_millis", format = DateFormat.custom)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    private Date createTime;
    @Field(name = "create_time", type = FieldType.Text)
    private String createTime;

    @Field(name = "same_similar", type = FieldType.Text)
    private String sameSimilar;

}
