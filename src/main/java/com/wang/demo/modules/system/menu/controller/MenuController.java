package com.wang.demo.modules.system.menu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wang.demo.base.entity.BasePage;
import com.wang.demo.modules.system.authority.entity.Authority;
import com.wang.demo.modules.system.menu.entity.Menu;
import com.wang.demo.modules.system.menu.entity.MenuVO;
import com.wang.demo.modules.system.menu.service.MenuService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjianhua
 * @Description
 * @date 2022/9/23/023 21:37
 */
@RestController
@RequestMapping("system/menu")
@Api(tags = "【系统管理】【菜单管理】")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("getMenuList")
    @ApiOperation(value = "查询",notes = "菜单查询")
    public List<MenuVO> getMenuIndex(){
        //todo 待办 菜单创建菜单表 crud 以及相应权限配置和菜单获取
        List<MenuVO> menuVOList = new ArrayList<>();
        List<MenuVO> userList = new ArrayList<>();
        userList.add(new MenuVO(110,"用户列表","users",110,0,null));
        MenuVO menuVO1 = new MenuVO(1,"用户管理","users",1,0,userList);
        menuVO1.setChildren(userList);
        MenuVO menuVO2 = new MenuVO(2,"权限管理","roles",2,0,null);
        List<MenuVO> roleList = new ArrayList<>();
        roleList.add(new MenuVO(210,"角色列表","roles",210,0,null));
        roleList.add(new MenuVO(220,"权限列表","auths",220,0,null));
        menuVO2.setChildren(roleList);
        List<MenuVO> menuList = new ArrayList<>();
        menuList.add(new MenuVO(310,"菜单列表","menus",310,0,null));
        MenuVO menuVO3 = new MenuVO(3,"菜单管理","menu",3,0,null);
        menuVO3.setChildren(menuList);
        MenuVO menuVO4 = new MenuVO(4,"其他","others",4,0,null);
        menuVOList.add(menuVO1);
        menuVOList.add(menuVO2);
        menuVOList.add(menuVO3);
        menuVOList.add(menuVO4);

        //先造一个数据

        return menuVOList;
    }

    @PostMapping("list")
    @ApiOperation(value = "分页查询",notes = "菜单分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="current", value="页码（默认第1页）", dataType = "int", example = "1", paramType="body"),
            @ApiImplicitParam(name="size", value="每页条数（默认每页10条）", dataType = "int", example = "10", paramType="body")
    })
    public IPage<Menu> get(@RequestBody BasePage<Menu> page){
        return menuService.findByPage(page);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "【主键查询】", notes = "主键ID必填信息")
    public Menu get(@ApiParam(name = "id", value = "菜单主键", required = true, example = "1") @PathVariable int id)
    {
        return menuService.findById(id);
    }

    @PostMapping(produces = "application/json")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation(value = "【菜单添加】", notes = "name菜单名称是必填项")
    public void save(@RequestBody Menu entity)
    {
        menuService.insert(entity);
    }
    @PutMapping(produces = "application/json")
    @ApiOperation(value = "【菜单修改】", notes = "name权限名称是必填项")
    public void update(@RequestBody Menu entity)
    {
        menuService.updateMenu(entity);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation(value = "【删除】",notes = "单个菜单删除")
    public void deleteById(@ApiParam(name = "id",value = "菜单主键",required = true) @PathVariable("id") int id){
        menuService.deleteById(id);
    }



}
