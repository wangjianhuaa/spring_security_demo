package com.wang.demo.modules.system.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.demo.base.entity.BasePage;
import com.wang.demo.modules.system.role.service.RoleService;
import com.wang.demo.modules.system.user.entity.User;
import com.wang.demo.modules.system.user.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * restful风格的增删改查==>User
 * @author wangjianhua
 * @date 2021-04-14 11:18
 */
@RestController
@RequestMapping("system/user")
@Api(tags = "【系统管理】【用户管理】")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * @param page 基本分页条件
     * @return 分页结果
     */
    @PostMapping(produces = "application/json")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_GUEST')")
    @ApiOperation(value = "【分页查询】", notes = "用户分页查询")
    public IPage<User> get(@RequestBody BasePage<User> page)
    {
        return userService.find(page);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_GUEST')")
    @ApiOperation(value = "【主键查询】", notes = "主键ID必填信息")
    public User get(@ApiParam(name = "id", value = "用户主键", required = true, example = "1") @PathVariable int id)
    {
        return userService.findById(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "【新增】",notes = "用户新增")
    public void save(@Validated @RequestBody User user){
        userService.saveUser(user);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "【删除】",notes = "单个用户删除")
    public void deleteById(@ApiParam(name = "id",value = "用户主键",required = true) @PathVariable("id") int id){
        userService.deleteById(id);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "【修改】",notes = "用户修改")
    public void update(@Validated @RequestBody User user,@PathVariable("id") Integer id){
        //id没用 懒得改了
        userService.updateUser(user,id);
    }

    @GetMapping("roles")
    public User allRoles(){
        User user = new User();
        user.setRoles(roleService.list());
        return user;
    }
}
