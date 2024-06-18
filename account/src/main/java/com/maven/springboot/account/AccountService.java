package com.maven.springboot.account;

import jdk.jshell.spi.ExecutionControlProvider;

import java.util.ArrayList;

public class AccountService {

    private ArrayList<Account> accounts =new ArrayList<>();

    public int size() {
        return accounts.size();
    }

    public void clear() {
        accounts.clear();
    }

    public void addAccount(String num, String name, int money) {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                System.out.println("계좌번호는 숫자만 입력해주세요");
                return;
            }
        }
        accounts.add(new Account(num, name, money));
    }

    public ArrayList<Account> getAllAccount() {
        return accounts;
    }

    public boolean deposit(String accountNum,int money) throws Exception{
        if (money < 0) {
            throw new Exception("0이상의 값을 입력해주세요");
        }
        Account account = findAccountByNumber(accountNum);
        if (account == null) {
            return false;
        }

        account.setBalance(account.getBalance()+money);
        return true;


    }

    public boolean withdraw(String accountNum,int money) throws Exception{
        if (money < 0) {
            throw new Exception("0이상의 값을 입력해주세요");
        }

        Account account = findAccountByNumber(accountNum);
        if (account == null) {
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
        if (accountNum == null || accounts.isEmpty()) {
            return null;
        }
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNum.equals(accounts.get(i).getAccountNum())) {
                return accounts.get(i);
            }
            break;
        }
        return null;
    }
}
