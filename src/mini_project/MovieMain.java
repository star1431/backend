package mini_project;
import java.util.Scanner;
//import mini_project.service.MovieService;
//import mini_project.consoleUI;

public class MovieMain {
    static Scanner sc = new Scanner(System.in);
    static consoleUI movieUI = new consoleUI();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            movieUI.consoleMenu();
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        // 예매 등록
                        movieUI.reserveFlow();
                        break;
                    case 2:
                        // 예매 취소
                        movieUI.cancelFlow();
                        break;
                    case 3:
                        // 영화 추가
                        movieUI.addFlow();
                        break;
                    case 4:
                        // 영화 삭제
                        movieUI.removeFlow();
                        break;
                    case 5:
                        // 영화 목록
                        movieUI.listFlow();
                        break;
                    case 6:
                        // 종료
                        movieUI.endFlow();
                        running = false;
                        sc.close();
                        break;
                    default:
                        movieUI.printError("입력");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ [" + e.getMessage() + "] 숫자가 아닙니다");
            }
        }
    }

}