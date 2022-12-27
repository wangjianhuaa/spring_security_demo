package com.wang.demo.modules.system.userRole.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author wangjianhua
 * @Description
 * @date 2022/12/27/027 22:54
 */
public class UserRole {

    private int userId;

    private int roleId;

    private int revision;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "添加人", dataType = "String")
    private String createdBy;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "添加时间", dataType = "date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")
    private Date createdTime;

    @ApiModelProperty(value = "修改人", dataType = "String")
    private String updatedBy;

    @ApiModelProperty(value = "修改时间", dataType = "date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")
    private Date updatedTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
