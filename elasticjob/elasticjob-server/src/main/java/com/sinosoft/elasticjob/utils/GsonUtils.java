package com.sinosoft.elasticjob.utils;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

public class GsonUtils {

    public static String toJson(Object obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return json;
    }

    public static <T> T  fromJson(String json, Class<T> clazz){
        if(StringUtils.isEmpty(json)){
            return null;
        }
        Gson gson = new Gson();
        T t = gson.fromJson(json, clazz);
        return t;
    }

    /**
     *
     * @param json
     * @param typeOfT 格式： new TypeToken<List<MdBaseDrug>>(){}.getType()
     * @param <T>
     * @return T
     */
    public static <T> T fromJson(String json, Type typeOfT){
        if(StringUtils.isEmpty(json)){
            return null;
        }
        Gson gson = new Gson();
        T t = gson.fromJson(json, typeOfT);
        return t;
    }

}
