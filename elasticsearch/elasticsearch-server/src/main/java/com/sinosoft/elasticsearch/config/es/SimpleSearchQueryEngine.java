package com.sinosoft.elasticsearch.config.es;

import com.sinosoft.elasticsearch.boot.constants.Constants;
import com.sinosoft.elasticsearch.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.update.UpdateRequest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ScrolledPage;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: cz
 * @Date: 2020/8/10
 * @Description:
 */
@Component
@ComponentScan
@Slf4j
public class SimpleSearchQueryEngine<T> extends SearchQueryEngine<T> {

    private int numberOfRowsPerScan = 10;

    @Override
    public int saveOrUpdate(String indexName,List<T> list) throws Exception{
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }

        T base = list.get(0);
        Field id = null;
        Field[] allFields = getAllFields(base);
        for (Field field : allFields) {
            BusinessID businessID = field.getAnnotation(BusinessID.class);
            if (businessID != null) {
                id = field;
                break;
            }
        }
        if (id == null) {
            throw new Exception("Can't find @BusinessID on " + base.getClass().getName());
        }

        Document document = getDocument(base);
        List<UpdateQuery> bulkIndex = new ArrayList<>();
        for (T t : list) {
            UpdateQuery updateQuery = new UpdateQuery();
            updateQuery.setIndexName(indexName);
            updateQuery.setType(document.type());
            updateQuery.setId(getFieldValue(id, t).toString());
            String json = GsonUtils.toJson(t);
            Map map = GsonUtils.toMap(json);
            UpdateRequest updateRequest = new UpdateRequest(updateQuery.getIndexName(), updateQuery.getType(),
                    updateQuery.getId()).doc(map);
            updateQuery.setUpdateRequest(updateRequest);
//            updateQuery.setUpdateRequest(new UpdateRequest(updateQuery.getIndexName(), updateQuery.getType(), updateQuery.getId()).doc(JSONObject.toJSONString(t, SerializerFeature.WriteMapNullValue)));
            updateQuery.setDoUpsert(true);
            updateQuery.setClazz(t.getClass());
            bulkIndex.add(updateQuery);
        }
        elasticsearchTemplate.bulkUpdate(bulkIndex);
        return list.size();
    }

    public static Field[] getAllFields(Object o){
        Class c= o.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (c!= null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(c.getDeclaredFields())));
            c= c.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    public <T> ScrolledPage<T> searchScrollPage(String scrollId, SearchQuery searchQuery, Class<T> clazz){
        ScrolledPage<T> scroll;
        if(StringUtils.isBlank(scrollId)){
            scroll = (ScrolledPage<T>) elasticsearchTemplate.startScroll(Constants.SCROLL_TIMEOUT, searchQuery, clazz);
        }else{
            scroll = (ScrolledPage<T>) elasticsearchTemplate.continueScroll(scrollId, Constants.SCROLL_TIMEOUT, clazz);
        }
        log.debug("searchScrollPage ===> 查询总命中数：{}" ,scroll.getTotalElements());
        return scroll;
    }

    public <E> void bulkUpdate(String indexName, List<E> list){
        if(list==null || list.isEmpty()){
            return;
        }
        List<UpdateQuery> bulkIndex = new ArrayList<>();
        for (E t : list) {
            UpdateQuery updateQuery = new UpdateQuery();
            updateQuery.setIndexName(indexName);
            updateQuery.setType("doc");
            updateQuery.setId("id");
//            String s = JSONObject.toJSONString(t, SerializerFeature.WriteMapNullValue);
            String json = GsonUtils.toJson(t);
            Map map = GsonUtils.toMap(json);
            UpdateRequest updateRequest = new UpdateRequest(updateQuery.getIndexName(), updateQuery.getType(),
                    updateQuery.getId()).doc(map);
            updateQuery.setUpdateRequest(updateRequest);
            updateQuery.setDoUpsert(true);
            updateQuery.setClazz(t.getClass());
            bulkIndex.add(updateQuery);
        }
        elasticsearchTemplate.bulkUpdate(bulkIndex);
    }

    public String clearScroll(String scrollId) throws Exception {
        if(StringUtils.isEmpty(scrollId)){
            return "参数 scrollId 不能为空";
        }
        elasticsearchTemplate.clearScroll(scrollId);
        return "Clears the search contexts associated with specified scroll success";
    }

}
