package com.wang.demo.modules.system.menu.entity;

import com.wang.demo.base.entity.Base;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author wangjianhua
 * @Description
 * @date 2022/9/23/023 21:24
 */
public class Menu extends Base {


    /**
     * 名字
     */
    @NotNull(message = "菜单名字不能为空")
    @Size(max = 18,message = "用户昵称不能超过18个字符")
    @ApiModelProperty(value = "菜单名",dataType = "string")
    private String authName;

    /**
     * 路径
     */
    @NotNull(message = "路径不能为空")
    @Size(max = 50,message = "用户昵称不能超过18个字符")
    @ApiModelProperty(value = "菜单名",dataType = "string")
    private String path;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空")
    @ApiModelProperty(value = "菜单名",dataType = "int")
    private int order;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态(0:启用,1:禁用,2:锁定)", dataType = "int")
    private int status;

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "authName='" + authName + '\'' +
                ", path='" + path + '\'' +
                ", order=" + order +
                ", parentId='" + parentId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
