package com.wang.demo.modules.system.role.entity;

import com.wang.demo.base.entity.Base;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色
 * @author wangjianhua
 * @date 2021-03-24 13:55
 */
@Data
public class Role extends Base {

    @ApiModelProperty(value = "角色名称",dataType = "string")
    private String name;

    @ApiModelProperty(value = "角色码 后台授权使用",dataType = "string")
    private String code;
}
