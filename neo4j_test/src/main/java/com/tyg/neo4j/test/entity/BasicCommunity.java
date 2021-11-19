package com.tyg.neo4j.test.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础信息表--小区信息表(BasicCommunity)实体类
 *
 * @author makejava
 * @since 2021-11-08 16:20:32
 */
@Data
public class BasicCommunity implements Serializable {
    private static final long serialVersionUID = 502520755881129570L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * community_id
     */
    private String communityId;
    /**
     * 小区名称
     */
    private String communityName;
    ///**
    // * 小区类型-dict_type_id=29
    // */
    //private String communityType;
    ///**
    // * 项目id
    // */
    //private String projectId;
    ///**
    // * 省代码-dict_type_id=7
    // */
    //private String provinceCode;
    ///**
    // * 市代码-dict_type_id=7
    // */
    //private String cityCode;
    ///**
    // * 区县代码-dict_type_id=7or28
    // */
    //private String areaCode;
    ///**
    // * 村社区
    // */
    //private String town;
    ///**
    // * 街道
    // */
    //private String street;
    ///**
    // * 街路巷编码，从标准地址库来
    // */
    //private String jlxbm;
    ///**
    // * 门牌号，从标准地址库来
    // */
    //private String mph;
    ///**
    // * 详细地址
    // */
    //private String detailAddress;
    //
    //private String longitude;
    //
    //private String latitude;
    ///**
    // * 所属社区标识-dict_type_id=14
    // */
    //private String belongCommunityCode;
    ///**
    // * 派出所标识-dict_type_id=13
    // */
    //private String policyStationCode;
    ///**
    // * 开发商
    // */
    //private String developers;
    ///**
    // * 物业公司名称
    // */
    //private String propertyCompanyName;
    ///**
    // * 物业公司电话
    // */
    //private String propertyCompanyPhone;
    ///**
    // * 物业经理姓名
    // */
    //private String propertyManagerName;
    ///**
    // * 管理处电话
    // */
    //private String propertyManagerPhone;
    ///**
    // * 小区图片
    // */
    //private String communityPhoto;
    ///**
    // * 客服电话
    // */
    //private String servicePhone;
    ///**
    // * 安装电话
    // */
    //private String installPhone;
    ///**
    // * 社区民警名字
    // */
    //private String policename;
    ///**
    // * 社区民警电话
    // */
    //private String policephone;
    ///**
    // * 小区栋数
    // */
    //private Integer totalBuilding;
    ///**
    // * 小区户数
    // */
    //private Integer totalRoom;
    ///**
    // * 小区住户总人数
    // */
    //private String totalPerson;
    ///**
    // * 创建时间
    // */
    //private Date crtTime;
    ///**
    // * 创建人id
    // */
    //private String crtBy;
    ///**
    // * 更新时间
    // */
    //private Date updTime;
    ///**
    // * 更新人id
    // */
    //private String updBy;
    ///**
    // * 备注
    // */
    //private String remarks;
    ///**
    // * 删除标记，逻辑删除
    // */
    //private String delFlag;
    ///**
    // * 是否包含立林设备 lookup_type=BHLLSB
    // */
    //private String isLeelenDevice;
    ///**
    // * 第三方小区id
    // */
    //private String communityCode;
    ///**
    // * 小区地图集
    // */
    //private String communityAtlas;
    ///**
    // * 街道代码
    // */
    //private String streetCode;
    ///**
    // * 社区代码
    // */
    //private String townCode;

}
