package com.sinosoft.elasticjob.utils;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGeneration {

//    private final static String DB_URL="jdbc:mysql://10.18.103.31:3306/gl?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
//    private final static String DRIVE_NAME="com.mysql.jdbc.Driver";
//    private final static String DB_USER_NAME="zyycs";
//    private final static String DB_PWD="123456";

//    private final static String DB_URL="jdbc:oracle:thin:@10.18.103.38:1521/ORCLDEV";
//    private final static String DRIVE_NAME="oracle.jdbc.driver.OracleDriver";
//    private final static String DB_USER_NAME="hbzyyapp";
//    private final static String DB_PWD="hbzyyapp123456";

//    private final static String DB_URL="jdbc:oracle:thin:@10.18.103.36:1521/orclcs";
//    private final static String DRIVE_NAME="oracle.jdbc.driver.OracleDriver";
//    private final static String DB_USER_NAME="TCMRT";
//    private final static String DB_PWD="tcm123456";

    private final static String DB_URL="jdbc:oracle:thin:@10.18.103.170:1521:orclcdr";
    private final static String DRIVE_NAME="oracle.jdbc.driver.OracleDriver";
    private final static String DB_USER_NAME="sinosoft_empi_standard_server";
    private final static String DB_PWD="sinosoft";

    private final static String OUT_PUT_DIR = "/elasticjob-server/src/main/java";
    private final static String PACKAGE_PARENT="com.sinosoft.elasticjob";
    private final static String RESOURCES_DIR = "/elasticjob-server/src/main/resources/mapper/";

    /**
     * <p>
     * ?????????????????????
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("?????????" + tip + "???");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("??????????????????" + tip + "???");
    }

    public static void main(String[] args) {
        // ???????????????
        AutoGenerator mpg = new AutoGenerator();

        // ????????????
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + OUT_PUT_DIR);
        gc.setAuthor("sinosoft");
        gc.setOpen(false);

        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        // gc.setSwagger2(true); ???????????? Swagger2 ??????
        mpg.setGlobalConfig(gc);

        // ???????????????
        DataSourceConfig dsc = new DataSourceConfig();
        //dsc.setUrl("jdbc:mysql://datasource.sinosoft.com:3306/db?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        // dsc.setSchemaName("public");
        dsc.setUrl(DB_URL);
        dsc.setDriverName(DRIVE_NAME);
        dsc.setUsername(DB_USER_NAME);
        dsc.setPassword(DB_PWD);
        mpg.setDataSource(dsc);

        // ?????????
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("?????????"));
        pc.setParent(PACKAGE_PARENT);
        mpg.setPackageInfo(pc);

        // ???????????????
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // ????????????????????? freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // ????????????????????? velocity
        // String templatePath = "/templates/mapper.mapper.vm";

        // ?????????????????????
        List<FileOutConfig> focList = new ArrayList<>();
        // ?????????????????????????????????
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // ???????????????????????? ??? ????????? Entity ????????????????????????????????? mapper ????????????????????????????????????
                return projectPath + RESOURCES_DIR + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // ??????????????????????????????????????????
                checkDir("?????????????????????????????????");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // ????????????
        TemplateConfig templateConfig = new TemplateConfig();

        // ???????????????????????????
        //????????????????????????????????????????????????.ftl/.vm, ??????????????????????????????????????????
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // ????????????
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // ????????????
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // ??????????????????????????????
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("?????????????????????????????????").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}

