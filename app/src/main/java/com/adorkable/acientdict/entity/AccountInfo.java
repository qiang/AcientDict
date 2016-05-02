package com.adorkable.acientdict.entity;

/**
 * Created by liuqiang
 * Date: 2016-01-06
 * Time: 20:26
 */
public class AccountInfo {

    private int id;
    private String avatar;
    private String name;
    private String email;
    private String phone;
    private String birthday;
    private String gender;
    private String autograph;
    private String openid;
    private String weibo_uid;
    private String unionid;
    private String access_token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getWeibo_uid() {
        return weibo_uid;
    }

    public void setWeibo_uid(String weibo_uid) {
        this.weibo_uid = weibo_uid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "account_id=" + id +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", autograph='" + autograph + '\'' +
                ", openid='" + openid + '\'' +
                ", weibo_uid='" + weibo_uid + '\'' +
                ", unionid='" + unionid + '\'' +
                ", access_token='" + access_token + '\'' +
                '}';
    }
}
