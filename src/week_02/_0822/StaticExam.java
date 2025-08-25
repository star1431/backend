package week_02._0822;

public class StaticExam {
    int insVal;
    static int stVal;

    public void insMethod01(){
        // 스태틱 아닌 메서드인 경우 둘다 접근 가능
        System.out.println(insVal);
        System.out.println(stVal);
    }

    public void insMethod02(){
        insMethod01();
        stMethod01();
        stMethod02();
    }
    public static void stMethod01(){
        // static 메서드 인 경우 static한 필드만 접근 가능!!
        // System.out.println(insVal);
        System.out.println(stVal);
    }
    public static void stMethod02(){
        stMethod01();
        // insMethod01();
    }


    public static void main(String[] args) {
        stVal = 100;
        System.out.println(stVal);
        stMethod01();

        // 인스턴스 필드, 메서드는 객체가 반드시 인스턴스화 된 후에 쓸수있다.
        // System.out.println(insVal);
        // insMethod01();
    }
}