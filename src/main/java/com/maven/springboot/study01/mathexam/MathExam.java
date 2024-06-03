package com.maven.springboot.study01.mathexam;


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

    public int mathTest4(int n1, int n2) throws Exception {


        if (n1 < 0 || n1 > 10000) {
            throw new Exception("num1값은 0~10000사이값 이어야 합니다");
        }
        if (n2 < 0 || n2 > 10000) {
            throw new Exception("num2값은 0~10000사이값 이어야 합니다");
        }
        return (n1 == n2) ? 1 : -1;
    }

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
        if (angle > 180) {
            ans = 4;
        }
        return ans;

    }

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
    /*
    public int mathTest120830(int n,int k) throws Exception {

        //n은 1개당 12000원, k는 1개당 2000원
        //n이 10을 넘길때마다 k 1개 --
        int npay;
        int kpay;

        int ans = 0;
        if (n < 0 || n > 1000) {
            throw new Exception("n은 0보다 크고 1000이하값 이어야 합니다 ");
        }
        if (k < n / 10 || k > 1000) {
            throw new Exception("k는 n/10 이상, 1000 미만값 이어야 합니다");
        }

        npay=n*12000;
        kpay=k*2000;




    }
    */


}


