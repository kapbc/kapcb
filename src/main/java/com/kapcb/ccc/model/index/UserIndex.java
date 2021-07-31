package com.kapcb.ccc.model.index;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: UserIndex </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/31 11:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setting(settingPath = "_setting.json")
@Document(indexName = "kapcb_user_index", refreshInterval = "-1")
public class UserIndex implements Serializable {

    private static final long serialVersionUID = -5478947622230364428L;

    /**
     * 用户id
     */
    @Id
    @Field(name = "user_id", type = FieldType.Long)
    private Long userId;

    /**
     * 商店id
     */
    @Field(name = "store_id", type = FieldType.Long)
    private Long storeId;

    /**
     * 紧急联系人id
     */
    @Field(name = "emergency_contact_userid", type = FieldType.Long)
    private Long emergencyContactUserId;

    /**
     * first name
     */
    @Field(name = "first_name", type = FieldType.Text, analyzer = "ik_max_word")
    private String firstName;

    /**
     * last name
     */
    @Field(name = "last_name", type = FieldType.Text, analyzer = "ik_max_word")
    private String lastName;

    /**
     * nick name
     */
    @Field(name = "nick_name", type = FieldType.Text, analyzer = "ik_max_word")
    private String nickName;

    /**
     * 邮件
     */
    @Field(name = "email", type = FieldType.Keyword)
    private String email;

    /**
     * 年龄
     */
    @Field(name = "age", type = FieldType.Integer)
    private Integer age;

    /**
     * 性别-> 0 男 1 女
     */
    @Field(name = "gender", type = FieldType.Integer)
    private Integer gender;

    /**
     * 国家代码
     */
    @Field(name = "country_code", type = FieldType.Keyword)
    private String countryCode;

    /**
     * 地区代码
     */
    @Field(name = "area_code", type = FieldType.Keyword)
    private String areaCode;

    /**
     * 城市代码
     */
    @Field(name = "city_code", type = FieldType.Keyword)
    private String cityCode;

    /**
     * 用户星级 0~10
     */
    @Field(name = "user_star_level", type = FieldType.Keyword)
    private Integer userStarLevel;

    /**
     * 用户是否可用状态 true 可用 false 禁用
     */
    @Field(name = "available_status", type = FieldType.Boolean)
    private Boolean availableStatus;

    /**
     * 用户信息完整度分数
     */
    @Field(name = "user_info_score", type = FieldType.Integer)
    private Integer userInfoScore;

    /**
     * 用户信用分数
     */
    @Field(name = "user_credit_score", type = FieldType.Integer)
    private Integer userCreditScore;

    /**
     * 创建人
     */
    @Field(name = "create_by", type = FieldType.Long)
    private Long createBy;

    /**
     * 更新人
     */
    @Field(name = "last_update_by", type = FieldType.Long)
    private Long lastUpdateBy;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UMT+8")
    @Field(name = "birthday", format = DateFormat.basic_date, type = FieldType.Date)
    private Date birthday;

    /**
     * 账号创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UMT+8")
    @Field(name = "create_date", format = DateFormat.basic_date, type = FieldType.Date)
    private Date createDate;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UMT+8")
    @Field(name = "last_update_date", format = DateFormat.basic_date, type = FieldType.Date)
    private Date lastUpdateDate;

    /**
     * 用户职位
     */
    @Field(name = "user_job_title", type = FieldType.Keyword)
    private String userJobTitle;

    /**
     * 电话国际冠码
     */
    @Field(name = "telephone_prefix", type = FieldType.Keyword)
    private String telephonePrefix;

    /**
     * 接受国家代码
     */
    @Field(name = "telephone_accept_country_code", type = FieldType.Keyword)
    private String telephoneAcceptCountryCode;

    /**
     * 区号
     */
    @Field(name = "telephone_area_code", type = FieldType.Keyword)
    private String telephoneAreaCode;

    /**
     * 电话号码
     */
    @Field(name = "telephone_number", type = FieldType.Keyword)
    private String telephoneNumber;

    /**
     * 是否在线 online:在线, hiding:隐身, leave:离开
     */
    @Field(name = "online_status", type = FieldType.Keyword)
    private Boolean onlineStatus;

    /**
     * 备注
     */
    @Field(name = "remark", type = FieldType.Keyword)
    private String remark;

    /**
     * 头像
     */
    @Field(name = "head_sculpture", type = FieldType.Keyword)
    private String headSculpture;

    /**
     * 用户来源
     */
    @Field(name = "user_source", type = FieldType.Keyword)
    private String userSource;
}
