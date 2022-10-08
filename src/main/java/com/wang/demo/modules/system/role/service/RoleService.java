package com.wang.demo.modules.system.role.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.demo.base.entity.BasePage;
import com.wang.demo.modules.system.role.entity.Role;
import com.wang.demo.modules.system.role.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wangjianhua
 * @date 2021-03-24 13:57
 */
@Service
@Transactional(readOnly = true)
public class RoleService extends ServiceImpl<RoleMapper, Role> {

    /**
     * role角色插入
     * @param role 要插入的角色
     * @return
     */
    @Transactional(readOnly = false)
    public int insert(Role role){
        return baseMapper.insert(role);
    }

    @Transactional(readOnly = false)
    public int updateRole(Role role){
        return baseMapper.updateById(role);
    }

    /**
     * role角色获取
     * @param id 主键
     * @return Role
     */
    public Role findById(int id){
        return baseMapper.selectById(id);
    }

    /**
     * 角色分页查询
     * @param page 分页参数
     * @return 分页
     */
    public IPage<Role> findByPage(BasePage<Role> page){
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if(StringUtils.hasText(page.getEntity().getName())){
            wrapper.like("name",page.getEntity().getName());
        }
        return baseMapper.selectPage(page.getPage(),wrapper);
    }

    /**
     * 删除角色
     * @param id
     */
    @Transactional(readOnly = false)
    public void deleteById(int id){
        baseMapper.deleteById(id);
    }

    }

