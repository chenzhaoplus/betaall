/*
Navicat MySQL Data Transfer

Source Server         : 10.18.103.31-移动医护测试
Source Server Version : 50614
Source Host           : 10.18.103.31:3306
Source Database       : nurs-service

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2020-02-18 13:06:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for nurs_bill
-- ----------------------------
DROP TABLE IF EXISTS `nurs_bill`;
CREATE TABLE `nurs_bill` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `bill_id` varchar(32) NOT NULL COMMENT '费用id',
  `patient_id` varchar(32) NOT NULL COMMENT '患者id',
  `pai_visit_id` varchar(32) DEFAULT '' COMMENT '住院id',
  `order_id` varchar(32) DEFAULT '' COMMENT '医嘱id',
  `item_id` varchar(32) DEFAULT '' COMMENT '诊疗项目id',
  `amount` float(14,4) DEFAULT NULL COMMENT '诊疗数量',
  `sales_price` decimal(8,3) DEFAULT NULL COMMENT '单价',
  `bill_date` datetime DEFAULT NULL COMMENT '记账日期',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='费用信息表';

-- ----------------------------
-- Table structure for nurs_biologic_sign
-- ----------------------------
DROP TABLE IF EXISTS `nurs_biologic_sign`;
CREATE TABLE `nurs_biologic_sign` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sign_id` varchar(36) NOT NULL COMMENT '体征id',
  `visit_id` varchar(32) NOT NULL COMMENT '患者住院id',
  `check_date` datetime DEFAULT NULL COMMENT '测量日期',
  `nurse_id` varchar(20) DEFAULT NULL,
  `nurse_name` varchar(20) DEFAULT '' COMMENT '责任护士',
  `breathe` varchar(20) DEFAULT '' COMMENT '呼吸次数',
  `pulse` varchar(20) DEFAULT '' COMMENT '脉搏',
  `urine` varchar(20) DEFAULT '' COMMENT '尿量（ml）',
  `shittims` varchar(20) DEFAULT '' COMMENT '大便次数',
  `temperature` varchar(20) DEFAULT '' COMMENT '体温',
  `temperature_type` varchar(20) DEFAULT '' COMMENT '体温测量方式：1=腋下，2=口，3=肛门',
  `blood_pressure` varchar(20) DEFAULT '' COMMENT '血压',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='体征数据表';

-- ----------------------------
-- Table structure for nurs_dict
-- ----------------------------
DROP TABLE IF EXISTS `nurs_dict`;
CREATE TABLE `nurs_dict` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dict_id` varchar(32) NOT NULL COMMENT '字典id',
  `dict_name` varchar(50) DEFAULT '' COMMENT '字典名称',
  `dict_code` varchar(32) DEFAULT '' COMMENT '字典编码',
  `dict_index` int(8) DEFAULT '0' COMMENT '字典排序',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典表';

-- ----------------------------
-- Table structure for nurs_dict_detail
-- ----------------------------
DROP TABLE IF EXISTS `nurs_dict_detail`;
CREATE TABLE `nurs_dict_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dict_detail_id` varchar(32) NOT NULL COMMENT '字典详情id',
  `parent_detail_id` varchar(32) NOT NULL COMMENT '上级节点id',
  `dict_id` varchar(32) NOT NULL COMMENT '字典id',
  `detail_name` varchar(50) DEFAULT '' COMMENT '字典详情名称',
  `dict_code` varchar(32) DEFAULT '' COMMENT '字典编码',
  `dict_index` int(8) DEFAULT '0' COMMENT '字典排序',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典详情表';

-- ----------------------------
-- Table structure for nurs_document
-- ----------------------------
DROP TABLE IF EXISTS `nurs_document`;
CREATE TABLE `nurs_document` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `document_id` varchar(32) NOT NULL COMMENT '文书id',
  `document_category_id` varchar(32) NOT NULL COMMENT '文书分类id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '内容',
  `is_enable` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否启用',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='护理文书表';

-- ----------------------------
-- Table structure for nurs_document_category
-- ----------------------------
DROP TABLE IF EXISTS `nurs_document_category`;
CREATE TABLE `nurs_document_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `document_category_id` varchar(32) NOT NULL COMMENT '文书分类id',
  `parent_category_id` varchar(32) DEFAULT '' COMMENT '父ID',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '' COMMENT '名称',
  `grade` int(11) NOT NULL DEFAULT '0' COMMENT '等级',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='护理文书分类表';

-- ----------------------------
-- Table structure for nurs_document_item
-- ----------------------------
DROP TABLE IF EXISTS `nurs_document_item`;
CREATE TABLE `nurs_document_item` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `document_item_id` varchar(32) NOT NULL COMMENT '文书大项id',
  `document_item_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '' COMMENT '名称',
  `sort` int(8) DEFAULT NULL COMMENT '排序',
  `document_category_id` varchar(32) NOT NULL COMMENT '文书分类id',
  `is_enable` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否启用',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='护理文书大项表';

-- ----------------------------
-- Table structure for nurs_document_item_option
-- ----------------------------
DROP TABLE IF EXISTS `nurs_document_item_option`;
CREATE TABLE `nurs_document_item_option` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `document_item_option_id` varchar(32) NOT NULL COMMENT '文书子项id',
  `document_item_id` varchar(32) NOT NULL COMMENT '文书大项id',
  `option_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '' COMMENT '子项名称',
  `option_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '' COMMENT '拼音名称（重要）',
  `option_type` tinyint(4) NOT NULL COMMENT '子项类型（1:文本、2:下拉、3:单选、4:多选、5:日期、6:多行文本）',
  `type_val` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '' COMMENT '类型值',
  `verify` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '|' COMMENT '校验规则：（required|datetime）',
  `sort` int(8) DEFAULT NULL COMMENT '排序',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='护理文书子项表';

-- ----------------------------
-- Table structure for nurs_document_item_option_data
-- ----------------------------
DROP TABLE IF EXISTS `nurs_document_item_option_data`;
CREATE TABLE `nurs_document_item_option_data` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `document_item_option_data_id` varchar(32) NOT NULL COMMENT '文书子项数值id',
  `document_id` varchar(32) NOT NULL COMMENT '文书id',
  `document_item_option_id` varchar(32) NOT NULL COMMENT '文书子项id',
  `option_value` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '参数值',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='护理文书子项数值表';

-- ----------------------------
-- Table structure for nurs_document_tag
-- ----------------------------
DROP TABLE IF EXISTS `nurs_document_tag`;
CREATE TABLE `nurs_document_tag` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `document_tag_id` varchar(32) NOT NULL COMMENT '文书标签id',
  `tag_type` varchar(32) NOT NULL COMMENT '标签类型',
  `tag_name` varchar(100) DEFAULT '' COMMENT '标签名称',
  `color` varchar(32) DEFAULT '' COMMENT '色值',
  `icon` varchar(255) DEFAULT '' COMMENT '图标',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `sort` int(8) DEFAULT NULL COMMENT '排序',
  `is_enable` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否启用',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='护理文书标签表';

-- ----------------------------
-- Table structure for nurs_document_tag_rel
-- ----------------------------
DROP TABLE IF EXISTS `nurs_document_tag_rel`;
CREATE TABLE `nurs_document_tag_rel` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `document_tag_rel_id` varchar(32) NOT NULL COMMENT '文书标签关联id',
  `document_id` varchar(32) NOT NULL COMMENT '文书id',
  `document_tag_id` varchar(32) NOT NULL COMMENT '文书标签id',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='护理文书标签关联表';

-- ----------------------------
-- Table structure for nurs_info
-- ----------------------------
DROP TABLE IF EXISTS `nurs_info`;
CREATE TABLE `nurs_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `nurs_id` varchar(32) NOT NULL COMMENT '护士id',
  `nurs_name` varchar(50) DEFAULT '' COMMENT '护士姓名',
  `gender` varchar(2) DEFAULT '' COMMENT '性别',
  `age` int(4) DEFAULT '0' COMMENT '年龄',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `hospital_name` varchar(50) DEFAULT '' COMMENT '所属医院',
  `dept_code` varchar(20) DEFAULT '' COMMENT '科室编号',
  `dept_name` varchar(20) DEFAULT '' COMMENT '科室名称',
  `telephone` varchar(20) DEFAULT '' COMMENT '联系电话',
  `work_title` varchar(20) DEFAULT '' COMMENT '职称',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='护士基本信息表';

-- ----------------------------
-- Table structure for nurs_item
-- ----------------------------
DROP TABLE IF EXISTS `nurs_item`;
CREATE TABLE `nurs_item` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `item_id` varchar(32) NOT NULL COMMENT '诊疗项目id',
  `item_name` varchar(100) DEFAULT '' COMMENT '名称',
  `item_class` varchar(32) DEFAULT '' COMMENT '诊疗项目分类',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='诊疗项目表';

-- ----------------------------
-- Table structure for nurs_item_detail
-- ----------------------------
DROP TABLE IF EXISTS `nurs_item_detail`;
CREATE TABLE `nurs_item_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `item_detail_id` varchar(32) NOT NULL COMMENT '诊疗项目详情id',
  `item_id` varchar(32) NOT NULL COMMENT '费用id',
  `item_name` varchar(100) DEFAULT '' COMMENT '名称',
  `item_code` varchar(32) DEFAULT '' COMMENT '诊疗项目编码',
  `item_unit` varchar(32) DEFAULT '' COMMENT '单位',
  `item_price` decimal(8,3) DEFAULT NULL COMMENT '价格',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='诊疗项目详情表';

-- ----------------------------
-- Table structure for nurs_order
-- ----------------------------
DROP TABLE IF EXISTS `nurs_order`;
CREATE TABLE `nurs_order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` varchar(32) NOT NULL COMMENT '医嘱id',
  `order_name` varchar(100) DEFAULT '' COMMENT '医嘱名称',
  `patient_id` varchar(32) NOT NULL COMMENT '患者id',
  `patient_visit_id` varchar(32) DEFAULT '' COMMENT '住院id',
  `long_temp_code` int(6) DEFAULT NULL COMMENT '医嘱类型：1=长期,2=临时',
  `order_type` varchar(10) DEFAULT '' COMMENT '医嘱分类：1=治疗,2=输液,3=口服,4=注射',
  `sort_no` int(11) DEFAULT '0' COMMENT '排序，开立顺序',
  `group_code` varchar(32) DEFAULT '' COMMENT '组号',
  `item_id` varchar(32) DEFAULT '' COMMENT '项目编号',
  `dosage` float(12,4) DEFAULT NULL COMMENT '剂量',
  `dosage_unit` varchar(32) DEFAULT '' COMMENT '剂量单位',
  `order_doctor_code` varchar(32) DEFAULT '' COMMENT '开立医生编号',
  `order_date` datetime DEFAULT NULL COMMENT '开立时间',
  `checker_code` varchar(32) DEFAULT '' COMMENT '核对人编号',
  `checker_time` datetime DEFAULT NULL COMMENT '核对时间',
  `item_count` float(14,4) DEFAULT NULL COMMENT '计价数量',
  `item_unit` varchar(20) DEFAULT '' COMMENT '计价单位',
  `freq_code` varchar(32) DEFAULT '' COMMENT '频次',
  `use_method` varchar(20) DEFAULT '' COMMENT '用法',
  `stop_time` datetime DEFAULT NULL COMMENT '停止时间',
  `stop_doctor_id` varchar(50) DEFAULT '' COMMENT '停止医生编号',
  `stop_checker_id` varchar(50) DEFAULT '' COMMENT '停止核对人员编号',
  `cancel_doctor_id` varchar(50) DEFAULT '' COMMENT '医嘱取消医生编号',
  `cancel_time` datetime DEFAULT NULL COMMENT '取消时间',
  `skin_test_result` varchar(15) DEFAULT '' COMMENT '皮试结果',
  `remark` varchar(150) DEFAULT '' COMMENT '备注',
  `first_num` int(11) DEFAULT NULL COMMENT '首次执行次数',
  `last_num` int(11) DEFAULT NULL COMMENT '末次执行次数',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='医嘱信息表';

-- ----------------------------
-- Table structure for nurs_order_exec
-- ----------------------------
DROP TABLE IF EXISTS `nurs_order_exec`;
CREATE TABLE `nurs_order_exec` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` varchar(32) NOT NULL COMMENT '医嘱id',
  `bar_code` varchar(32) DEFAULT NULL COMMENT '条码',
  `exce_emp_id` varchar(32) DEFAULT '' COMMENT '执行人id',
  `exec_time` datetime DEFAULT NULL COMMENT '计划执行时间',
  `exce_flag` varchar(10) DEFAULT '' COMMENT '执行标记（0=否，1=是）',
  `remarks` varchar(64) DEFAULT NULL COMMENT '备注',
  `speed` varchar(12) DEFAULT NULL COMMENT '滴速',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='医嘱执行表';

-- ----------------------------
-- Table structure for nurs_order_report
-- ----------------------------
DROP TABLE IF EXISTS `nurs_order_report`;
CREATE TABLE `nurs_order_report` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `report_id` varchar(32) NOT NULL COMMENT '医嘱报告id',
  `patient_id` varchar(32) NOT NULL COMMENT '患者id',
  `patient_visit_id` varchar(32) DEFAULT '' COMMENT '住院id',
  `report_name` varchar(50) DEFAULT '' COMMENT '报告名称',
  `report_type` varchar(10) DEFAULT '' COMMENT '报告分类：1=检查,2=检验',
  `check_time` datetime DEFAULT NULL COMMENT '报告送检时间',
  `begin_time` datetime DEFAULT NULL COMMENT '报告开始日期',
  `end_time` datetime DEFAULT NULL COMMENT '报告结束日期',
  `doctor_id` varchar(32) DEFAULT '' COMMENT '医生id',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='医嘱报告表';

-- ----------------------------
-- Table structure for nurs_patient
-- ----------------------------
DROP TABLE IF EXISTS `nurs_patient`;
CREATE TABLE `nurs_patient` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` varchar(32) NOT NULL COMMENT '患者id',
  `patient_name` varchar(50) DEFAULT '' COMMENT '患者姓名',
  `gender` varchar(2) DEFAULT '' COMMENT '性别',
  `age` int(4) DEFAULT '0' COMMENT '年龄',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `telephone` varchar(20) DEFAULT '' COMMENT '患者联系电话',
  `contact_name` varchar(50) DEFAULT '' COMMENT '联系人',
  `contact_relationship` varchar(20) DEFAULT NULL COMMENT '联系人与患者关系',
  `contact_tel` varchar(20) DEFAULT '' COMMENT '联系人电话',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='患者信息表';

-- ----------------------------
-- Table structure for nurs_patient_visit
-- ----------------------------
DROP TABLE IF EXISTS `nurs_patient_visit`;
CREATE TABLE `nurs_patient_visit` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `visit_id` varchar(32) NOT NULL COMMENT '住院id',
  `patient_id` varchar(32) NOT NULL COMMENT '患者id',
  `wristband_barcode` varchar(32) DEFAULT NULL,
  `mrn` varchar(32) DEFAULT '' COMMENT '住院号',
  `diagnosis_code` varchar(50) DEFAULT '' COMMENT '诊断编号',
  `diagnosis_name` varchar(200) DEFAULT '' COMMENT '诊断名称',
  `doctor_attending` varchar(20) DEFAULT '' COMMENT '主治医师编号',
  `doctor_attend_name` varchar(20) DEFAULT NULL,
  `doctor_chief` varchar(20) DEFAULT '' COMMENT '主任医师编号',
  `doctor_chief_name` varchar(20) DEFAULT NULL,
  `dept_code` varchar(20) DEFAULT '' COMMENT '科室编号',
  `dept_name` varchar(20) DEFAULT NULL,
  `bed_code` varchar(20) DEFAULT '' COMMENT '床位号',
  `bed_nurse_id` varchar(32) DEFAULT '' COMMENT '管床护士编号',
  `in_hosp_type` varchar(32) DEFAULT '' COMMENT '入院方式',
  `in_hosp_count` int(11) DEFAULT '0' COMMENT '入院次数',
  `in_hosp_dept_code` varchar(20) DEFAULT '' COMMENT '入院科室编号',
  `in_hosp_dept_name` varchar(20) DEFAULT NULL,
  `in_hosp_diagnosis_code` varchar(50) DEFAULT '' COMMENT '入院诊断编号',
  `in_hosp_diagnosis_name` varchar(200) DEFAULT '' COMMENT '入院诊断名称',
  `case_status` varchar(32) DEFAULT '' COMMENT '病情状态',
  `nursing_level` varchar(32) DEFAULT '' COMMENT '护理等级',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='患者住院信息表';

-- ----------------------------
-- Table structure for nurs_schedule
-- ----------------------------
DROP TABLE IF EXISTS `nurs_schedule`;
CREATE TABLE `nurs_schedule` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `schedule_id` varchar(32) NOT NULL COMMENT '班次id',
  `setting_id` varchar(32) NOT NULL COMMENT '班次设置id',
  `nurse_id` varchar(32) DEFAULT '' COMMENT '护士id',
  `duty_date` datetime DEFAULT NULL COMMENT '值班日期',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='班次排班表';

-- ----------------------------
-- Table structure for nurs_schedule_setting
-- ----------------------------
DROP TABLE IF EXISTS `nurs_schedule_setting`;
CREATE TABLE `nurs_schedule_setting` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `setting_id` varchar(32) NOT NULL COMMENT '班次id',
  `setting_name` varchar(50) DEFAULT '' COMMENT '班次名称',
  `begin_time` varchar(5) DEFAULT '' COMMENT '班次开始时间，格式 08:00',
  `end_time` varchar(5) DEFAULT '' COMMENT '班次结束时间，格式 12:00',
  `dr` tinyint(4) DEFAULT '0' COMMENT '是否删除(0=未删除,1=已删除)',
  `create_user` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT '' COMMENT '修改者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='班次设置表';
