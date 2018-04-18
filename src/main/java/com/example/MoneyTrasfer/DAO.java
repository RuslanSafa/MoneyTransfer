package com.example.MoneyTrasfer;

import com.example.MoneyTrasfer.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Хранилище данных
 */

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

    /**
     * Проверка наличия пользователя в базе данных.
     *
     * @param id - Идентификатор пользователя.
     * @return true - пользователь есть в базе, иначе false.
     */
    public boolean isUserInData(int id) {
        return data.containsKey(id);
    }

    /**
     * Получение имени пользователя по идентификатору
     *
     * @param id - Идентификатор пользователя.
     * @return Имя пользователя.
     */
    public String getUserName(int id) {
        return data.get(id).getUserName();
    }

    /**
     * Получение остатка денежных средств у пользователя.
     *
     * @param id -  Идентификатор пользователя.
     * @return Остаток на счете.
     */
    public BigDecimal getUserMoney(int id) {
        return data.get(id).getMoney();
    }

    /**
     * Установка нового значения баланса пользователя.
     *
     * @param id    -  Идентификатор пользователя.
     * @param money - Сумма нового баланса.
     */
    public void setUserMoney(int id, BigDecimal money) {
        data.get(id).setMoney(money);
    }

}
