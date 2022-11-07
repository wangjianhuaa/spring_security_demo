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

    List<Menu> selectListByParentId(String id);
}
