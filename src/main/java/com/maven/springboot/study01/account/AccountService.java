package com.maven.springboot.study01.account;

import com.maven.springboot.study01.account.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private List<Account> accountList = new ArrayList<>();

    public int size() {
        return this.accountList.size();
    }

    public void clear() {
        this.accountList.clear();
    }

    public boolean addAccount(String name, String bankAccount, int money) {
        return this.accountList.add(new Account(name, bankAccount, money));
    }

    public boolean addAccount(Account account) {
        return this.accountList.add(account);
    }

    public List<Account> getAllAccount() {
        return this.accountList;
    }

    /**
     * Account 에 예금
     * @param bankAccount 계좌번호
     * @param money 인출액
     * @return 성공하면 true 실패하면 false
     */
    public boolean deposit(String bankAccount, int money) {
        Account account = this.findAccountByNumber(bankAccount);
        if ( account == null ) {
            return false;
        }
        account.setCurrent(account.getCurrent() + money);
        return true;
    }

    public boolean withdraw(String bankAccount, int money) {
        Account account = this.findAccountByNumber(bankAccount);
        if ( account == null ) {
            return false;
        }
        if ( account.getCurrent() >= money ) {
            account.setCurrent(account.getCurrent() - money);
            return true;
        } else {
            return false;
        }
    }

    public Account findAccountByNumber( String bankAccount ) {
        if ( bankAccount == null || bankAccount.isEmpty() ) {
            return null;
        }
        for ( Account account : accountList ) {
            if ( bankAccount.equals(account.getBankNumber()) ) {
                return account;
            }
        }
        return null;
    }
}
