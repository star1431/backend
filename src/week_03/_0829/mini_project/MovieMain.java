package week_03._0829.mini_project;

import week_03._0829.mini_project.consoleUI;

import java.util.Scanner;

public class MovieMain {
    static Scanner sc = new Scanner(System.in);
    static consoleUI movieUI = new consoleUI();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            movieUI.printTitle("영화 관리 시스템");
            System.out.println("1. 예매 등록            2. 예매 취소");
            System.out.println("3. 영화 추가            4. 영화 삭제");
            System.out.println("5. 영화 목록            6. 종료 ");
            System.out.print("\n메뉴를 선택하세요: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    // 예매 등록
                    movieUI.reserveFlow();
                    break;
                case "2":
                    // 예매 취소
                    movieUI.cancelFlow();
                    break;
                case "3":
                    // 영화 추가
                    movieUI.addFlow();
                    break;
                case "4":
                    // 영화 삭제
                    movieUI.removeFlow();
                    break;
                case "5":
                    // 영화 목록
                    movieUI.listFlow();
                    break;
                case "6":
                    // 종료
                    movieUI.endFlow();
                    running = false;
                    sc.close();
                    break;
                default:
                    movieUI.printError("입력");
            }
        }
    }

}