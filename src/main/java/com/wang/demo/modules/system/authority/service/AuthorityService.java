package com.wang.demo.modules.system.authority.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.demo.base.entity.BasePage;
import com.wang.demo.modules.system.authority.entity.Authority;
import com.wang.demo.modules.system.authority.mapper.AuthorityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author wangjianhua
 * @Description
 * @date 2022/10/17 19:52
 */
@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class AuthorityService extends ServiceImpl<AuthorityMapper, Authority> {
    /**
     * 权限插入
     * @param authority 要插入的权限
     * @return
     */
    @Transactional(readOnly = false)
    public int insert(Authority authority){
        return baseMapper.insert(authority);
    }

    @Transactional(readOnly = false)
    public int updateRole(Authority authority){
        return baseMapper.updateById(authority);
    }

    /**
     * 权限查询
     * @param id 主键
     * @return Role
     */
    public Authority findById(int id){
        return baseMapper.selectById(id);
    }

    /**
     * 权限分页查询
     * @param page 分页参数
     * @return 分页
     */
    public IPage<Authority> findByPage(BasePage<Authority> page){
        QueryWrapper<Authority> wrapper = new QueryWrapper<>();
        if(StringUtils.hasText(page.getEntity().getName())){
            wrapper.like("name",page.getEntity().getName());
        }
        return baseMapper.selectPage(page.getPage(),wrapper);
    }

    /**
     * 删除权限
     * @param id
     */
    @Transactional(readOnly = false)
    public void deleteById(int id){
        baseMapper.deleteById(id);
    }

}
