package com.wang.demo.modules.system.menu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.wang.demo.base.entity.Base;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author wangjianhua
 * @Description
 * @date 2022/9/23/023 21:24
 */
@Data
public class Menu extends Base {


    /**
     * 名字
     */
    @NotNull(message = "菜单名字不能为空")
    @Size(max = 18,message = "用户昵称不能超过18个字符")
    @ApiModelProperty(value = "菜单名",dataType = "string")
    private String name;

    /**
     * 路径
     */
    @NotNull(message = "路径不能为空")
    @Size(max = 50,message = "用户昵称不能超过18个字符")
    @ApiModelProperty(value = "路径名",dataType = "string")
    private String path;



    /**
     * 父id
     */
    @TableField(value = "parent_id")
    private String parentId;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态(0:启用,1:禁用,2:锁定)", dataType = "int")
    private int status;


}
