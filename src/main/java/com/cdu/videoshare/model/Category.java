package com.cdu.videoshare.model;

import lombok.Data;

/**
 * @ClassName Category
 * @Version 1.0
 * @Author 何政梁
 * @Date 2021/1/13 15:08
 * @Description TODO
 * Modification User:
 * Modification Date:
 */
@Data
public class Category {
    private int id;
    private String name;

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
}
