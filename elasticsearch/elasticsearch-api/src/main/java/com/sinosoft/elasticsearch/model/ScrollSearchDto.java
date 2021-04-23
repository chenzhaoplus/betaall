package com.sinosoft.elasticsearch.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class ScrollSearchDto<T> implements Serializable {
    List<T> contentList;
    String scrollId;
    Long page;
    Long pageSize;
    Long totalElements;
}
