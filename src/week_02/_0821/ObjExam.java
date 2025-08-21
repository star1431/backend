package week_02._0821;
import java.util.Arrays;
import week_02._0821.common.Pen;
import week_02._0821.common.VendingMachine;
import week_02._0821.common.Calc;

public class ObjExam {

    public static void main(String[] args) {
        System.out.println("TITLE : 0821 불러오기");

        ObjExam obj = new ObjExam();

        obj.exam00(); // 펜
        obj.exam01(); // 벤딩머신
        obj.exam02(); // 칼크


    }

    public void exam00() {
        System.out.println("exam00 : 펜 호출");

        // 해당 클래스 그냥 호출
        new Pen();

        // 인스턴스 생성
        Pen ballPan = new Pen();

        // 해당 메서드 사용
        ballPan.write("안녕하세요!!");
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
    
    public void exam01() {
        System.out.println("exam01 : 벤딩머신 호출");
        // 인스턴스 생성
        VendingMachine vm1 = new VendingMachine();
        VendingMachine vm2 = new VendingMachine();

        // 메시지 전송(메소드 호출)
        String product = vm1.pushProductButton(1);
        System.out.println("선택한 상품: " + product);

        // 자판기를 5개 만들고 싶다면?
        VendingMachine[] machinArr = new VendingMachine[5];
        String[] prodArr = new String[5];
        for(int i = 0; i < 5; i++) {
            machinArr[i] = new VendingMachine();
            prodArr[i] = machinArr[i].pushProductButton(i);
        }
        
        System.out.println("machinArr: " + Arrays.toString(machinArr));
        System.out.println("prodArr: " + Arrays.toString(prodArr));

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    
    public void exam02() {
        System.out.println("exam02 : 칼크 호출");

        Calc calc = new Calc();

        int[] arr = {4, 5, 6};
        int sum0 = calc.addAll(arr);
        int sum1 = calc.addAll(1,2,3);
        double keyCalc = calc.optionKey((double)10, 3, "/");

        System.out.println("[4,5,6] calc.add(arr) : " + sum0);
        System.out.println("calc.add(1,2,3) : " + sum1);
        System.out.println("10 / 3 = " + keyCalc);

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

}
