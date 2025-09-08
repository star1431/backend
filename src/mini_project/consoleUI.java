package mini_project;
import mini_project.service.MovieService;
import mini_project.io.DataFile;
import mini_project.enums.AgeRating;
import java.util.Scanner;

public class consoleUI {
    static Scanner sc = new Scanner(System.in);
    static MovieService service = new MovieService();

    public consoleUI() {
        initMovie();
    }

    // 영화 기본 값 셋팅
    public void initMovie() {
        service.dataLoad();
    }

    // 돌아가기
    public boolean askBack(String str) {
        while (true) {
            switch (str) {
                case "이전":
                    System.out.print("이전으로? (y/n): ");
                    break;
                case "처음":
                    System.out.print("처음으로? (y/n): ");
                    break;
                case "재입력":
                    System.out.print("재입력? (y/n): ");
                    break;
                case "삭제":
                    System.out.print("삭제? (y/n): ");
                    break;
                default:
                    break;
            }
            String val = sc.nextLine();
            String check = val.trim().toLowerCase();
            if (check.equals("y")) return true;
            if (check.equals("n")) return false;
            System.out.println("❌ 잘못된 입력입니다.");
        }
    }
    
    // 프린트 타이틀
    public void printTitle(String title) {
        System.out.println("\n" + "─".repeat(10) + "[ " + title + " ]" + "─".repeat(10));
    }
    
    // 프린트 에러 메세지
    public void printError(String str) {
        switch (str) {
            case "입력":
                System.out.println("❌ 잘못된 입력입니다.");
                break;
            case "코드":
                System.out.println("❌ 코드 형식이 올바르지 않습니다.");
                break;
            case "예매":
                System.out.println("❌ 이미 예매된 자리 입니다.");
                break;
            case "없음":
                System.out.println("❌ 없는 좌석번호 입니다.");
                break;
            default:
                break;
        }
    }
    
    // 프린트 통과 메세지
    public void printSuccess(String str) {
        System.out.println("✅ " + str + " 완료");
    }
    public void printSuccess(String str, String code) {
        System.out.println("✅ " + str + " 완료: " + code);
    }

    // 메뉴
    public void consoleMenu() {
        printTitle("영화 관리자 시스템");
        System.out.println("1. 예매 등록            2. 예매 취소");
        System.out.println("3. 영화 추가            4. 영화 삭제");
        System.out.println("5. 영화 목록            6. 종료 (저장)");
        System.out.print("\n메뉴를 선택하세요: ");
    }

    // 예매 등록
    public void reserveFlow() {
        printTitle("예매 등록 : 영화 선택");
        String id;
        service.MovieBoard();

        // 영화 번호 입력 check
        System.out.println();
        while (true) {
            System.out.print("예매할 영화 번호 입력해주세요 (ex: 1 or 01)\n입력: ");
            String input1 = sc.nextLine();
            id = service.selectMovie("예매등록", input1);
            if(id == null) printError("입력");
            else break;
        }
        printSuccess("선택");

        // 영화 정보 및 영화 좌석 노출
        printTitle("예매 등록 : 좌석 예매");
        service.movieInfo(id);
        service.movieSeatBoard(id);

        // 좌석 예매
        System.out.println();
        while (true) {
            System.out.print("예매할 좌석 번호 입력해주세요 (ex: A1 or E6)\n입력: ");
            String input2 = sc.nextLine();
            if(!input2.matches("^[A-E][1-6]$")) {
                printError("코드");
            } else {
                boolean reserveCheck = service.reserveSeat(id, input2);
                if(reserveCheck) {
                    printSuccess("예매", input2);
                    break;
                } else {
                    printError("예매");
                }
            }
        }
    }

