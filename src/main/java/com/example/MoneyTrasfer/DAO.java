package com.example.MoneyTrasfer;

import com.example.MoneyTrasfer.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;

@Component
public class DAO {
    private static HashMap<Integer, User> data = new HashMap<Integer, User>();

    static {
        data.put(001, new User(001, "Ruslan", new BigDecimal(1000)));
        data.put(002, new User(002, "Petya", new BigDecimal(100)));
        data.put(003, new User(003, "Olya", new BigDecimal(40)));
        data.put(004, new User(004, "Oleg", new BigDecimal(5000)));
        data.put(005, new User(005, "Anton", new BigDecimal(699)));
    }

    public boolean isUserInData(int id) {
        return data.containsKey(id);
    }

    public String getUserName(int id) {
        return data.get(id).getUserName();
    }

    public BigDecimal getUserMoney(int id) {
        return data.get(id).getMoney();
    }

    public void setUserMoney(int id, BigDecimal money) {
        data.get(id).setMoney(money);
    }


}
