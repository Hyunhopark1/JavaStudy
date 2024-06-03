package com.maven.springboot.study01.mathexam;

import java.util.Arrays;

public class MathExam {

    public static void main(String[] args) throws Exception {
        MathExam me = new MathExam();
        int n1 = 3, n2 = 1;
        int res = me.subTest1(n1, n2);

        System.out.println(res);

    }

    public int subTest1(int n1, int n2) throws Exception {
        if (n1 < -50000 || n1 > 50000) {
            throw new Exception("num1 값은 -50000보다 작거나 50000보다 큽니다");
        }
        if (n2 < -50000 || n2 > 50000) {
            throw new RuntimeException("num1 값은 -50000보다 작거나 50000보다 큽니다");
        }
        return n1 - n2;
    }

    public int mathTest2(int n1, int n2) throws Exception {
        if (n1 < 0 || n1 > 100) {
            throw new Exception("num1 값은 0보다 작거나 100보다 큽니다");
        }
        if (n2 < 0 || n2 > 100) {
            throw new Exception("num1 값은 0보다 작거나 100보다 큽니다");
        }
        return n1 * n2;
    }

    //숫자 비교
    public int mathTest4(int n1, int n2) throws Exception {


        if (n1 < 0 || n1 > 10000) {
            throw new Exception("num1값은 0~10000사이값 이어야 합니다");
        }
        if (n2 < 0 || n2 > 10000) {
            throw new Exception("num2값은 0~10000사이값 이어야 합니다");
        }
        return n1 == n2 ? 1 : -1;
    }

    //배열의 평균값
    public double mathTest120817(int[] numbers) throws Exception {
        int sum = 0;
        double avg = 0.0d;

        if (numbers == null) {
            throw new Exception("numbers 배열이 비어 있습니다.");
        }
        if (numbers.length < 1 || numbers.length > 100) {
            throw new Exception("배열의 크기는 1~100 사이값 이어야 합니다");
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > 1000) {
                throw new Exception("배열안의 값은 0~1000 사이값 이어야 합니다.");
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        avg = (double) sum / numbers.length;

        return avg;
    }

    //각도기
    public int mathTest120829(int angle) throws Exception {
        int ans = 0;
        if (angle < 0 || angle > 180) {
            throw new Exception("각은 0도에서 180도 사이값 이어야 합니다");
        }
        if (0 < angle && angle < 90) {
            ans = 1;
        }
        if (angle == 90) {
            ans = 2;
        }
        if (90 < angle && angle < 180) {
            ans = 3;
        }
        if (angle == 180) {
            ans = 4;
        }
        return ans;

    }

    //짝수의 합
    public int mathTest120831(int n) throws Exception {
        int ans = 0;
        if (n < 0 || n > 1000) {
            throw new Exception("n은 0보다 크고 1000이하값 이어야 합니다 ");
        }
        while (n != 0) {
            if (n % 2 == 0) {
                ans += n;
            }
            n--;
        }
        return ans;
    }

    //양꼬치
    public int mathTest120830(int n, int k) throws Exception {

        //n은 1개당 12000원, k는 1개당 2000원
        //n이 10을 넘길때마다 k 1개 --
        int ans = 0;
        if (n < 0 || n > 1000) {
            throw new Exception("n은 0보다 크고 1000이하값 이어야 합니다 ");
        }
        if (k < n / 10 || k > 1000) {
            throw new Exception("k는 n/10 이상, 1000 미만값 이어야 합니다");
        }


        ans = n * 12000 + k * 2000 - n / 10 * 2000;
        return ans;
    }

    //나이 받아서 출생연도 출력
    public int mathTest120820(int age) throws Exception {
        if (age < 0 || age > 120) {
            throw new Exception("나이는 0초과 120미만 값이어야 합니다");
        }


        int year = 2024 - (age - 1);

        return year;
    }

    //정수의 나눗셈
    public int mathTest120806(int num1, int num2) throws Exception {

        if (num1 < 0 || num1 > 100) {
            throw new Exception("num1은 0초과 100이하 값이어야 합니다");
        }
        if (num2 < 0 || num2 > 100) {
            throw new Exception("num2은 0초과 100이하 값이어야 합니다");
        }

        double res = (double) num1 / num2;
        int ans = (int) (res * 1000);


        return ans;
    }

    //최댓값 만들기
    public int mathTest120847(int[] numbers) throws Exception {

        if (numbers.length < 2 || numbers.length > 100) {
            throw new Exception("배열의 길이는 2이상 100이하 여야 합니다");
        }
        for (int number : numbers) {
            if (number < 0 || number > 10000) {
                throw new Exception("배열의 원소는 0이상 10000이하 여야 합니다.");
            }
        }
        Arrays.sort(numbers);

        int ans = numbers[numbers.length - 1] * numbers[numbers.length - 2];

        return ans;

    }

    //중복된 숫자 개수
    public int mathTest120583(int[] array, int n) throws Exception {
        if (array.length < 1 || array.length > 100) {
            throw new Exception("배열의 길이는 1~100");
        }
        for (int arr : array) {
            if (arr < 0 || arr > 1000) {
                throw new Exception("배열의 원소는 0~1000");
            }
        }
        if(n<0 || n>1000){
            throw new Exception("n은 0~1000");
        }

        int ans=0;
        for(int arr: array){
            if(arr==n){
                ans++;
            }
        }
        return ans;
    }
}


