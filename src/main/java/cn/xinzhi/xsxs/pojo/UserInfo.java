package cn.xinzhi.xsxs.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value = "用户信息")
public class UserInfo {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "星号")
    private Integer uid;
    @ApiModelProperty(value = "用户名")
    private String uname;
    @ApiModelProperty(value = "用户密码")
    private String upwd;
    @ApiModelProperty(value = "用户手机号")
    private String p_phone;
    @ApiModelProperty(value = "身份证")
    private String p_idnumber;
    @ApiModelProperty(value = "出生日期")
    private Date p_brithday;
    @ApiModelProperty(value = "用户性别")
    private Integer p_sex;
    @ApiModelProperty(value = "城市")
    private Integer p_cityid;
    @ApiModelProperty(value = "年龄")
    private Integer p_age;
    @ApiModelProperty(value = "更新时间")
    private String updatetime;
    @ApiModelProperty(value = "验证码")
    private String verification;

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getP_phone() {
        return p_phone;
    }

    public void setP_phone(String p_phone) {
        this.p_phone = p_phone;
    }

    public String getP_idnumber() {
        return p_idnumber;
    }

    public void setP_idnumber(String p_idnumber) {
        this.p_idnumber = p_idnumber;
    }

    public Date getP_brithday() {
        return p_brithday;
    }

    public void setP_brithday(Date p_brithday) {
        this.p_brithday = p_brithday;
    }

    public Integer getP_sex() {
        return p_sex;
    }

    public void setP_sex(Integer p_sex) {
        this.p_sex = p_sex;
    }

    public Integer getP_cityid() {
        return p_cityid;
    }

    public void setP_cityid(Integer p_cityid) {
        this.p_cityid = p_cityid;
    }

    public Integer getP_age() {
        return p_age;
    }

    public void setP_age(Integer p_age) {
        this.p_age = p_age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", p_phone='" + p_phone + '\'' +
                ", p_idnumber='" + p_idnumber + '\'' +
                ", p_brithday=" + p_brithday +
                ", p_sex=" + p_sex +
                ", p_cityid=" + p_cityid +
                ", p_age=" + p_age +
                ", updatetime='" + updatetime + '\'' +
                ", verification='" + verification + '\'' +
                '}';
    }
}

