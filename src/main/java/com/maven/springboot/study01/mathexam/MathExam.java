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
        if (n % 2 != 0) {
            n--;
        }
        while (n > 0) {
            ans += n;
            n -= 2;
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
                throw new Exception(String.format("[%d]는 배열의 크기를 벗어났습니다", n));
            }
        }
        if (n < 0 || n > 1000) {
            throw new Exception("n은 0~1000");
        }

        int ans = 0;
        for (int arr : array) {
            if (arr == n) {
                ans++;
            }
        }
        return ans;
    }

    //머쓱이
    public int mathTest120585(int[] array, int height) throws Exception {
        if (array.length < 1 || array.length > 100) {
            throw new Exception("배열의 길이 1~100");
        }
        if (height < 1 || height > 200) {
            throw new Exception(String.format("[%d]는 1~200을 벗어났습니다", height));
        }

        int ans = 0;

        for (int arr : array) {
            if (arr < 1 || arr > 200) {
                throw new Exception(String.format("[%d]는 1~200을 벗어났습니다", arr));
            }

            if (arr > height) {
                ans++;
            }
        }
        return ans;
    }

    //중앙값 구하기
    public int mathTest120811(int[] array) throws Exception {
        if (array.length < 0 || array.length > 100) {
            throw new Exception(String.format("[%d]는 1~100을 벗어났습니다.", array.length));
        }
        if (array.length % 2 == 0) {
            throw new Exception("배열의 길이는 홀수여야 합니다");
        }
        for (int arr : array) {
            if (arr < -1000 || arr > 1000) {
                throw new Exception("배열의 원소값은 -1000~1000");
            }
        }
        Arrays.sort(array);

        return array[array.length / 2];

    }

    //짝수는 싫어요
    public int[] mathTest120813(int n) throws Exception {
        int length = 0;

        if (n % 2 == 0) {
            length = n / 2;
        } else
            length = n / 2 + 1;

        int[] result = new int[length];

        int num = 1;

        for (int i = 0; i < result.length; i++) {
            result[i] = num;
            num += 2;
        }

        return result;

    }

    //피자 나눠 먹기
    public int mathTest120814(int n) throws Exception {
        if (n < 1 || n > 100) {
            throw new Exception("n은 1~100");
        }
        int ans = (n % 7 == 0) ? n / 7 : n / 7 + 1;


        return ans;

    }

    //옷가게 할인 받기
    public int mathTest120818(int price) throws Exception {
        if (price < 10 || price > 1000000) {
            throw new Exception(String.format("[%d]는 10~1,000,000 을 벗어남", price));
        }
        if (!(price % 10 == 0)) {
            throw new Exception("price는 10원 단위여야 합니다.");
        }

        if (price >= 500000) {
            price *= 0.8;
        } else if (price >= 300000) {
            price *= 0.9;
        } else if (price >= 100000) {
            price *= 0.95;
        }

        return (int) price;

    }

    //가위 바위 보
    public String mathTest120839(String rsp) throws Exception {
        if (rsp == null) {
            throw new Exception("rsp에 값이 입력되지 않았습니다");
        }
        if (rsp.length() < 0 || rsp.length() > 100) {
            throw new Exception("rsp의 길이 : 1~100");
        }

        String ans = "";

        String[] arr = rsp.split("");

        for (int i = 0; i < arr.length; i++) {
            if (!(arr[i].equals("0") || arr[i].equals("2") || arr[i].equals("5"))) {
                throw new Exception("rsp는 숫자 0,2,5로 이루어져 있습니다");
            }
            if (arr[i].equals("2")) {
                ans += "0";
            } else if (arr[i].equals("0")) {
                ans += "5";
            } else
                ans += "2";
        }
        return ans;
    }

    //개미 군단
    public int mathTest120837(int hp) throws Exception {
        if (hp < 1 || hp > 1000) {
            throw new Exception("hp는 1~1000의 값만 가능합니다");
        }

        int jang, byung, il;  //앞에서부터 장군개미, 병정개미, 일개미의 수

        jang = hp / 5;
        byung = 0;
        il = 0;

        if (hp % 5 >= 3) {
            byung = (hp % 5) / 3;
            il = (hp % 5) % 3;
        } else {
            il = hp % 5;
        }

        int ans = jang + byung + il;

        return ans;

    }

    //암호 해독
    public String mathTest120892(String cipher, int code) throws Exception {
        String ans = "";
        if (cipher.isEmpty() || cipher.length() > 1000) {
            throw new Exception("cipher의 길이 : 1 ~ 1000");
        }
        if (code < 1 || code > cipher.length()) {
            throw new Exception("code의 값 : 1 ~ cipher 길이");
        }
        for (int i = 0; i < cipher.length(); i++) {
            char ch = cipher.charAt(i);
            if (Character.isUpperCase(ch)) {
                throw new Exception("cipher는 소문자와 공백으로만 구성되어있습니다.");
            }
        }

        for (int i = code; i <= cipher.length(); i += code) {
            ans += cipher.substring(i - 1, i);
        }
        return ans;
    }

    //짝수 홀수 개수
    public int[] mathTest120824(int[] num_list) throws Exception {
        if (num_list.length < 1 || num_list.length > 100) {
            throw new Exception("num_list의 길이 : 1~100");
        }

        int odd = 0, even = 0;


        for (int n : num_list) {
            if (n < 0 || n > 1000) {
                throw new Exception("num_list의 원소값 : 0~1000");
            }
            if (n % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        int[] ans = new int[2];
        ans[0] = even;
        ans[1] = odd;

        return ans;
    }

    //배열 회전시키기
    /*
    public int[] mathTest120844(int[] numbers, String direction) throws Exception {
        int[] ans = new int[numbers.length];

        if (numbers.length < 3 || numbers.length > 20) {
            throw new Exception("numbers의 길이 : 3~20");
        }
        if(!(direction.equals("left") || direction.equals("right"))){
            throw new Exception("direction은 left or right 이어야 합니다.");
        }
        if(direction.equals("left")){
            for (int i=0; i<ans.length; i++){

            }
        }

    }
    */

    //가장 큰 수 찾기
    public int[] mathTest120899(int[] array) throws Exception{
        if(array.length<1 || array.length>100){
            throw new Exception(String.format("[%d]의 길이는 1 ~ 100 입니다.",array.length));
        }
        int[] result=new int[2];
        int max=array[0];
        int index=0;
        for(int i=0; i<array.length; i++){
            if (array[i] < 0 || array[i] > 1000) {
                throw new Exception(String.format("[%d]의 값은 0 ~ 1000 입니다.",array[i]));
            }

            if(array[i]>max){
                max=array[i];
                index=i;
            }

        }
        result[0]=max;
        result[1]=index;

        return result;

    }
    //로또 번호 추출
    public static int[] lotto(){
        int[] lottonum=new int[6];

        for(int i=0; i<lottonum.length; i++){
            lottonum[i]=(int)(Math.random()*45)+1;
            for(int j=0; j<i; j++){
                if(lottonum[i]==lottonum[j]){
                    i--;
                    break;
                }
            }
        }
        int temp=0;
        for(int i=0; i<lottonum.length; i++){
            for(int j=0; j<i; j++){
                if(lottonum[i]<lottonum[j]){
                    temp=lottonum[i];
                    lottonum[i]=lottonum[j];
                    lottonum[j]=temp;
                }
            }
        }
        return lottonum;
    }
    //최댓값 만들기(2)
    public int mathTest120862(int[] numbers) throws Exception{
        if(numbers.length<2 || numbers.length>100){
            throw new Exception("numbers의 길이 : 2 ~ 100");
        }
        for (int n : numbers) {
            if (n < -10000 || n > 10000) {
                throw new Exception("number의 값 : -10000 ~ 10000");
            }
        }

        int ans=0;
        int max=numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]>0){
                if (numbers[i] > max) {
                    max=numbers[i];
                }
                Arrays.sort(numbers);
                ans=max*numbers[numbers.length-1];
            } else{
                if (numbers[i] < max) {
                    max=numbers[i];
                }
                Arrays.sort(numbers);
                ans=max*numbers[1];
            }

        }


        return ans;
    }


}


