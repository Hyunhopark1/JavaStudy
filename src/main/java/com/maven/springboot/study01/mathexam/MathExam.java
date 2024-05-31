package com.maven.springboot.study01.mathexam;




public class MathExam {

    public static void main(String[] args) throws Exception{
        MathExam me =new MathExam();
        int n1=3,n2=1;
        int res=me.subTest1(n1,n2);

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


        if(n1<0 || n1>10000){
            throw new Exception("num1값은 0~10000사이값 이어야 합니다");
        }
        if(n2<0 || n2>10000){
            throw new Exception("num2값은 0~10000사이값 이어야 합니다");
        }
        return (n1==n2)?1:-1;
    }


}


