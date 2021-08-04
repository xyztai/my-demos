package com.junit.tool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

@TableName("jt_activity")
@ApiModel(value="活动PO对象", description="活动信息表【jt_activity】")
public class Activity {

    @ApiModelProperty(value = "主键ID")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "活动主题")
    private String activityTitle;

    @ApiModelProperty(value = "联系号码")
    private String contactPhone;

    @ApiModelProperty(value = "1线上、2线下")
    private Integer isOnline;

    @ApiModelProperty(value = "举办地址")
    private String address;

    @ApiModelProperty(value = "主办单位")
    private String organizer;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public String getMockTitle (){
        return "MockTitle主题" ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle == null ? null : activityTitle.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer == null ? null : organizer.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}