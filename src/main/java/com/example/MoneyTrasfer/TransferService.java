package com.example.MoneyTrasfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Класс управления переводом и запроса баланса.
 */
@Controller
public class TransferService {
    @Autowired
    private DAO dao;

    /**
     * Обработка запроса баланса пользователя по идентификатору.
     *
     * @param id - Идентификатор пользователя.
     * @return Если пользователь существует, баланс пользователя, иначе сообщение "Пользователь не найден"
     */
    @RequestMapping("/balance")
    @ResponseBody
    public String getBalance(@RequestParam("id") int id) {
        if (dao.isUserInData(id)) return dao.getUserMoney(id).toString();
        return "Пользователь не найден";
    }

    /**
     * Обработка запроса перевода необходимо суммы от отправиля к получателю.
     *
     * @param fromId - Идентификатор отправителя.
     * @param toId   - Идентификатор получателя.
     * @param sum    - Сумма перевода.
     * @return При успешном переводе сообщение "success!!", иначе сообщение о причине не возможности перевода.
     */
    @RequestMapping("/transfer")
    @ResponseBody
    public String transferMoney(@RequestParam("from") int fromId, @RequestParam("to") int toId, @RequestParam("sum") BigDecimal sum) {
        if (dao.isUserInData(fromId) && dao.isUserInData(toId)) {
            BigDecimal balanceFromUser = dao.getUserMoney(fromId);
            BigDecimal balanceToUser = dao.getUserMoney(toId);
            if ((balanceFromUser.compareTo(sum)) >= 0) {
                dao.setUserMoney(fromId, balanceFromUser.subtract(sum));
                dao.setUserMoney(toId, balanceToUser.add(sum));
                return "success!!";
            } else
                return "Не хватает денег!";
        } else return dao.isUserInData(fromId) ? "Получатель не найден в базе" : "Отправитель не найден в базе";

    }

}
