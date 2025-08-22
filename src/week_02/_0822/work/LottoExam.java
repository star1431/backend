package week_02._0822.work;
import java.util.Arrays;
import java.util.Scanner;

class Lotto {
    private int[][] tickets;

    // 생성자
    public Lotto(int cnt) {
        tickets = new int[cnt][6];
        for (int i = 0; i < cnt; i++) {
            tickets[i] = lottoRandom();
        }
    }

    // 해당 인덱스 로또번호 얻기
    public int[] getTicket(int idx) {
        return tickets[idx];
    }

    // 로또 번호 생성기 (중복 없이 6개, 오름차순)
    private int[] lottoRandom() {
        int[] data = new int[6];

        // 중복 숫자 제거
        int idx = 0;
        while (idx < 6) {
            int num = (int)(Math.random() * 45) + 1;
            boolean duplicate = false;
            for (int j = 0; j < idx; j++) {
                // 중복이면 true
                if (data[j] == num) {
                    duplicate = true;
                    break;
                }
            }
            // 중복이 아니면 배열에 저장하고 다음 인덱스로 이동
            if (!duplicate) {
                data[idx] = num;
                idx++;
            }
        }

        // 오름차순
        Arrays.sort(data);
        return data;
    }

}

public class LottoExam {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int games;
        while (true) {
            System.out.print("구매할 게임 수를 입력하세요 (1 ~ 5) \n입력: ");
            games = sc.nextInt();
            if(games < 1 || games > 5) {
                System.out.println("입력값 : " + games + ", 1 ~ 5 사이의 숫자를 입력해주세요.");
            } else {
                break;
            }
        }

        sc.close();

        Lotto lotto = new Lotto(games); // Lotto 객체 생성

        System.out.println("====== 로또번호 " + games + " 게임 ======");
        for (int i = 0; i < games; i++) {
            System.out.println("로또 " + (i + 1) + " 게임 : [" + i + "] " + Arrays.toString(lotto.getTicket(i)));
        }
    }

}
