package com.sinosoft.elasticsearch.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * MD医疗机构药品基本资料
 * </p>
 *
 * @author sinosoft
 * @since 2020-04-25
 */
@TableName("MD_BASE_DRUG")
public class MdBaseDrug implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 药品唯一编号（用户录入）
     */
    @TableField("M_CODE")
    private String mCode;

    /**
     * 药品名称
     */
    @TableField("M_NAME")
    private String mName;

    /**
     * 药品别名
     */
    @TableField("M_ALIAS")
    private String mAlias;

    /**
     * 药品英文名
     */
    @TableField("M_ENNAME")
    private String mEnname;

    /**
     * 分类编码
     */
    @TableField("SORT_CODE")
    private String sortCode;

    /**
     * 助记词（五笔）
     */
    @TableField("ZJCWB")
    private String zjcwb;

    /**
     * 助记词（拼音）
     */
    @TableField("ZJCPY")
    private String zjcpy;

    /**
     * 助记词（其他）
     */
    @TableField("ZJCQT")
    private String zjcqt;

    /**
     * 药品规格
     */
    @TableField("M_STD")
    private String mStd;

    /**
     * 基本单位（设置成最小发药单位，基本单位比例为1
     */
    @TableField("UNIT")
    private Integer unit;

    /**
     * 基本单位名称
     */
    @TableField("UNIT_NAME")
    private String unitName;

    /**
     * 药库单位
     */
    @TableField("YK_UNIT")
    private Integer ykUnit;

    /**
     * 药库单位名称
     */
    @TableField("YK_UNIT_NAME")
    private String ykUnitName;

    /**
     * 药品剂量单位
     */
    @TableField("DOSE_UNIT")
    private Integer doseUnit;

    /**
     * 药品剂量单位名称
     */
    @TableField("DOSE_UNIT_NAME")
    private String doseUnitName;

    /**
     * 门诊发药最小单位
     */
    @TableField("MZ_UNIT")
    private Integer mzUnit;

    /**
     * 门诊发药最小单位名称
     */
    @TableField("MZ_UNIT_NAME")
    private String mzUnitName;

    /**
     * 住院发药最小单位
     */
    @TableField("ZY_UNIT")
    private Integer zyUnit;

    /**
     * 住院发药最小单位名称
     */
    @TableField("ZY_UNIT_NAME")
    private String zyUnitName;

    /**
     * 门诊打印单位
     */
    @TableField("MZ_PRINT_UNIT")
    private Integer mzPrintUnit;

    /**
     * 门诊打印单位名称
     */
    @TableField("MZ_PRINT_UNIT_NAME")
    private String mzPrintUnitName;

    /**
     * 取整方式
     */
    @TableField("TRUNC")
    private String trunc;

    /**
     * 单次取整单位
     */
    @TableField("TRUNC_UNIT")
    private Integer truncUnit;

    /**
     * 门诊是否拆分
     */
    @TableField("MZ_CANDETACH")
    private String mzCandetach;

    /**
     * 住院是否拆分
     */
    @TableField("ZY_CANDETACH")
    private String zyCandetach;

    /**
     * 药品性质 1：西药 2：中药 3：中成药 4：材料
     */
    @TableField("M_TYPE")
    private String mType;

    /**
     * 药品剂型编号
     */
    @TableField("M_JX_CODE")
    private String mJxCode;

    /**
     * 药品剂型名称
     */
    @TableField("M_JX_NAME")
    private String mJxName;

    /**
     * 库房药品停用（0：否1：是）
     */
    @TableField("KF_NOUSE")
    private String kfNouse;

    /**
     * 库房停用时间
     */
    @TableField("KF_NOUSE_DATE")
    private Date kfNouseDate;

    /**
     * 住院是否停用（0：否1：是
     */
    @TableField("ZY_NOUSE")
    private String zyNouse;

    /**
     * 住院停用时间
     */
    @TableField("ZY_NOUSE_DATE")
    private Date zyNouseDate;

    /**
     * 门诊是否停用（0：否1：是）
     */
    @TableField("MZ_NOUSE")
    private String mzNouse;

    /**
     * 门诊停用时间
     */
    @TableField("MZ_NOUSE_DATE")
    private Date mzNouseDate;

    /**
     * 是否新药（0：否1：是）
     */
    @TableField("IS_NEW")
    private String isNew;

    /**
     * 是否贵重药品（0：否1：是）
     */
    @TableField("IS_GZYP")
    private String isGzyp;

    /**
     * 是否麻醉药品（0：否1：是）
     */
    @TableField("IS_MZYP")
    private String isMzyp;

    /**
     * 是否抗菌药品（0：否1：是）
     */
    @TableField("IS_KJYP")
    private String isKjyp;

    /**
     * 是否营养保健药品（0：否1：是）
     */
    @TableField("IS_BJYP")
    private String isBjyp;

    /**
     * 精神类药品分类
     */
    @TableField("JSYP_SORT")
    private String jsypSort;

    /**
     * 是否大输液（0：否1：是）
     */
    @TableField("IS_DSY")
    private String isDsy;

    /**
     * 是否工伤受限（0：否1：是）
     */
    @TableField("IS_COMPOSAFETY_LIMIT")
    private String isComposafetyLimit;

    /**
     * 是否注射类药品（0：否1：是）
     */
    @TableField("IS_INJECTION")
    private String isInjection;

    /**
     * 皮试内容（0：否1：是）
     */
    @TableField("HYPETEST")
    private String hypetest;

    /**
     * 是否免煎（0非免煎;1免煎）
     */
    @TableField("IS_DECOCT")
    private String isDecoct;

    /**
     * 是否精品中药（0：否1：是）
     */
    @TableField("IS_JPZY")
    private String isJpzy;

    /**
     * 是否招标（0：否1：是）
     */
    @TableField("IS_ZB")
    private String isZb;

    /**
     * 药品来源0: 国产 1进口
     */
    @TableField("M_SOURCE")
    private String mSource;

    /**
     * 机构编码org_id=0表示是基础药品
     */
    @TableId("ORG_ID")
    private Long orgId;

    /**
     * 是否零加成药
     */
    @TableField("IS_ZERO_ADD")
    private String isZeroAdd;

    /**
     * 加成比例
     */
    @TableField("ADD_PERCENT")
    private Double addPercent;

    /**
     * 是否处方药
     */
    @TableField("IS_RP")
    private String isRp;

    /**
     * 高储标准
     */
    @TableField("HIGH_STORAGE")
    private Long highStorage;

    /**
     * 低储标准
     */
    @TableField("LOW_STORAGE")
    private Long lowStorage;

    /**
     * 药房高储标准
     */
    @TableField("YF_HIGH_STORAGE")
    private Long yfHighStorage;

    /**
     * 药房低储标准
     */
    @TableField("YF_LOW_STORAGE")
    private Long yfLowStorage;

    /**
     * 作废 0表示否 1表示是
     */
    @TableField("NOUSED")
    private String noused;

    /**
     * 国家基本目录
     */
    @TableField("BASE_CATALOG")
    private String baseCatalog;

    /**
     * 药房单位
     */
    @TableField("YF_UNIT")
    private Integer yfUnit;

    /**
     * 药房单位名称
     */
    @TableField("YF_UNIT_NAME")
    private String yfUnitName;

    /**
     * 费别编号
     */
    @TableField("FBH")
    private Long fbh;

    /**
     * 用药频率编号，对应MD_BASE_DRUG_FREQUENCY的USAGE_CODE对应
     */
    @TableField("DRUG_FREQUENCY")
    private String drugFrequency;

    /**
     * 给药途径编号，对应MD_BASE_DRUG_MODE的DRUG_MODE_CODE对应
     */
    @TableField("DRUG_MODE")
    private String drugMode;

    /**
     * 医院诊疗项目ID
     */
    @TableField("HOSP_ITEM_ID")
    private String hospItemId;

    /**
     * 分零类型
     */
    @TableField("ZERO_TYPE")
    private Long zeroType;

    @TableField("COUNT_SCALE")
    private Double countScale;

    @TableField("COUNT_UNIT")
    private String countUnit;

    /**
     * 精选中药规格系数
     */
    @TableField("JXPACK")
    private Double jxpack;


    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAlias() {
        return mAlias;
    }

    public void setmAlias(String mAlias) {
        this.mAlias = mAlias;
    }

    public String getmEnname() {
        return mEnname;
    }

    public void setmEnname(String mEnname) {
        this.mEnname = mEnname;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getZjcwb() {
        return zjcwb;
    }

    public void setZjcwb(String zjcwb) {
        this.zjcwb = zjcwb;
    }

    public String getZjcpy() {
        return zjcpy;
    }

    public void setZjcpy(String zjcpy) {
        this.zjcpy = zjcpy;
    }

    public String getZjcqt() {
        return zjcqt;
    }

    public void setZjcqt(String zjcqt) {
        this.zjcqt = zjcqt;
    }

    public String getmStd() {
        return mStd;
    }

    public void setmStd(String mStd) {
        this.mStd = mStd;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getYkUnit() {
        return ykUnit;
    }

    public void setYkUnit(Integer ykUnit) {
        this.ykUnit = ykUnit;
    }

    public String getYkUnitName() {
        return ykUnitName;
    }

    public void setYkUnitName(String ykUnitName) {
        this.ykUnitName = ykUnitName;
    }

    public Integer getDoseUnit() {
        return doseUnit;
    }

    public void setDoseUnit(Integer doseUnit) {
        this.doseUnit = doseUnit;
    }

    public String getDoseUnitName() {
        return doseUnitName;
    }

    public void setDoseUnitName(String doseUnitName) {
        this.doseUnitName = doseUnitName;
    }

    public Integer getMzUnit() {
        return mzUnit;
    }

    public void setMzUnit(Integer mzUnit) {
        this.mzUnit = mzUnit;
    }

    public String getMzUnitName() {
        return mzUnitName;
    }

    public void setMzUnitName(String mzUnitName) {
        this.mzUnitName = mzUnitName;
    }

    public Integer getZyUnit() {
        return zyUnit;
    }

    public void setZyUnit(Integer zyUnit) {
        this.zyUnit = zyUnit;
    }

    public String getZyUnitName() {
        return zyUnitName;
    }

    public void setZyUnitName(String zyUnitName) {
        this.zyUnitName = zyUnitName;
    }

    public Integer getMzPrintUnit() {
        return mzPrintUnit;
    }

    public void setMzPrintUnit(Integer mzPrintUnit) {
        this.mzPrintUnit = mzPrintUnit;
    }

    public String getMzPrintUnitName() {
        return mzPrintUnitName;
    }

    public void setMzPrintUnitName(String mzPrintUnitName) {
        this.mzPrintUnitName = mzPrintUnitName;
    }

    public String getTrunc() {
        return trunc;
    }

    public void setTrunc(String trunc) {
        this.trunc = trunc;
    }

    public Integer getTruncUnit() {
        return truncUnit;
    }

    public void setTruncUnit(Integer truncUnit) {
        this.truncUnit = truncUnit;
    }

    public String getMzCandetach() {
        return mzCandetach;
    }

    public void setMzCandetach(String mzCandetach) {
        this.mzCandetach = mzCandetach;
    }

    public String getZyCandetach() {
        return zyCandetach;
    }

    public void setZyCandetach(String zyCandetach) {
        this.zyCandetach = zyCandetach;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmJxCode() {
        return mJxCode;
    }

    public void setmJxCode(String mJxCode) {
        this.mJxCode = mJxCode;
    }

    public String getmJxName() {
        return mJxName;
    }

    public void setmJxName(String mJxName) {
        this.mJxName = mJxName;
    }

    public String getKfNouse() {
        return kfNouse;
    }

    public void setKfNouse(String kfNouse) {
        this.kfNouse = kfNouse;
    }

    public Date getKfNouseDate() {
        return kfNouseDate;
    }

    public void setKfNouseDate(Date kfNouseDate) {
        this.kfNouseDate = kfNouseDate;
    }

    public String getZyNouse() {
        return zyNouse;
    }

    public void setZyNouse(String zyNouse) {
        this.zyNouse = zyNouse;
    }

    public Date getZyNouseDate() {
        return zyNouseDate;
    }

    public void setZyNouseDate(Date zyNouseDate) {
        this.zyNouseDate = zyNouseDate;
    }

    public String getMzNouse() {
        return mzNouse;
    }

    public void setMzNouse(String mzNouse) {
        this.mzNouse = mzNouse;
    }

    public Date getMzNouseDate() {
        return mzNouseDate;
    }

    public void setMzNouseDate(Date mzNouseDate) {
        this.mzNouseDate = mzNouseDate;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getIsGzyp() {
        return isGzyp;
    }

    public void setIsGzyp(String isGzyp) {
        this.isGzyp = isGzyp;
    }

    public String getIsMzyp() {
        return isMzyp;
    }

    public void setIsMzyp(String isMzyp) {
        this.isMzyp = isMzyp;
    }

    public String getIsKjyp() {
        return isKjyp;
    }

    public void setIsKjyp(String isKjyp) {
        this.isKjyp = isKjyp;
    }

    public String getIsBjyp() {
        return isBjyp;
    }

    public void setIsBjyp(String isBjyp) {
        this.isBjyp = isBjyp;
    }

    public String getJsypSort() {
        return jsypSort;
    }

    public void setJsypSort(String jsypSort) {
        this.jsypSort = jsypSort;
    }

    public String getIsDsy() {
        return isDsy;
    }

    public void setIsDsy(String isDsy) {
        this.isDsy = isDsy;
    }

    public String getIsComposafetyLimit() {
        return isComposafetyLimit;
    }

    public void setIsComposafetyLimit(String isComposafetyLimit) {
        this.isComposafetyLimit = isComposafetyLimit;
    }

    public String getIsInjection() {
        return isInjection;
    }

    public void setIsInjection(String isInjection) {
        this.isInjection = isInjection;
    }

    public String getHypetest() {
        return hypetest;
    }

    public void setHypetest(String hypetest) {
        this.hypetest = hypetest;
    }

    public String getIsDecoct() {
        return isDecoct;
    }

    public void setIsDecoct(String isDecoct) {
        this.isDecoct = isDecoct;
    }

    public String getIsJpzy() {
        return isJpzy;
    }

    public void setIsJpzy(String isJpzy) {
        this.isJpzy = isJpzy;
    }

    public String getIsZb() {
        return isZb;
    }

    public void setIsZb(String isZb) {
        this.isZb = isZb;
    }

    public String getmSource() {
        return mSource;
    }

    public void setmSource(String mSource) {
        this.mSource = mSource;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getIsZeroAdd() {
        return isZeroAdd;
    }

    public void setIsZeroAdd(String isZeroAdd) {
        this.isZeroAdd = isZeroAdd;
    }

    public Double getAddPercent() {
        return addPercent;
    }

    public void setAddPercent(Double addPercent) {
        this.addPercent = addPercent;
    }

    public String getIsRp() {
        return isRp;
    }

    public void setIsRp(String isRp) {
        this.isRp = isRp;
    }

    public Long getHighStorage() {
        return highStorage;
    }

    public void setHighStorage(Long highStorage) {
        this.highStorage = highStorage;
    }

    public Long getLowStorage() {
        return lowStorage;
    }

    public void setLowStorage(Long lowStorage) {
        this.lowStorage = lowStorage;
    }

    public Long getYfHighStorage() {
        return yfHighStorage;
    }

    public void setYfHighStorage(Long yfHighStorage) {
        this.yfHighStorage = yfHighStorage;
    }

    public Long getYfLowStorage() {
        return yfLowStorage;
    }

    public void setYfLowStorage(Long yfLowStorage) {
        this.yfLowStorage = yfLowStorage;
    }

    public String getNoused() {
        return noused;
    }

    public void setNoused(String noused) {
        this.noused = noused;
    }

    public String getBaseCatalog() {
        return baseCatalog;
    }

    public void setBaseCatalog(String baseCatalog) {
        this.baseCatalog = baseCatalog;
    }

    public Integer getYfUnit() {
        return yfUnit;
    }

    public void setYfUnit(Integer yfUnit) {
        this.yfUnit = yfUnit;
    }

    public String getYfUnitName() {
        return yfUnitName;
    }

    public void setYfUnitName(String yfUnitName) {
        this.yfUnitName = yfUnitName;
    }

    public Long getFbh() {
        return fbh;
    }

    public void setFbh(Long fbh) {
        this.fbh = fbh;
    }

    public String getDrugFrequency() {
        return drugFrequency;
    }

    public void setDrugFrequency(String drugFrequency) {
        this.drugFrequency = drugFrequency;
    }

    public String getDrugMode() {
        return drugMode;
    }

    public void setDrugMode(String drugMode) {
        this.drugMode = drugMode;
    }

    public String getHospItemId() {
        return hospItemId;
    }

    public void setHospItemId(String hospItemId) {
        this.hospItemId = hospItemId;
    }

    public Long getZeroType() {
        return zeroType;
    }

    public void setZeroType(Long zeroType) {
        this.zeroType = zeroType;
    }

    public Double getCountScale() {
        return countScale;
    }

    public void setCountScale(Double countScale) {
        this.countScale = countScale;
    }

    public String getCountUnit() {
        return countUnit;
    }

    public void setCountUnit(String countUnit) {
        this.countUnit = countUnit;
    }

    public Double getJxpack() {
        return jxpack;
    }

    public void setJxpack(Double jxpack) {
        this.jxpack = jxpack;
    }

    @Override
    public String toString() {
        return "MdBaseDrug{" +
                "mCode=" + mCode +
                ", mName=" + mName +
                ", mAlias=" + mAlias +
                ", mEnname=" + mEnname +
                ", sortCode=" + sortCode +
                ", zjcwb=" + zjcwb +
                ", zjcpy=" + zjcpy +
                ", zjcqt=" + zjcqt +
                ", mStd=" + mStd +
                ", unit=" + unit +
                ", unitName=" + unitName +
                ", ykUnit=" + ykUnit +
                ", ykUnitName=" + ykUnitName +
                ", doseUnit=" + doseUnit +
                ", doseUnitName=" + doseUnitName +
                ", mzUnit=" + mzUnit +
                ", mzUnitName=" + mzUnitName +
                ", zyUnit=" + zyUnit +
                ", zyUnitName=" + zyUnitName +
                ", mzPrintUnit=" + mzPrintUnit +
                ", mzPrintUnitName=" + mzPrintUnitName +
                ", trunc=" + trunc +
                ", truncUnit=" + truncUnit +
                ", mzCandetach=" + mzCandetach +
                ", zyCandetach=" + zyCandetach +
                ", mType=" + mType +
                ", mJxCode=" + mJxCode +
                ", mJxName=" + mJxName +
                ", kfNouse=" + kfNouse +
                ", kfNouseDate=" + kfNouseDate +
                ", zyNouse=" + zyNouse +
                ", zyNouseDate=" + zyNouseDate +
                ", mzNouse=" + mzNouse +
                ", mzNouseDate=" + mzNouseDate +
                ", isNew=" + isNew +
                ", isGzyp=" + isGzyp +
                ", isMzyp=" + isMzyp +
                ", isKjyp=" + isKjyp +
                ", isBjyp=" + isBjyp +
                ", jsypSort=" + jsypSort +
                ", isDsy=" + isDsy +
                ", isComposafetyLimit=" + isComposafetyLimit +
                ", isInjection=" + isInjection +
                ", hypetest=" + hypetest +
                ", isDecoct=" + isDecoct +
                ", isJpzy=" + isJpzy +
                ", isZb=" + isZb +
                ", mSource=" + mSource +
                ", orgId=" + orgId +
                ", isZeroAdd=" + isZeroAdd +
                ", addPercent=" + addPercent +
                ", isRp=" + isRp +
                ", highStorage=" + highStorage +
                ", lowStorage=" + lowStorage +
                ", yfHighStorage=" + yfHighStorage +
                ", yfLowStorage=" + yfLowStorage +
                ", noused=" + noused +
                ", baseCatalog=" + baseCatalog +
                ", yfUnit=" + yfUnit +
                ", yfUnitName=" + yfUnitName +
                ", fbh=" + fbh +
                ", drugFrequency=" + drugFrequency +
                ", drugMode=" + drugMode +
                ", hospItemId=" + hospItemId +
                ", zeroType=" + zeroType +
                ", countScale=" + countScale +
                ", countUnit=" + countUnit +
                ", jxpack=" + jxpack +
                "}";
    }
}
