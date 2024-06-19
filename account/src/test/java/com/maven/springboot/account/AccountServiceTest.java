package com.maven.springboot.account;

import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Test
    void addAccountTest() {
        AccountService accountService =new AccountService();

        accountService.clear();
        accountService.addAccount("qqq", "홍길동", 10000);

        assertThat(accountService.size()).isEqualTo(1);
        
        accountService.clear();
        accountService.addAccount("1111111", "김제동", -5000);
        assertThat(accountService.size()).isEqualTo(1);
    }



    @Test
    void depositTest() {
        AccountService accountService = new AccountService();
        accountService.addAccount("111111", "김제동", 5000);
        assertThat(accountService.size()).isEqualTo(1);

        boolean result =accountService.deposit("111111", -5000);
        assertThat(result).isEqualTo(true);


    }

    @Test
    void withdraw() {
    }
}