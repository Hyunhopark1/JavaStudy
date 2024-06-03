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
        assertThat(math.subTest1(100,70)).isLessThan(31);
        assertThat(math.subTest1(100,2)).isEqualTo(98);
        assertThat(math.subTest1(10,7)).isEqualTo(3);
        assertThat(math.subTest1(1000,700)).isGreaterThan(299);

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
        assertThat(math.mathTest2(3,4)).isEqualTo(12);
        assertThat(math.mathTest2(27 ,19)).isEqualTo(513);

        assertThatThrownBy(() -> math.mathTest2(-1,10)).isInstanceOf(Exception.class);

        assertThatThrownBy(() -> math.mathTest2(2,103)).isInstanceOf(Exception.class);



    }
    @Test
    public void compare001() throws Exception{
        //given
        MathExam math=new MathExam();
        //when
        //then
        assertThat(math.mathTest4(3,3)).isEqualTo(1);
        assertThat(math.mathTest4(27 ,19)).isEqualTo(-1);

        assertThatThrownBy(() -> math.mathTest4(-1,-1)).isInstanceOf(Exception.class);

        assertThatThrownBy(() -> math.mathTest4(10001,10001)).isInstanceOf(Exception.class);

        System.out.println(math.mathTest4(2,2));
    }

    @Test
    public void exam120817() throws Exception{
        MathExam math=new MathExam();

        int[] numbers={1,2,3,4,5,6,7,8,9,10};
        assertThat(math.mathTest120817(numbers)).isEqualTo(5.5);


        Throwable exception = assertThrows(Exception.class, () ->{
            math.mathTest120817(new int[]{0,1000,3000});
        });
        System.out.println(exception.toString());

        exception=assertThrows(Exception.class, () -> math.mathTest120817(new int[]{}));
        System.out.println(exception.toString());


    }
    @Test
    public void exam120829() throws Exception{
        MathExam math=new MathExam();

        int angle=180;
        assertThat(math.mathTest120829(angle)).isEqualTo(4);

    }
    @Test
    public void exam120831() throws Exception{
        MathExam math=new MathExam();

        int n=10;
        assertThat(math.mathTest120831(n)).isEqualTo(30);

    }

    @Test
    public void exam120830() throws Exception{
        MathExam math=new MathExam();
        //n은 1개당 12000 / k는 1개당 2000
        int n=12,k=3;

        assertThat(math.mathTest120830(n,k)).isEqualTo(148000);
    }

    @Test
    public void exam120820() throws Exception{
        System.out.println("exam120820");
        MathExam math=new MathExam();

        assertThat(math.mathTest120820(26)).isEqualTo(1999);
        Throwable exception=assertThrows(Exception.class, () ->math.mathTest120820(153));
        System.out.println(exception.toString());
    }

    @Test
    public void exam120806() throws Exception{
        System.out.println("exam120806");
        MathExam math=new MathExam();

        assertThat(math.mathTest120806(1,16)).isEqualTo(62);
    }
    @Test
    public void exam120847() throws Exception{
        System.out.println("exam120847");
        MathExam math=new MathExam();

        int[] numbers={1,2,3,4,5};

        assertThat(math.mathTest120847(numbers)).isEqualTo(20);
    }
    @Test
    public void exam120583() throws Exception{
        System.out.println("exam120583");
        MathExam math=new MathExam();

        int[] numbers={1,1,2,3,4,5};

        assertThat(math.mathTest120583(numbers,1)).isEqualTo(2);
    }

}


