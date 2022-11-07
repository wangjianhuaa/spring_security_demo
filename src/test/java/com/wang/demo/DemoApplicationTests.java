package com.wang.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.demo.base.entity.BasePage;
import com.wang.demo.modules.system.menu.service.MenuService;
import com.wang.demo.modules.system.user.entity.User;
import com.wang.demo.modules.system.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        BasePage<User> basePage = new BasePage<>();
        Page<User> page = new Page<>();
        page.setCurrent(1);
        page.setSize(10);
        basePage.setPage(page);
        basePage.setEntity(new User());
        IPage<User> userIPage = userService.find(basePage);
    }

    @Autowired
    private UserService userService;

    @Test
    void testUser(){
        userService.findIdByUserName("rain");
    }

    @Autowired
    private MenuService menuService;

    @Test
    void menuList(){
        menuService.syncMenuTreeList();
    }

}
