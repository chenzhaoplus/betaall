package com.taiyangguo.springtemplate.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.Closeable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
//@Component
public class PrestoJdbc implements Closeable {

    private Boolean isActive;

    /**
     * 定义连接
     */
    private Connection conn;
    /**
     * 定义STMT
     */
    private PreparedStatement stmt;
    /**
     * 定义结果集
     */
    private ResultSet rs;

//    private volatile static JdbcUtil instance = null;

    public PrestoJdbc(PrestoJdbcProperties props){
        try {
            Class.forName(props.getDriverClassName());
            if (!StringUtils.isEmpty(props.getPassword())) {
                conn = DriverManager.getConnection(props.getJdbcUrl(), props.getUsername(), props.getPassword());
            } else {
                conn = DriverManager.getConnection(props.getJdbcUrl(), props.getUsername(), null);
            }
        } catch (ClassNotFoundException e) {
            log.error("[驱动加载失败], error = {}", e);
        } catch (SQLException e) {
            log.error("[数据库链接异常], error = {}", e);
        }
    }

//    public static JdbcUtil getInstance(PrestoJdbcProperties props){
//        if(instance == null){
//            synchronized (JdbcUtil.class) {
//                if(instance == null){
//                    instance = new JdbcUtil();
//                    try {
//                        Class.forName(props.getDriverClassName());
//                        if (StringUtils.isNotBlank(props.getPassword())) {
//                            conn = DriverManager.getConnection(props.getJdbcUrl(), props.getUsername(), props.getPassword());
//                        } else {
//                            conn = DriverManager.getConnection(props.getJdbcUrl(), props.getUsername(), null);
//                        }
//                    } catch (ClassNotFoundException e) {
//                        log.error("[驱动加载失败], error = {}", e);
//                    } catch (SQLException e) {
//                        log.error("[数据库链接异常], error = {}", e);
//                    }
//                }
//            }
//        }
//        return instance;
//    }

    /**
     * 获取链接
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * 关闭链接,释放资源
     */
    @Override
    public void close() {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
//            if (conn != null) {
//                conn.close();
//                conn = null;
//            }
        } catch (SQLException e) {
            System.err.println("资源释放发生异常");
        }
    }

    /**
     * 获取指定数据库下所有的表名
     *
     * @param dbNm
     * @return
     */
    public List<String> getAllTableName(String dbNm) {
        List<String> result = new ArrayList<String>();
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES  WHERE TABLE_SCHEMA='" + dbNm + "'");
            while (rs.next()) {
                result.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            if (st != null) {
//                try {
//                    st.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
            close();
        }
        return result;
    }

    /**
     * 执行SQL返回ResultSet
     */
    public ResultSet execute(String sql, Object... args) {
        try {
            rs = executeSql(sql, args);
        } finally {
            close();
        }
        return rs;
    }

    private ResultSet executeSql(String sql, Object... args) {
        try {
            stmt = conn.prepareStatement(sql);
            if (null != args && args.length != 0) {
                for (int i = 0; i < args.length; i++) {
                    stmt.setObject(i + 1, args[i]);
                }
            }

            rs = stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("数据查询异常");
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * @title 查询数据结果 , 并封装为对象
     * @author Xingbz
     */
    public <T> T excuteQuery(Class<T> klass, String sql, Object... args) {
        try {
            rs = executeSql(sql, args);
            ResultSetMetaData metaData = rs.getMetaData();

            Map<String, Object> resultMap = new HashMap<>();
            if (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String columnname = metaData.getColumnLabel(i);
                    Object obj = rs.getObject(i);
                    resultMap.put(columnname, obj);
                }
            }

            return JSON.parseObject(JSON.toJSONString(resultMap), klass);
        } catch (Exception e) {
            System.err.println("数据查询异常");
            e.printStackTrace();
        } finally {
            close();
        }
        return JSON.toJavaObject(new JSONObject(), klass);
    }

    /**
     * @title 查询数据结果 , 并封装为List
     * @author Xingbz
     */
    public <T> List<T> excuteQueryToList(Class<T> klass, String sql, Object... args) {
        try {
            rs = executeSql(sql, args);
            List<Map<String, String>> resultList = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> resultMap = new HashMap<>();
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    resultMap.put(metaData.getColumnName(i), rs.getString(i));
                }
                resultList.add(resultMap);
            }

            return JSON.parseArray(JSON.toJSONString(resultList), klass);
        } catch (Exception e) {
            System.err.println("数据查询异常");
        } finally {
            close();
        }
        return JSON.parseArray("[]", klass);
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

}
