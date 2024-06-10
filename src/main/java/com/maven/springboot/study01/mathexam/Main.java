package com.maven.springboot.study01.mathexam;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.codeUp1214();
    }

    public long pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        if (a == 1) {
            return 1;
        }
        long half = pow(a, b / 2);

        if (b % 2 == 0) {
            return half * half;
        } else {
            return half * half * a;
        }
    }

    public void even(int n) {
        while (n-- >= 1) {
            if (!(n % 2 == 0)) {
                continue;
            }
            System.out.println(n);
        }
    }

    public void codeUp1180() throws Exception {
        Scanner sc = new Scanner(System.in);

        int input = 0;
        input = sc.nextInt();


        if (input < 1 || input > 99) {
            throw new Exception("휴지통 용량은 1 ~ 99");
        }
        int output = 0;


        if (input < 10) {
            output = input * 10 * 2;
        } else {
            output = ((input % 10 * 10) + (input / 10)) * 2;
        }

        if (output > 100) {
            output %= 100;
        }
        System.out.println(output);

        String good = output <= 50 ? "GOOD" : "OH MY GOD";
        System.out.println(good);

    }

    public void codeUp1165() throws Exception {
        Scanner sc = new Scanner(System.in);

        int time = 0, score = 0;

        time = sc.nextInt();
        score = sc.nextInt();

        int goal = 0;
        for (int i = time; i < 90; i += 5) {
            goal++;
        }

        int res = goal + score;
        System.out.println(res);
    }

    public void codeUp1205() throws Exception {
        Scanner sc = new Scanner(System.in);

        int a = 0, b = 0;

        a = sc.nextInt();
        b = sc.nextInt();

        int add = a + b;
        int sub = (a > b) ? a - b : b - a;
        int mul = a * b;
        int div = 0;
        if (a != 0 && b != 0) {
            div = (a > b) ? a / b : b / a;
        }
        int squ1 = (int) Math.pow(a, b);
        int squ2 = (int) Math.pow(b, a);
        int square = (squ1 > squ2) ? squ1 : squ2;

        int[] results = {add, sub, mul, div, square};
        int max = results[0];
        for (int i = 0; i < results.length; i++) {
            if (results[i] > max) {
                max = results[i];
            }
        }
        double res = max;

        System.out.println(String.format("%.6f", res));
    }

    public void codeUp1212() throws Exception {
        Scanner sc = new Scanner(System.in);

        int a = 0, b = 0, c = 0;

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        int[] lines = {a, b, c};
        int max = lines[0];

        String res = "";

        for (int i = 0; i < lines.length; i++) {
            if (lines[i] > max) {
                max = lines[i];
            }
        }
        Arrays.sort(lines);
        if (lines[2] < lines[0] + lines[1]) {
            res = "yes";
        } else {
            res = "no";
        }
        System.out.println(res);
    }

    public void codeUp1214() {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();

        int result=0;


        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                result=31;
                break;
            case 2:
                result=(year % 400 == 0 || (year % 4 == 0 && !(year % 100 == 0)))?29:28;
                break;
            default:
                result=30;
                break;
        }

        System.out.println(result);

    }

}
