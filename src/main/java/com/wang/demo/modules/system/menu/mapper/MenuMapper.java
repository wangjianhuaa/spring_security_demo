package com.wang.demo.modules.system.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.demo.modules.system.menu.entity.Menu;

import java.util.List;


/**
 * 系统管理中用户管理
 * @author wangjianhua
 * @date 2021-03-18 14:00
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过父id查找子级菜单
     * @param id id
     * @return 集合
     */
    List<Menu> selectListByParentId(String id);

    /**
     * 菜单新增
     * @param menu 菜单
     * @return 数量
     */
    int insertMenu(Menu menu);

    /**
     * 菜单修改
     * @param menu
     * @return
     */
    int updateMenu(Menu menu);
}
