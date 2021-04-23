package com.taiyangguo.mybatisgenerator.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerationSmcaiot {
    private final static String OUT_PUT_DIR="D://CodeGeneration";

    private final static String DB_URL="jdbc:mysql://172.16.4.83:3306/ibmp";
    private final static String DRIVE_NAME="com.mysql.jdbc.Driver";
    private final static DbType DB_TYPE=DbType.MYSQL;
    private final static String DB_USER_NAME="ibmp_test";
    private final static String DB_PWD="XZdfjXIEsrumGrfFTmfltbtAuQCECUdl";

    private static String[] tableNames = new String[] { "control_task","control_task_community","control_task_face","control_alarm_record" };
    private final static String PACKAGE_PARENT="com.smcaiot.control";
    private final static String PACKAGE_CONTROLLER="controller";
    private final static String PACKAGE_SERVICE="service";
    private final static String PACKAGE_SERVICE_IMPL="service.impl";
    private final static String PACKAGE_MAPPER="mapper";
    private final static String PACKAGE_ENTITY="entity";
    private final static String PACKAGE_XML=PACKAGE_MAPPER+"."+"xml";

    /**
     *
     * @Title: main
     * @Description: 生成
     * @param args
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(OUT_PUT_DIR);//输出文件路径
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("cz");// 作者

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DB_TYPE);
        dsc.setDriverName(DRIVE_NAME);
        dsc.setUsername(DB_USER_NAME);
        dsc.setPassword(DB_PWD);
        dsc.setUrl(DB_URL);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(tableNames); // 需要生成的表

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_PARENT);
        pc.setController(PACKAGE_CONTROLLER);
        pc.setService(PACKAGE_SERVICE);
        pc.setServiceImpl(PACKAGE_SERVICE_IMPL);
        pc.setMapper(PACKAGE_MAPPER);
        pc.setEntity(PACKAGE_ENTITY);
        pc.setXml(PACKAGE_XML);
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();

    }
}
