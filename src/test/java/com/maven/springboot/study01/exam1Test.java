package com.maven.springboot.study01;

import com.maven.springboot.study01.mathexam.MathExam;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class exam1Test {

    @Test

    public void subtract001() throws Exception {
        //given 테스트 하기 위한 준비 동작
        MathExam math=new MathExam();
//        int num1=-50003,num2=3;
//        int expected = -50006;

//        //when  테스트를 실시
//        int actual = subTest1(num1, num2);
//        System.out.println(actual);
//        //then  //실제값과 기대값을 비교해서 테스트 한다.


//        //assertThat(actual).isEqualTo(expected).describedAs("실제값과 다름");
        assertThat(29).isLessThan(math.subTest1(100,70));
        assertThat(98).isEqualTo(math.subTest1(100,2));
        assertThat(3).isEqualTo(math.subTest1(10,7));
        assertThat(301).isGreaterThan(math.subTest1(1000,700));

        //Exception 예외가 발생해야지만 정상 동작으로 인식
        assertThatThrownBy(() -> math.subTest1(70000,7)).isInstanceOf(Exception.class);
        
        
        //RuntimeException 예외가 발생해야지만 정상 동작으로 인식
        Throwable exception = assertThrows(RuntimeException.class, () ->{
            math.subTest1(2330,50002);
        });
        System.out.println(exception.toString());
    }
    @Test
    public void multiply001() throws Exception{
        //given
        MathExam math=new MathExam();
        //when
        //then
        assertThat(12).isEqualTo(math.mathTest2(3,4));
        assertThat(513).isEqualTo(math.mathTest2(27 ,19));

        assertThatThrownBy(() -> math.mathTest2(-1,10)).isInstanceOf(Exception.class);

        assertThatThrownBy(() -> math.mathTest2(2,103)).isInstanceOf(Exception.class);
    }




}


