package com.sinosoft.elasticsearch.config.es;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: cz
 * @Date: 2020/8/10
 * @Description:
 */
public abstract class SearchQueryEngine<T> {

    @Autowired
    protected ElasticsearchTemplate elasticsearchTemplate;

    public abstract int saveOrUpdate(String indexName,List<T> list) throws Exception;

    protected Document getDocument(T t) throws Exception{
        Document annotation = t.getClass().getAnnotation(Document.class);
        if (annotation == null) {
            throw new Exception("Can't find annotation @Document on " + t.getClass().getName());
        }
        return annotation;
    }

    /**
     * 获取字段名，若设置column则返回该值
     *
     * @param field
     * @param column
     * @return
     */
    protected String getFieldName(Field field, String column) {
        return StringUtils.isNotBlank(column) ? column : field.getName();
    }

    /**
     * 设置属性值
     *
     * @param field
     * @param obj
     * @param value
     */
    protected void setFieldValue(Field field, Object obj, Object value) throws Exception{
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        try {
            switch (field.getType().getSimpleName()) {
                case "BigDecimal":
                    field.set(obj, new BigDecimal(value.toString()).setScale(5, BigDecimal.ROUND_HALF_UP));
                    break;
                case "Long":
                    field.set(obj, new Long(value.toString()));
                    break;
                case "Integer":
                    field.set(obj, new Integer(value.toString()));
                    break;
                case "Date":
                    field.set(obj, new Date(Long.valueOf(value.toString())));
                    break;
                default:
                    field.set(obj, value);
            }
        } catch (IllegalAccessException e) {
            throw new Exception(e);
        } finally {
            field.setAccessible(isAccessible);
        }
    }

    /**
     * 获取字段值
     *
     * @param field
     * @param obj
     * @return
     */
    protected Object getFieldValue(Field field, Object obj) throws Exception{
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            throw new Exception(e);
        } finally {
            field.setAccessible(isAccessible);
        }
    }

    /**
     * 转换为es识别的value值
     *
     * @param value
     * @return
     */
    protected Object formatValue(Object value) {
        if (value instanceof Date) {
            return ((Date) value).getTime();
        } else {
            return value;
        }
    }

    /**
     * 获取索引分区数
     *
     * @param t
     * @return
     */
//    protected int getNumberOfShards(T t) throws Exception{
//        return Integer.parseInt(elasticsearchTemplate.getSetting(getDocument(t).index()).get(IndexMetaData.SETTING_NUMBER_OF_SHARDS).toString());
//    }

}
