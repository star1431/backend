package week_02._0822;
import week_02._0822.common.Dice;

public class DiceExam {
    public static void main(String[] args) {
        Dice dice = new Dice();

        dice.roll();
        System.out.println("주사위 실행 : " + dice.getEye());

        dice.setEye(0); // 우선 초기화.

        int cnt = 10, choice = 5, total = 0;
        for (int i = 0; i < cnt; i++) {
            dice.roll();
            if(dice.getEye() == choice) total++;
        }

        System.out.printf("주사위 %d번 굴려서 %d 나온 횟수 : %d%n", cnt, choice, total);
    }
}
