package com.maven.springboot.study01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class exam1Test {
    @Test
    public void subtract1() throws Exception {
        //given 테스트 하기 위한 준비 동작
//        int num1=-50003,num2=3;
//        int expected = -50006;

//        //when  테스트를 실시
//        int actual = subTest1(num1, num2);
//        System.out.println(actual);
//        //then  //실제값과 기대값을 비교해서 테스트 한다.
//        assertThat(0).isEqualTo(subTest1(2,3));
//        assertThat(98).isEqualTo(subTest1(100,2));
//        assertThat(7).isEqualTo(subTest1(10,3));
//        assertThat(10).isLessThan(subTest1(100,70));

//        //assertThat(actual).isEqualTo(expected).describedAs("실제값과 다름");
        int num1=3,num2=1;
        int res=subTest1(num1,num2);
        System.out.println(res);
    }

    int subTest1(int n1, int n2) throws Exception {
        if (n1 < -50000 || n1 > 50000) {
            throw new Exception("num1 값은 -50000보다 작거나 50000보다 큽니다");
        }
        if (n2 < -50000 || n2 > 50000) {
            throw new Exception("num1 값은 -50000보다 작거나 50000보다 큽니다");
        }
        return n1 - n2;
    }


}


