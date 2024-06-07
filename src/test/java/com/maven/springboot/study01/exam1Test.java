package com.maven.springboot.study01;

import com.maven.springboot.study01.mathexam.MathExam;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

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
    @Test
    public void exam120585() throws Exception{
        System.out.println("exam120585");
        MathExam math=new MathExam();

        int[] numbers={195,199,157,163};

        assertThat(math.mathTest120585(numbers,175)).isEqualTo(2);
    }
    @Test
    public void exam120811() throws Exception{
        System.out.println("exam120811");
        MathExam math=new MathExam();

        int[] numbers={1,3,5,7,9};

        assertThat(math.mathTest120811(numbers)).isEqualTo(5);
    }
    @Test
    public void exam120813() throws Exception{
        System.out.println("exam120813");
        MathExam math=new MathExam();

        int[] expected={1, 3, 5, 7};
        assertThat(math.mathTest120813(8)).isEqualTo(expected);
    }
    @Test
    public void exam120814() throws Exception{
        System.out.println("exam120814");
        MathExam math=new MathExam();


        assertThat(math.mathTest120814(7)).isEqualTo(1);

        Throwable exception = assertThrows(Exception.class, () ->math.mathTest120814(101));
        System.out.println(exception.toString());
    }
    @Test
    public void exam120818() throws Exception{
        System.out.println("exam120818");
        MathExam math=new MathExam();


        assertThat(math.mathTest120818(150000)).isEqualTo(142500);
        assertThat(math.mathTest120818(580000)).isEqualTo(464000);
        Throwable exception = assertThrows(Exception.class, () ->math.mathTest120818(1200000));
        System.out.println(exception.toString());
        Throwable exception2 = assertThrows(Exception.class, () ->math.mathTest120818(10009));
        System.out.println(exception2.toString());
    }
    @Test
    public void exam120837() throws Exception{
        System.out.println("exam120837");
        MathExam math=new MathExam();


        assertThat(math.mathTest120837(23)).isEqualTo(5);
        assertThat(math.mathTest120837(999)).isEqualTo(201);
        assertThat(math.mathTest120837(24)).isEqualTo(6);
        Throwable exception = assertThrows(Exception.class, () ->math.mathTest120837(-3));
        System.out.println(exception.toString());
        Throwable exception2 = assertThrows(Exception.class, () ->math.mathTest120837(1002));
        System.out.println(exception2.toString());
    }
    @Test
    public void exam120839() throws Exception{
        System.out.println("exam120839");
        MathExam math=new MathExam();


        assertThat(math.mathTest120839("205")).isEqualTo("052");
        assertThat(math.mathTest120839("2")).isEqualTo("0");
        assertThat(math.mathTest120839("0")).isEqualTo("5");
        Throwable exception = assertThrows(Exception.class, () ->math.mathTest120839("105"));
        System.out.println(exception.toString());
        Throwable exception2 = assertThrows(Exception.class, () ->math.mathTest120839("999"));
        System.out.println(exception2.toString());
    }
 @Test
    public void exam120824() throws Exception{
        System.out.println("exam120839");
        MathExam math=new MathExam();



         assertThat(math.mathTest120824(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{2, 3});
         assertThat(math.mathTest120824(new int[]{1, 3,5,7})).isEqualTo(new int[]{0,4});

        Throwable exception = assertThrows(Exception.class, () ->math.mathTest120824(new int[]{1,2,3,1005}));
        System.out.println(exception.toString());
        Throwable exception2 = assertThrows(Exception.class, () ->math.mathTest120824(new int[]{1,2,5559,9000}));
        System.out.println(exception2.toString());
    }
    @Test
    public void exam120892() throws Exception{
        System.out.println("exam120839");
        MathExam math=new MathExam();



         assertThat(math.mathTest120892("dfjardstddetckdaccccdegk",4)).isEqualTo("attack");
         assertThat(math.mathTest120892("pfqallllabwaoclk",2)).isEqualTo("fallback");

        Throwable exception = assertThrows(Exception.class, () ->math.mathTest120892("ASDASDASFASF",4));
        System.out.println(exception.toString());
        Throwable exception2 = assertThrows(Exception.class, () ->math.mathTest120892("ASDASDA SFASF",8));
        System.out.println(exception2.toString());
    }
    @Test
    public void exam120899() throws Exception{
        System.out.println("exam120839");
        MathExam math=new MathExam();



         assertThat(math.mathTest120899(new int[]{1,8,3})).isEqualTo(new int[]{8,1});
         assertThat(math.mathTest120899(new int[]{9,10,11,8})).isEqualTo(new int[]{11,2});


        Throwable exception = assertThrows(Exception.class, () ->math.mathTest120899(new int[]{1,1020,3000}));
        System.out.println(exception.toString());



    }
    @Test
    public void lotto(){
        System.out.println("로또 번호 출력");
        int[] lottoarray = MathExam.lotto();

        System.out.println(Arrays.toString(lottoarray));
    }
    
    //진수 변환
    @Test
    public void numberprint() throws Exception{
        int x = 0b1011;
        int y = 0206;
        int z = 0x2A0F;


        char a='A',b='B',c='C';

        System.out.println(String.format("10 진수 : x = %d , y = %d , z = %d",x, y, z));
        System.out.println(String.format("8 진수 : a = %o , b = %o , c = %o",(int)a, (int)b, (int)c));
        System.out.println(String.format("16 진수 : a = %x , b = %x , c = %x",(int)a, (int)b, (int)c));
        System.out.println(String.format("Char : a = %c , b = %c , c = %c",(int)a, (int)b, (int)c));
        System.out.println("\n");
        System.out.println(String.format("10 진수 : a = %d , b = %d , c = %d",(int)a, (int)b, (int)c));
        System.out.println(String.format("8 진수 : a = %o , b = %o , c = %o",(int)a, (int)b, (int)c));
        System.out.println(String.format("16 진수 : a = %x , b = %x , c = %x",(int)a, (int)b, (int)c));
        System.out.println(String.format("Char : a = %c , b = %c , c = %c",a, b, c));

        System.out.println("\"\"");
        int d =-2147483647;
        int e =2147483647;
        System.out.println(String.format("16진수 : d = %x",d));
        System.out.println(String.format("16진수 : e = %x",e));

    
    }


}


