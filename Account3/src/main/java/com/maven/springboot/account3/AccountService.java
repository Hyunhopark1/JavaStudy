package com.maven.springboot.account3;

import java.util.ArrayList;
import java.util.List;

public interface AccountService {
     int size();
     void clear();
     boolean addAccount(String name, String bankAccount, int money);
     boolean addAccount(Account account);
     List<Account> getAllAccount();
     boolean deposit(String bankAccount, int money);
     boolean withdraw(String bankAccount, int money);
     Account findAccountByNumber( String bankAccount );
    void loadData(List<Account> accountList) throws Exception;
    void saveData(List<Account> accountList) throws Exception;

}
