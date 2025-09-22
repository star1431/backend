package mini_project;

import java.util.Scanner;

public class MovieMain {
    static Scanner sc = new Scanner(System.in);
    static ConsoleUI consoleUI = new ConsoleUI();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            consoleUI.consoleMenu();
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        // 예매 등록
                        consoleUI.reserveFlow();
                        break;
                    case 2:
                        // 예매 취소
                        consoleUI.cancelFlow();
                        break;
                    case 3:
                        // 영화 추가
                        consoleUI.addFlow();
                        break;
                    case 4:
                        // 영화 삭제
                        consoleUI.removeFlow();
                        break;
                    case 5:
                        // 영화 목록
                        consoleUI.listFlow();
                        break;
                    case 6:
                        // 종료
                        consoleUI.endFlow();
                        running = false;
                        sc.close();
                        break;
                    default:
                        consoleUI.printError("입력");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ [" + e.getMessage() + "] 숫자가 아닙니다");
            }
        }
    }

}