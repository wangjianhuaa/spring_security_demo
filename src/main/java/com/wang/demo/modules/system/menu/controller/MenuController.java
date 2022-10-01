package com.wang.demo.modules.system.menu.controller;

import com.wang.demo.modules.system.menu.entity.MenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping
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



}
