package com.wang.demo.modules.system.menu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.demo.modules.system.menu.entity.Menu;
import com.wang.demo.modules.system.menu.mapper.MenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangjianhua
 * @date 2021-03-18 14:22
 */
@Service
@Transactional(readOnly = true)
public class MenuService extends ServiceImpl<MenuMapper, Menu> {


    /**
     * 根据主键id删除菜单
     * @param id id
     */
    @Transactional(readOnly = false)
    public void deleteById(int id){
        baseMapper.deleteById(id);
    }

    /**
     * 根据主键获取菜单
     * @param id 主键
     * @return 用户
     */
    public Menu findById(int id){
        return baseMapper.selectById(id);
    }



}
