package com.example.MoneyTrasfer.dto;

import java.math.BigDecimal;

public class User {
    private final int id;
    private final String userName;
    private BigDecimal money;

    public User(int id, String userName, BigDecimal money) {
        this.id = id;
        this.userName = userName;
        this.money = money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public int getId() {

        return id;
    }

    public String getUserName() {
        return userName;
    }

    public BigDecimal getMoney() {
        return money;
    }
}
