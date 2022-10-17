package com.wang.demo.modules.system.authority.entity;

import com.wang.demo.base.entity.Base;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wangjianhua
 * @Description 权限管理
 * @date 2022/10/17 19:46
 */
@Data
public class Authority extends Base {


    /**
     * 权限名
     */
    @ApiModelProperty(value = "权限名称",dataType = "string")
    private String name;

    /**
     * 权限码
     */
    @ApiModelProperty(value = "权限码",dataType = "string")
    private String code;



}
