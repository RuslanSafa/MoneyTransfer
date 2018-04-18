package com.example.MoneyTrasfer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransferServiceTest {
    @Autowired
    TransferService transferService;


    @Test
    public void getBalance() {
        String balance = transferService.getBalance(002);
        Assert.assertTrue(balance.equals("100"));
    }

    @Test
    public void transferTest() {
        String res = transferService.transferMoney(1, 3, new BigDecimal(300));
        Assert.assertTrue(res.equals("success!!"));
        res = transferService.transferMoney(2, 3, new BigDecimal(300));
        Assert.assertTrue(res.equals("Не хватает денег!"));
    }
}