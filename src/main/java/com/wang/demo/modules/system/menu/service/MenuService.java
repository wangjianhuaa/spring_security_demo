package com.wang.demo.modules.system.menu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.demo.base.entity.BasePage;
import com.wang.demo.modules.system.menu.entity.Menu;
import com.wang.demo.modules.system.menu.mapper.MenuMapper;
import com.wang.demo.modules.system.role.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author wangjianhua
 * @date 2021-03-18 14:22
 */
@Service
@Transactional(readOnly = true)
public class MenuService extends ServiceImpl<MenuMapper, Menu> {

    /**
     * 菜单分页查询
     * @param page 分页参数
     * @return 分页
     */
    public IPage<Menu> findByPage(BasePage<Menu> page){
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        if(StringUtils.hasText(page.getEntity().getName())){
            wrapper.like("name",page.getEntity().getName());
        }
        return baseMapper.selectPage(page.getPage(),wrapper);
    }

    /**
     * 菜单插入
     * @param menu 要插入的菜单
     * @return
     */
    @Transactional(readOnly = false)
    public int insert(Menu menu){
        return baseMapper.insert(menu);
    }
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

    @Transactional(readOnly = false)
    public int updateMenu(Menu menu){
        return baseMapper.updateById(menu);
    }



}
