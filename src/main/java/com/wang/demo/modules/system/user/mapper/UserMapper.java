package com.wang.demo.modules.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.demo.modules.system.role.entity.Role;
import com.wang.demo.modules.system.user.entity.User;
import com.wang.demo.modules.system.userRole.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统管理中用户管理
 * @author wangjianhua
 * @date 2021-03-18 14:00
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名获得id
     * @param username 用户名
     * @return id
     */
    int findIdByUserName(String name,String table);

    /**
     * 根据用户名获得用户信息
     * @param username 用户名
     * @return user实体
     */
    User findUserByUserName(String username);

    /**
     * 根据用户id获取用户拥有的角色
     * @param id id
     * @return 角色集合
     */
    List<String> findUserRolesByUserId(int id);

    /**
     * 根据用户id获取用户拥有的角色详情 用作前端构建role列表授权
     * @param id id
     * @return 集合
     */
    List<Role> findUserRoleListByUserId(int id);

    /**
     * 根据用户id获得授权码集合 用来判断是否有对应接口权限
     * @param id id
     * @return 权限码集合
     */
    List<String> findAuthorityCodeByUserId(int id);

    /**
     * 自定义的获取用户列表
     * @param end 结束
     * @param start 开始
     * @return 结果
     */
    List<User> selectListByPage(int start,int end);

    /**
     * 定制接口 修改名字和昵称 暂时不支持修改密码
     * @param user user
     */
    void updateUserById(User user);

    /**
     * 定制接口 将自增主键加入到对象并使用
     * @param user user
     * @return int
     */
    int saveUser(User user);

    /**
     * 用户权限中间表
     * @param userRole userRole
     * @return int
     */
    int insertUserRole(UserRole userRole);

    /**
     * 删除用户权限中间表
     * @param userId userId
     * @return int
     */
    int deleteUserRole(int userId);
}
