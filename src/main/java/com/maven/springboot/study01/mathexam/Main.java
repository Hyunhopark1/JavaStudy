package com.maven.springboot.study01.mathexam;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.codeUp3015();
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

        int result = 0;


        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                result = 31;
                break;
            case 2:
                result = (year % 400 == 0 || (year % 4 == 0 && !(year % 100 == 0))) ? 29 : 28;
                break;
            default:
                result = 30;
                break;
        }

        System.out.println(result);

    }

    public void codeUp1226() {
        Scanner sc = new Scanner(System.in);
        int[] lottonum = new int[7];

        for (int i = 0; i < lottonum.length; i++) {
            lottonum[i] = sc.nextInt();
        }


        int[] mylotto = new int[6];
        for (int i = 0; i < mylotto.length; i++) {
            mylotto[i] = sc.nextInt();
        }
        Arrays.sort(mylotto);

        int cnt = 0;
        boolean bonus = false;


        for (int i = 0; i < mylotto.length; i++) {
            for (int j = 0; j < lottonum.length - 1; j++) {
                if (mylotto[i] == lottonum[j]) {
                    cnt++;
                }
            }
            if (mylotto[i] == lottonum[lottonum.length - 1]) {
                bonus = true;
            }
        }

        int res = 0;

        switch (cnt) {
            case 6:
                res = 1;
                break;
            case 5:
                res = bonus ? 2 : 3;
                break;
            case 4:
                res = 4;
                break;
            case 3:
                res = 5;
                break;
            default:
                res = 0;
                break;
        }
        System.out.println(res);
    }

    public void codeUp1218() {
        Scanner sc = new Scanner(System.in);

        int a = 0, b = 0, c = 0;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        String res = "";
        int[] sam = {a, b, c};
        Arrays.sort(sam);

        if (sam[2] >= sam[0] + sam[1]) {
            res = "삼각형아님";
        } else if (sam[0] == sam[1] && sam[1] == sam[2]) {
            res = "정삼각형";
        } else if ((sam[0] == sam[1] || sam[1] == sam[2])) {
            res = "이등변삼각형";
        } else if (Math.pow(sam[0], 2) + Math.pow(sam[1], 2) == Math.pow(sam[2], 2)) {
            res = "직각삼각형";
        } else {
            res = "삼각형";
        }

        System.out.println(res);
    }

    public void codeUp1283() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] c = new int[b];

        double rev = 0;
        for (int i = 0; i < c.length; i++) {
            c[i] = sc.nextInt();

            if (c[i] > 0) {
                rev = a + (c[i] / 100 * a);
            } else {
                rev += a + (-1 * (c[i] / 100 * a));
            }
        }
        double res = rev - a;
        System.out.println(String.format("%.0f", res));
        String s = (res > 0) ? "good" : (res == 0) ? "same" : "bad";
        System.out.println(s);

    }

    public void codeUp1228() {
        Scanner sc = new Scanner(System.in);

        double height = 0.0d;
        double weight = 0.0d;

        height = sc.nextDouble();
        weight = sc.nextDouble();

        double pyo = (height - 100) * 0.9;
        double bmi = (weight - pyo) * 100 / pyo;

        String res = "";
        if (bmi <= 10) {
            res = "정상";
        } else if (bmi <= 20) {
            res = "과체중";
        } else {
            res = "비만";
        }

        System.out.println(res);

    }

    public void codeUp3015() {
        Scanner sc = new Scanner(System.in);

        int dataCount;
        int printNum;

        dataCount = sc.nextInt();
        printNum = sc.nextInt();

        Student[] students = new Student[dataCount];

        for (int i = 0; i < students.length; i++) {
            String name = sc.next();
            int score = sc.nextInt();

            students[i] = new Student(name, score);

        }
        for (int i = 0; i < students.length; i++) {
            for (int j = i; j < students.length; j++) {
                if (students[i].getScore() < students[j].getScore()) {
                    Student tempStudent = students[i];
                    students[i]=students[j];
                    students[j]=tempStudent;

//                    String tempName = students[i].getName();
//                    int tempScore = students[i].getScore();
//
//
//                    students[i].setName(students[j].getName());
//                    students[i].setScore(students[j].getScore());
//
//                    students[j].setName(tempName);
//                    students[j].setScore(tempScore);
                }
            }
        }




        for (int i = 0; i < printNum; i++) {
            System.out.println(students[i].getName());
        }
    }

}
