package com.maven.springboot.study01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
        assertThat(29).isLessThan(subTest1(100,70));
        assertThat(98).isEqualTo(subTest1(100,2));
        assertThat(3).isEqualTo(subTest1(10,7));
        assertThat(301).isGreaterThan(subTest1(1000,700));

        //Exception 예외가 발생해야지만 정상 동작으로 인식
        assertThatThrownBy(() -> subTest1(70000,7)).isInstanceOf(Exception.class);
        
        
        //RuntimeException 예외가 발생해야지만 정상 동작으로 인식
        Throwable exception = assertThrows(RuntimeException.class, () ->{
            subTest1(2330,50002);
        });
        System.out.println(exception.toString());
    }

    int subTest1(int n1, int n2) throws Exception {
        if (n1 < -50000 || n1 > 50000) {
            throw new Exception("num1 값은 -50000보다 작거나 50000보다 큽니다");
        }
        if (n2 < -50000 || n2 > 50000) {
            throw new RuntimeException("num1 값은 -50000보다 작거나 50000보다 큽니다");
        }
        return n1 - n2;
    }


}


