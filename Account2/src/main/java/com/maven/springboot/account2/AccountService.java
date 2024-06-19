package com.maven.springboot.account2;

import java.util.ArrayList;

public class AccountService {

    ArrayList<Account> accounts =new ArrayList<>();

    public int size() {
        return accounts.size();
    }
    public void clear() {
        accounts.clear();
    }

    public boolean addAccount(String accountNum, String accountName, int money) {

        if (money < 1) {
            System.out.println("초기입금액은 1 이상의 값을 입력해주세요");
            return false;
        }
        for (Account account : accounts) {
            if (accountNum.equals(account.getAccountNum())) {
                System.out.println("이미 등록된 계좌번호입니다");
                return false;
            }
        }
        accounts.add(new Account(accountNum, accountName, money));
        return true;
    }
    public ArrayList<Account> getAllAccount() {
        return accounts;
    }

    public boolean deposit(String accountNum, int money) {
        if (money < 1) {
            System.out.println("예금액은 양수값이어야 합니다");
            return false;
        }
        Account account = findAccountByNumber(accountNum);
        if (account == null) {
            System.out.println("["+accountNum+"] 계좌는 없는계좌입니다.");
            return false;
        }
        account.setBalance(account.getBalance()+money);
        return true;
    }

    public boolean withdraw(String accountNum, int money) {
        if (money < 1) {
            System.out.println("출금액은 양수값이어야 합니다");
            return false;
        }

        Account account = findAccountByNumber(accountNum);
        if (account == null) {
            System.out.println("["+accountNum+"] 계좌는 없는계좌입니다.");
            return false;
        }
        if (money > account.getBalance()) {
            System.out.println("계좌의 잔액이 부족합니다");
            return false;
        }

        account.setBalance(account.getBalance()-money);
        return true;
    }
    public Account findAccountByNumber(String accountNum) {
        if (accounts.isEmpty() || accountNum==null) {
            return null;
        }
        for (Account account : accounts) {
            if (accountNum.equals(account.getAccountNum())) {
                return account;
            }
        }
        return null;
    }
}
