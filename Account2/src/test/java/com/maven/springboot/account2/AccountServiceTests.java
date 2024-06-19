package com.maven.springboot.account2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class AccountServiceTests {

    AccountService accountService=new AccountService();

    @Test
    public void addAccount() {
        accountService.addAccount("111", "홍길동", 10000);

        assertThat(accountService.size()).isEqualTo(1);

        accountService.addAccount("111", "김제동", 20000);
        assertThat(accountService.size()).isEqualTo(2);
    }

}