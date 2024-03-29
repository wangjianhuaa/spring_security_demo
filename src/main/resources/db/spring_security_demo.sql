/*
 Navicat Premium Data Transfer

 Source Server         : 阿里服务器mysql 
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 47.96.98.214:3306
 Source Schema         : spring_security_demo

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 14/04/2021 14:56:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `revision` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `created_by` varchar(15) NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(15) NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES (1, '测试用户权限接口', 'testSecurity', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `authority` VALUES (2, '获取用户列表', 'user:get', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色码',
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `revision` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `created_by` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_GUEST', '访客', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role` VALUES (2, 'ROLE_ADMIN', '管理员', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for role_authority
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority`  (
  `role_id` int(11) NOT NULL COMMENT '角色外键',
  `authority_id` int(11) NOT NULL COMMENT '权限外键',
  `revision` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `created_by` varchar(11) NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(11) NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_authority
-- ----------------------------
INSERT INTO `role_authority` VALUES (1, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_authority` VALUES (1, 2, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `nick` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `pass` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `state` int(11) NULL DEFAULT NULL COMMENT '人员状态0启用 1禁用 2锁定',
  `revision` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `created_by` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '小雨', 'rain', '$2a$10$aRVfyyUYjSHaMxty9lDYiOjOB3GxN/0TgdBta5vmNDPxT09sZl5CC', 0, 1, '1', '2021-03-18 18:08:16', '1', '2021-03-18 18:08:22');
INSERT INTO `user` VALUES (2, '超管', 'admin', '$2a$10$aRVfyyUYjSHaMxty9lDYiOjOB3GxN/0TgdBta5vmNDPxT09sZl5CC', 0, 1, '1', '2021-04-06 21:47:40', '1', '2021-04-13 21:47:44');
INSERT INTO `user` VALUES (21, '访客用户', 'guest', '$2a$10$d3NGPQeKyvVpfi27jV5QjOvs.rAiAiYBFcdCHDwJhxi1YlrHQsQJe', 0, NULL, 'rain', '2023-02-01 19:48:45', 'rain', '2023-02-01 19:48:45');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(11) NOT NULL COMMENT '用户外键',
  `role_id` int(11) NOT NULL COMMENT '角色外键',
  `revision` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `created_by` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` int(11) NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES (1, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES (20, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES (20, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES (21, 1, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL ,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `parent_id` int(11) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `created_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_time` datetime(0) NULL DEFAULT NULL,
  `updated_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updated_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (0, 'super菜单', 'super', NULL, 0, 'rain', '2022-10-17 21:34:05', 'rain', '2022-10-17 21:34:05');
INSERT INTO `menu` VALUES (1, '用户管理', 'users', 0, 0, 'rain', '2022-11-07 20:20:34', 'rain', '2022-11-07 20:20:41');
INSERT INTO `menu` VALUES (2, '权限管理', 'roles', 0, 0, 'rain', '2022-11-07 20:21:59', 'rain', '2022-11-07 20:22:06');
INSERT INTO `menu` VALUES (3, '菜单管理', 'menu', 0, 0, 'rain', '2022-11-07 20:22:01', 'rain', '2022-11-07 20:22:10');
INSERT INTO `menu` VALUES (4, '其他', 'others', 0, 0, 'rain', '2022-11-07 20:22:03', 'rain', '2022-11-07 20:22:13');
INSERT INTO `menu` VALUES (101, '用户列表', 'users', 1, 0, 'rain', '2022-11-07 20:23:54', 'rain', '2022-11-07 20:24:09');
INSERT INTO `menu` VALUES (201, '角色列表', 'roles', 2, 0, 'rain', '2022-11-07 20:23:57', 'rain', '2022-11-07 20:24:15');
INSERT INTO `menu` VALUES (202, '权限列表', 'auths', 2, 0, 'rain', '2022-11-07 20:24:00', 'rain', '2022-11-07 20:24:18');
INSERT INTO `menu` VALUES (301, '菜单列表', 'menus', 3, 0, 'rain', '2022-11-07 20:24:03', 'rain', '2022-11-07 20:24:22');

SET FOREIGN_KEY_CHECKS = 1;
