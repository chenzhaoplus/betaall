package com.sinosoft.elasticjob.boot.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * EMPI表
    * </p>
*
* @author sinosoft
* @since 2020-05-08
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("T_EMPI")
    public class TEmpi implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键
            */
            @TableId("ID")
    private String id;

            /**
            * 就诊卡号
            */
        @TableField("CARD_NO")
    private String cardNo;

            /**
            * 姓名
            */
        @TableField("PERSON_NAME")
    private String personName;

            /**
            * 别名
            */
        @TableField("ALIAS_NAME")
    private String aliasName;

            /**
            * 性别
            */
        @TableField("SEX")
    private String sex;

            /**
            * 出生日期
            */
        @TableField("DATE_OF_BIRTH")
    private LocalDateTime dateOfBirth;

            /**
            * 患者身份
            */
        @TableField("IDENTITY")
    private String identity;

            /**
            * 拼音码
            */
        @TableField("PYM")
    private String pym;

            /**
            * 费别
            */
        @TableField("CHARGE_TYPE")
    private String chargeType;

            /**
            * 医保类型
            */
        @TableField("INSURANCE_TYPE")
    private String insuranceType;

            /**
            * 出生地点
            */
        @TableField("BIRTH_PLACE")
    private String birthPlace;

            /**
            * 双胞胎标记
            */
        @TableField("MULTI_BIRTH_IND")
    private String multiBirthInd;

            /**
            * 双胞胎顺序
            */
        @TableField("MULTI_BIRTH_ORDER")
    private String multiBirthOrder;

            /**
            * 死亡标记
            */
        @TableField("DEATH_IND")
    private String deathInd;

            /**
            * 死亡时间
            */
        @TableField("DEATH_TIME")
    private LocalDateTime deathTime;

            /**
            * 婚姻状态
            */
        @TableField("MARITAL_STATUS")
    private String maritalStatus;

            /**
            * 器官捐献者标记
            */
        @TableField("ORGAN_DONOR_IND")
    private String organDonorInd;

            /**
            * 残疾码
            */
        @TableField("DISABILITY_CODE")
    private String disabilityCode;

            /**
            * 国籍
            */
        @TableField("NATION")
    private String nation;

            /**
            * 民族
            */
        @TableField("NATIONALITY")
    private String nationality;

            /**
            * 宗教信仰
            */
        @TableField("RELIGION")
    private String religion;

            /**
            * 籍贯
            */
        @TableField("NATIVE_PROVINCE")
    private String nativeProvince;

            /**
            * 语言
            */
        @TableField("LANGUAGE")
    private String language;

            /**
            * 最高学位
            */
        @TableField("REE_LEVEL")
    private String reeLevel;

            /**
            * 最高学历
            */
        @TableField("EDUCATION_LEVEL")
    private String educationLevel;

            /**
            * 政治面貌
            */
        @TableField("POLITICS_STATUS")
    private String politicsStatus;

            /**
            * 职业
            */
        @TableField("OCCUPATION")
    private String occupation;

            /**
            * 社保号
            */
        @TableField("SSN")
    private String ssn;

            /**
            * 医疗保险号
            */
        @TableField("INSURANCE_NO")
    private String insuranceNo;

            /**
            * 手机
            */
        @TableField("MOBILE")
    private String mobile;

            /**
            * 邮编
            */
        @TableField("POSTCODE")
    private String postcode;

            /**
            * 血型
            */
        @TableField("BLOOD_TYPE")
    private String bloodType;

            /**
            * RH血型
            */
        @TableField("RH_BLOOD")
    private String rhBlood;

            /**
            * 保密级别
            */
        @TableField("CONFIDENT_LEVEL")
    private String confidentLevel;

            /**
            * VIP标志
            */
        @TableField("VIP_IND")
    private String vipInd;

            /**
            * 合并标识（合并主表id）
            */
        @TableField("HB_ID")
    private String hbId;

            /**
            * 注册时间
            */
        @TableField("ISTRATION_TIME")
    private LocalDateTime istrationTime;

            /**
            * 数据状态
            */
        @TableField("DATA_STATUS")
    private String dataStatus;

            /**
            * 创建者
            */
        @TableField("CREATOR")
    private String creator;

            /**
            * 创建时间
            */
        @TableField("CREATE_DATE")
    private LocalDateTime createDate;

            /**
            * 修改者
            */
        @TableField("MODIFY_BY")
    private String modifyBy;

            /**
            * 修改时间
            */
        @TableField("MODIFY_DATE")
    private LocalDateTime modifyDate;

            /**
            * 作废者
            */
        @TableField("VOIDED_BY")
    private String voidedBy;

            /**
            * 作废时间
            */
        @TableField("VOIDED_DATE")
    private LocalDateTime voidedDate;

            /**
            * 合并状态（0:否，1：是）
            */
        @TableField("HB_STATUS")
    private String hbStatus;

            /**
            * 年龄
            */
        @TableField("AGE")
    private String age;

            /**
            * 身高
            */
        @TableField("HEIGHT")
    private String height;

            /**
            * 邮箱
            */
        @TableField("EMAIL")
    private String email;

            /**
            * 单位名称
            */
        @TableField("WORK_PLACE")
    private String workPlace;

            /**
            * 患者主索引ID
            */
        @TableField("EMPI_ID")
    private String empiId;

            /**
            * 应用系统的患者 ID

            */
        @TableField("PATIENT_ID")
    private String patientId;

            /**
            * 性别名称

            */
        @TableField("GENDER_NAME")
    private String genderName;

            /**
            * 婚姻状况名称

            */
        @TableField("MARRIGE_NAME")
    private String marrigeName;

            /**
            * 民族名称

            */
        @TableField("NATION_NAME")
    private String nationName;

            /**
            * 职业类别名称

            */
        @TableField("OCCUPATION_NAME")
    private String occupationName;

            /**
            * 健康卡号

            */
        @TableField("ASOTHERCARDIDS_ID")
    private String asothercardidsId;

            /**
            * 健康卡发放机构代码

            */
        @TableField("ASOTHERCARDIDS_ORG")
    private String asothercardidsOrg;

            /**
            * 城乡居民健康档案编号

            */
        @TableField("ASOTHERARCHIVESIDS_ID")
    private String asotherarchivesidsId;

            /**
            * 建档医疗机构组织机构代码

            */
        @TableField("SCOPINGORGANIZATION_ORG")
    private String scopingorganizationOrg;

            /**
            * 登记机构代码

            */
        @TableField("PROVIDERORGANIZATION_ORG")
    private String providerorganizationOrg;

            /**
            * 登记机构名称

            */
        @TableField("PROVIDERORGANIZATION_NAME")
    private String providerorganizationName;

            /**
            * 固定值”PDQ”

            */
        @TableField("QUERYMATCHOBSERVATION")
    private String querymatchobservation;

            /**
            * 匹配度

            */
        @TableField("MINIMUMDEGREEMATCH")
    private String minimumdegreematch;

            /**
            * 医疗保险信息代码

            */
        @TableField("BENEFICIARY_CODE")
    private String beneficiaryCode;

            /**
            * 医疗保险信息名称

            */
        @TableField("BENEFICIARY_NAME")
    private String beneficiaryName;

            /**
            * 登记人 ID

            */
        @TableField("ASSIGNEDENTITY_ID")
    private String assignedentityId;

            /**
            * 患者编码
            */
        @TableField("PATIENT_CODE")
    private String patientCode;


}