    // 예매 취소
    public void cancelFlow() {
        printTitle("예매 취소 : 영화 선택");
        String id;
        boolean _test = service.reservedMovieBoard();
        if(!_test) return;
        System.out.println();

        // 영화 번호 입력 check
        while (true) {
            System.out.print("예매 취소할 영화 번호 입력해주세요 (ex: 1 or 01)\n입력: ");
            String input1 = sc.nextLine();
            id = service.selectMovie("예매취소", input1);
            if(id == null) printError("입력");
            else break;
        }
        printSuccess("선택");

        // 영화 정보 및 영화 예매 번호 노출
        printTitle("예매 취소 : 좌석 취소");
        service.movieInfo(id);
        service.reservedSeatBoard(id);

        // 좌석 취소
        System.out.println();
        while (true) {
            System.out.print("예매 취소할 좌석 번호 입력해주세요 (ex: A1 or E6)\n입력: ");
            String input2 = sc.nextLine();
            if(!input2.matches("^[A-E][1-6]$")) {
                printError("코드");
            } else {
                boolean cancelCheck = service.cancelSeat(id, input2);
                if(cancelCheck) {
                    printSuccess("취소", input2);
                    break;
                } else {
                    printError("없음");
                }
            }
        }
    }

    // 영화 등록
    public void addFlow() {
        printTitle("영화 등록 : 입력");
        String title, type, genre, priceStr;
        int price;

        boolean fieldRunning = true;
        while (fieldRunning) {
            while (true) {
                System.out.print("제목입력: ");
                title = sc.nextLine();
                if (title.isBlank()) printError("입력");
                else break;
            }

            int[] codeArr = AgeRating.getCodeArray();
            String[] labelArr = AgeRating.getLabelArray();
            while (true) {
                System.out.println("관람등급 선택");
                for (int i = 0; i < codeArr.length; i++) {
                    System.out.print("[" + codeArr[i] + "]: " + labelArr[i]);
                    if (i < codeArr.length - 1) System.out.print(", ");
                }
                System.out.print("\n번호입력: ");
                type = sc.nextLine();
                int typeNum;
                try {
                    typeNum = Integer.parseInt(type);
                    if (typeNum <= 0 || typeNum > codeArr.length) {
                        printError("입력");
                    } else {
                        type = AgeRating.findLabel(type);
                        break;
                    }
                } catch (NumberFormatException e) {
                    printError("입력");
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                System.out.print("장르입력: ");
                genre = sc.nextLine();
                if (genre.isBlank()) printError("입력");
                else break;
            }

            while (true) {
                System.out.print("가격입력: ");
                priceStr = sc.nextLine();
                try {
                    price = Integer.parseInt(priceStr);
                    break;
                } catch (NumberFormatException e) {
                    printError("입력");
                    System.out.println(e.getMessage());
                }
            }

            System.out.printf("입력된 값: [ 제목:%s, 등급:%s, 장르:%s, 가격: %,d원 ]\n", title, type, genre, price );
            if(!askBack("재입력")) {
                service.addMovie(title, type, genre, price);
                fieldRunning = false;
            }
        }

        printSuccess("등록");
    }

    // 영화 삭제
    public void removeFlow() {
        printTitle("영화 삭제 : 영화 선택");
        String id;
        service.MovieBoard();

        // 영화 번호 입력 check
        System.out.println();
        while (true) {
            System.out.print("삭제할 영화 번호 입력해주세요 (ex: 1 or 01)\n입력: ");
            String input1 = sc.nextLine();
            id = service.selectMovie("읽기전용", input1);
            if(id == null) {
                printError("입력");
            }
            else {
                System.out.println("선택한 영화");
                service.movieInfo(id);
                if(askBack("삭제")) {
                    service.removeMovie(id);
                    break;
                }
            }
        }

        printSuccess("삭제");
    }

    // 영화 목록
    public void listFlow() {
        while (true) {
            printTitle("영화 목록");
            String id;
            service.MovieBoard();

            // 영화 번호 입력 check
            System.out.println();
            while (true) {
                System.out.print("좌석표를 확인할 영화 번호 입력해주세요 (ex: 1 or 01)\n입력: ");
                String input1 = sc.nextLine();
                id = service.selectMovie("읽기전용", input1);
                if(id == null) printError("입력");
                else break;
            }

            // 영화 정보 및 영화 좌석 노출
            printTitle("영화 목록 - 좌석표");
            service.movieInfo(id);
            service.movieSeatBoard(id);
            if(!askBack("이전")) break;
        }
    }

    // 종료
    public void endFlow() {
        System.out.println("저장중...");
        service.dataSave();  // 실제 저장 실행
        System.out.println("데이터 저장 완료");
        printTitle("시스템을 종료 합니다.");
    }

}
