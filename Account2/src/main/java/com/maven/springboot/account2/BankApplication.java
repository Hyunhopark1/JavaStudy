package com.maven.springboot.account2;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
    AccountService accountService =new AccountService();
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BankApplication bApp=new BankApplication();

        try {
            while (true) {
                bApp.showMenu();
                int choice = bApp.getChoice();
                switch (choice) {
                    case 1:
                        bApp.addAccount();
                        break;
                    case 2:
                        bApp.showAccounts();
                        break;
                    case 3:
                        bApp.income();
                        break;
                    case 4:
                        bApp.outcome();
                        break;
                    case 5:
                        System.out.println("프로그램 종료");
                        return;
                    case 6:
                        bApp.deleteAccount();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void showMenu() {
        System.out.println("=============================================");
        System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 | 6. 계좌삭제");
        System.out.println("=============================================");
    }

    private int getChoice() {

        System.out.print("선택>");
        String c = sc.nextLine();
        return Integer.parseInt(c);
    }

    private void addAccount() {
        System.out.println("=============================================");
        System.out.println("계좌생성");
        System.out.println("=============================================");

        System.out.print("계좌번호(6자리 이내의 숫자입력) : ");
        String accountNum=sc.nextLine();
        System.out.print("계좌주 : ");
        String accountName=sc.nextLine();
        System.out.print("초기입금액 : ");
        String m =sc.nextLine();
        int money = Integer.parseInt(m);

        if (accountService.addAccount(accountNum, accountName, money)) {
            System.out.println("결과 : 계좌가 생성되었습니다.");
        }else{
            System.out.println("결과 : 계좌 생성 실패하였습니다.");
        }

    }
    private void showAccounts() {
        System.out.println("=============================================");
        System.out.println("계좌목록");
        System.out.println("=============================================");

        ArrayList<Account> list =accountService.getAllAccount();
        if (list.isEmpty()) {
            System.out.println("현재 생성된 계좌가 없습니다");
        }
        for (Account account : list) {
            System.out.println(account.toString());
        }
    }
    private void income() {
        System.out.println("=============================================");
        System.out.println("예금");
        System.out.println("=============================================");

        System.out.print("계좌번호 : ");
        String accountNum=sc.nextLine();
        System.out.print("예금액 : ");
        String m =sc.nextLine();
        int money = Integer.parseInt(m);



        if (accountService.deposit(accountNum, money)) {
            Account account = accountService.findAccountByNumber(accountNum);
            int beforeMoney = account.getBalance() - money;
            int afterMoney = account.getBalance();
            System.out.println("결과 : "+accountNum+" 계좌에 "+ money + "원 예금완료 ");
            System.out.println("잔액 : "+beforeMoney+"-->"+afterMoney);
        }else{
            System.out.println("결과 : 예금 실패하였습니다.");
        }
    }
    private void outcome() {
        System.out.println("=============================================");
        System.out.println("출금");
        System.out.println("=============================================");

        System.out.print("계좌번호 : ");
        String accountNum=sc.nextLine();
        System.out.print("출금액 : ");
        String m =sc.nextLine();
        int money = Integer.parseInt(m);


        if (accountService.withdraw(accountNum, money)) {
            Account account = accountService.findAccountByNumber(accountNum);
            int beforeMoney = account.getBalance() - money;
            int afterMoney = account.getBalance();
            System.out.println("결과 : "+accountNum+" 계좌에서 "+ money + "원 출금완료 ");
            System.out.println("잔액 : "+beforeMoney+"-->"+afterMoney);
        }else{
            System.out.println("결과 : 출금 실패하였습니다.");
        }
    }

    private void deleteAccount() {
        System.out.println("=============================================");
        System.out.println("계좌 삭제");
        System.out.println("=============================================");

        System.out.print("계좌 번호 :");
        String accountNum = sc.nextLine();
        System.out.println("해당 계좌 삭제를 원하시면 '삭제'를 입력하시오");
        String delete = sc.nextLine();

        if (delete.equals("삭제")) {
            if (accountService.deleteAccount(accountNum)) {
                System.out.println("결과 : "+accountNum+ " 계좌가 삭제되었습니다.");
            }else{
                System.out.println("결과 : 계좌 삭제 실패하였습니다");
            }
        }else{
            System.out.println("계좌 삭제 취소");
        }
    }
}
