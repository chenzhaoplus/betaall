package com.sinosoft.elasticjob.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ReturnDataInfo<T> implements Serializable {

    private boolean flag = false;
    private String message;
    private Integer statusCode = 200;
    private T result;
    private Long totalCount;
    private List<T> results;
    private Long page;
    private Long pageSize;
    private Long timestamp = new Date().getTime();

    public ReturnDataInfo() {
    }

    public ReturnDataInfo(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public boolean isFlag() {
        return this.flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public static <T> ReturnDataInfo<T> createSuccessfulSingleExecuteResult(T entry) {
        ReturnDataInfo<T> info = new ReturnDataInfo<T>();
        info.setFlag(true);
        info.setResult(entry);
        info.setTotalCount(Long.valueOf(1));
        return info;
    }

    public static <T> ReturnDataInfo<T> createSuccessfulExecuteResults(List<T> entry) {
        ReturnDataInfo<T> info = new ReturnDataInfo<T>();
        info.setFlag(true);
        info.setResults(entry);
        info.setTotalCount(Long.valueOf(entry == null ? 0 : entry.size()));
        return info;
    }

    public static <T> ReturnDataInfo<T> createSuccessfulExecuteResults(List<T> entry, Long page, Long pageSize, Long totalCount) {
        ReturnDataInfo<T> info = new ReturnDataInfo<T>();
        info.setFlag(true);
        info.setResults(entry);
        info.setPageSize(page);
        info.setPage(pageSize);
        info.setTotalCount(totalCount);
        return info;
    }

    public static <T> ReturnDataInfo<T> createFailedExecuteResult(String message) {
        ReturnDataInfo<T> info = new ReturnDataInfo<T>();
        info.setFlag(false);
        info.setStatusCode(500);
        info.setMessage(message);
        return info;
    }

    public static <T> ReturnDataInfo<T> createFailedExecuteResult(Integer statusCode, String message) {
        ReturnDataInfo<T> info = new ReturnDataInfo<T>();
        info.setFlag(false);
        info.setStatusCode(statusCode);
        info.setMessage(message);
        return info;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ReturnDataInfo{" +
                "flag=" + flag +
                ", message='" + message + '\'' +
                ", statusCode=" + statusCode +
                ", result=" + result +
                ", totalCount=" + totalCount +
                ", results=" + results +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", timestamp=" + timestamp +
                '}';
    }
}
