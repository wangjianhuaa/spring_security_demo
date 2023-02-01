package com.wang.demo.modules.system.authority.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wang.demo.base.entity.BasePage;
import com.wang.demo.modules.system.authority.entity.Authority;
import com.wang.demo.modules.system.authority.service.AuthorityService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangjianhua
 * @date 2021-03-24 14:10
 */
@RestController
@RequestMapping("system/authority")
@Api(tags = "【系统管理】【权限管理】")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    @PostMapping("list")
    @ApiOperation(value = "分页查询",notes = "权限分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="current", value="页码（默认第1页）", dataType = "int", example = "1", paramType="body"),
            @ApiImplicitParam(name="size", value="每页条数（默认每页10条）", dataType = "int", example = "10", paramType="body")
    })
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_GUEST')")
    public IPage<Authority> get(@RequestBody BasePage<Authority> page){
        return authorityService.findByPage(page);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_GUEST')")
    @ApiOperation(value = "【主键查询】", notes = "主键ID必填信息")
    public Authority get(@ApiParam(name = "id", value = "角色主键", required = true, example = "1") @PathVariable int id)
    {
        return authorityService.findById(id);
    }

    @PostMapping(produces = "application/json")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation(value = "【权限添加】", notes = "name权限名称是必填项")
    public void save(@RequestBody Authority entity)
    {
        authorityService.insert(entity);
    }
    @PutMapping(produces = "application/json")
    @ApiOperation(value = "【权限修改】", notes = "name权限名称是必填项")
    public void update(@RequestBody Authority entity)
    {
        authorityService.updateRole(entity);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation(value = "【删除】",notes = "单个权限删除")
    public void deleteById(@ApiParam(name = "id",value = "用户主键",required = true) @PathVariable("id") int id){
        authorityService.deleteById(id);
    }

}
