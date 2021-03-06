package com.taiyangguo.mybatisgenerator.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGeneration2 {
    private final static String OUT_PUT_DIR="D://CodeGeneration";
//    private final static String DB_URL="jdbc:mysql://datasource.sinosoft.com:3306/mysql";
//    private final static String DRIVE_NAME="com.mysql.jdbc.Driver";
//    private final static DbType DB_TYPE=DbType.MYSQL;
//    private final static String DB_USER_NAME="phis";
//    private final static String DB_PWD="phis123456";

//    private final static DbType DB_TYPE=DbType.ORACLE;
//    private final static String DRIVE_NAME="oracle.jdbc.driver.OracleDriver";
//    private final static String DB_URL="jdbc:oracle:thin:@10.18.103.38:1521/ORCLDEV";
//    private final static String DB_USER_NAME="phis";
//    private final static String DB_PWD="phis123456";

    private final static DbType DB_TYPE=DbType.ORACLE;
    private final static String DRIVE_NAME="oracle.jdbc.driver.OracleDriver";
    private final static String DB_URL="jdbc:oracle:thin:@10.18.103.38:1521/ORCLDEV";
    private final static String DB_USER_NAME="YSYYAPP";
    private final static String DB_PWD="YSYYAPP";

//    private final static DbType DB_TYPE=DbType.ORACLE;
//    private final static String DRIVE_NAME="oracle.jdbc.driver.OracleDriver";
//    private final static String DB_URL="jdbc:oracle:thin:@10.18.103.38:1521/ORCLDEV";
//    private final static String DB_USER_NAME="YSYYAPP";
//    private final static String DB_PWD="YSYYAPP";

//    private final static String DB_URL="jdbc:mysql://v71:3306/nurs-service";
//    private final static String DRIVE_NAME="com.mysql.jdbc.Driver";
//    private final static DbType DB_TYPE=DbType.MYSQL;
//    private final static String DB_USER_NAME="root";
//    private final static String DB_PWD="123";

    private static String[] tableNames = new String[] { "nurs_item" };
    private final static String PACKAGE_PARENT="com.sevenx.imdb";
    private final static String PACKAGE_CONTROLLER="web";
    private final static String PACKAGE_SERVICE="service";
    private final static String PACKAGE_SERVICE_IMPL="service.impl";
    private final static String PACKAGE_MAPPER="mapper";
    private final static String PACKAGE_ENTITY="entity";
    private final static String PACKAGE_XML="boot";

    /**
     *
     * @Title: main
     * @Description: ??????
     * @param args
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // ????????????
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(OUT_PUT_DIR);//??????????????????
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// ?????????ActiveRecord??????????????????false
        gc.setEnableCache(false);// XML ????????????
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("cz");// ??????

        // ?????????????????????????????? %s ?????????????????????????????????
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // ???????????????
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DB_TYPE);
        dsc.setDriverName(DRIVE_NAME);
        dsc.setUsername(DB_USER_NAME);
        dsc.setPassword(DB_PWD);
        dsc.setUrl(DB_URL);
        mpg.setDataSource(dsc);

        // ????????????
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(new String[] { "sys_" });// ????????????????????????????????????
        strategy.setNaming(NamingStrategy.underline_to_camel);// ??????????????????
        strategy.setInclude(tableNames); // ??????????????????

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        // ?????????
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_PARENT);
        pc.setController(PACKAGE_CONTROLLER);
        pc.setService(PACKAGE_SERVICE);
        pc.setServiceImpl(PACKAGE_SERVICE_IMPL);
        pc.setMapper(PACKAGE_MAPPER);
        pc.setEntity(PACKAGE_ENTITY);
        pc.setXml(PACKAGE_XML);
        mpg.setPackageInfo(pc);

        // ????????????
        mpg.execute();

    }
}
