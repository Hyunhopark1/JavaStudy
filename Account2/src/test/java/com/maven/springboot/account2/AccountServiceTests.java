package com.maven.springboot.account2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class AccountServiceTests {

    AccountService accountService = new AccountService();

    @Test
    public void addAccountTest() {
        //계좌 생성 -> 성공
        accountService.addAccount("111", "홍길동", 10000);
        assertThat(accountService.size()).isEqualTo(1);

        //이미 있는 계좌 생성 -> 실패
        boolean result = accountService.addAccount("111", "김제동", 20000);
        assertThat(result).isEqualTo(false);
        assertThat(accountService.size()).isEqualTo(1);

        //초기입금액 음수 -> 실패
        boolean result2 = accountService.addAccount("222", "김제동", -30000);
        assertThat(result2).isEqualTo(false);
        assertThat(accountService.size()).isEqualTo(1);

        //계좌번호에 숫자가 아닌 값 입력 -> 실패
        boolean result3 = accountService.addAccount("김응수", "김응수", 300000);
        assertThat(result3).isEqualTo(false);
        assertThat(accountService.size()).isEqualTo(1);
    }

    @Test
    public void depositTest() {

        accountService.clear();
        //계좌 생성 -> 성공
        accountService.addAccount("111111", "홍길동", 20000);
        accountService.addAccount("222222", "김제동", 30000);
        assertThat(accountService.size()).isEqualTo(2);

        //입금 시도 -> 성공
        boolean result = accountService.deposit("111111", 10000);
        assertThat(result).isEqualTo(true);

        // 잔액확인 -> 정상처리
        Account find = accountService.findAccountByNumber("111111");
        assertThat(find).isNotNull();
        assertThat(find.getBalance()).isEqualTo(30000);

        //없는 계좌번호 찾기 시도 -> null
        Account find2 = accountService.findAccountByNumber("333333");
        assertThat(find2).isNull();
    }

    @Test
    public void withdrawTest() {
        accountService.clear();
        //계좌생성 --> 성공
        accountService.addAccount("333333", "홍길동", 40000);
        assertThat(accountService.size()).isEqualTo(1);

        //출금시도-->성공
        boolean result = accountService.withdraw("333333", 20000);
        assertThat(result).isEqualTo(true);

        //잔액 확인 --> 성공
        Account find = accountService.findAccountByNumber("333333");
        assertThat(find).isNotNull();
        assertThat(find.getBalance()).isEqualTo(20000);

        //잔액보다 더 큰 출금 시도 -->출금실패
        boolean result2 = accountService.withdraw("333333", 30000);
        assertThat(result2).isEqualTo(false);

        //없는 계좌 찾기 -> null
        Account find2 = accountService.findAccountByNumber("555555");
        assertThat(find2).isNull();


    }
}