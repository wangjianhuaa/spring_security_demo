package com.wang.demo.modules.system.menu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wang.demo.base.constants.MenuConstants;
import com.wang.demo.base.entity.BasePage;
import com.wang.demo.modules.system.menu.entity.Menu;
import com.wang.demo.modules.system.menu.entity.MenuVO;
import com.wang.demo.modules.system.menu.mapper.MenuMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjianhua
 * @date 2021-03-18 14:22
 */
@Service
@Transactional(readOnly = true)
public class MenuService extends ServiceImpl<MenuMapper, Menu> {

    @Autowired
    private ObjectMapper objectMapper;

    @Resource
    private MenuMapper menuMapper;
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
        return baseMapper.insertMenu(menu);
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
        return menuMapper.updateMenu(menu);
    }

    /**
     * 同步构建菜单树 异步懒得做了 同步懒得优化了 能用就行
     * @return 这里直接查出所有菜单并递归构建菜单树
     */
    public List<MenuVO> syncMenuTreeList(){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("parent_id");
        List<Menu> menus = baseMapper.selectList(queryWrapper);
        //一共两层 这里直接构建即可
        List<MenuVO> menuVOList = new ArrayList<>();
        for (Menu menu : menus) {
            //一级菜单项目
            if(menu.getParentId()!= null && menu.getParentId().equals(MenuConstants.SUPER_MENU_ID)){
                MenuVO menuVO = new MenuVO();
                BeanUtils.copyProperties(menu,menuVO);
                menuVOList.add(menuVO);
            }
        }
        //二级菜单
        for (MenuVO menuVO : menuVOList) {
            int id = menuVO.getId();
            List<Menu> menus1 = menuMapper.selectListByParentId(id + "");
            List<MenuVO> t = new ArrayList<>();
            for (Menu menu : menus1) {
                MenuVO menuVO1 = new MenuVO();
                BeanUtils.copyProperties(menu,menuVO1);
                t.add(menuVO1);
            }
            menuVO.setChildren(t);
        }
//        try {
//            System.out.println(objectMapper.writeValueAsString(menuVOList));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        return menuVOList;
    }



}
