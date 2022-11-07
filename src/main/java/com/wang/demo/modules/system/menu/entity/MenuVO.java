package com.wang.demo.modules.system.menu.entity;

import java.util.List;

/**
 * @author wangjianhua
 * @Description
 * @date 2022/9/23/023 21:33
 */
public class MenuVO {

    private int id;

    /**
     * 名字
     */
    private String name;

    /**
     * 路径
     */
    private String path;

    /**
     * 排序
     */
    private Integer order;


    /**
     * 状态
     */
    private int status;

    private List<MenuVO> children;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<MenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }

    public MenuVO(int id, String name, String path, Integer order, int status, List<MenuVO> children) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.order = order;
        this.status = status;
        this.children = children;
    }

    public MenuVO() {
    }

    @Override
    public String toString() {
        return "MenuVO{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", order=" + order +
                ", status=" + status +
                ", children=" + children +
                '}';
    }
}
