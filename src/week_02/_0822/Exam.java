package week_02._0822;

import static java.lang.Math.random;

public class Exam {

    public static void main(String[] args) {
        System.out.println("TITLE : 0822 자바 기초");
        Exam obj = new Exam();
        obj.exam00(); //
    }

    public void exam00() {
        System.out.println("exam00 : ");
        int ranNum = (int)(random()*10) + 1;
        System.out.println(ranNum);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }


}
