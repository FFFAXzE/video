package com.cdu.videoshare.model;

import lombok.Data;

/**
 * @ClassName Admin
 * @Version 1.0
 * @Author 何政梁
 * @Date 2021/1/13 10:55
 * @Description TODO
 * Modification User:
 * Modification Date:
 */
@Data
public class Admin {
    private int id;
    private String account;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
