package mini_project;

import mini_project.controller.MoiveController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * ConsoleUI (출력/입력 전담)
 * @author 정병천
 * @since 2025-09-17
 */
public class ConsoleUI {
    private final Scanner sc = new Scanner(System.in);
    private final MoiveController ctrl = new MoiveController();

    /* 공통출력 - 타이틀 */
    public void printTitle(String title) {
        System.out.println("\n" + "─".repeat(10) + "[ " + title + " ]" + "─".repeat(10));
    }

    /* 공통출력 - 에러메세지 */
    public void printError(String key) {
        switch (key) {
            case "입력" -> System.out.println("❌ 잘못된 입력입니다.");
            case "코드" -> System.out.println("❌ 코드 형식이 올바르지 않습니다.");
            case "예매" -> System.out.println("❌ 이미 예매된 자리 입니다.");
            case "없음" -> System.out.println("❌ 없는 좌석번호 입니다.");
            case "예매없음" -> System.out.println("❌ 예매된 영화가 없습니다.");
            case "정보없음" -> System.out.println("❌ 해당 정보가 없습니다.");
            default -> System.out.println("❌ 오류");
        }
    }

    /* 공통출력 - 성공 */
    public void printSuccess(String msg) {
        System.out.println("✅ " + msg + " 완료"); 
    }
    public void printSuccess(String msg, String code) {
        System.out.println("✅ " + msg + " 완료: " + code);
    }

    /* 공통유틸 - 이전이동 */
    public boolean askBack(String kind) {
        while (true) {
            switch (kind) {
                case "이전"   -> System.out.print("이전으로? (y/n): ");
                case "처음"   -> System.out.print("처음으로? (y/n): ");
                case "재입력" -> System.out.print("재입력? (y/n): ");
                case "삭제"   -> System.out.print("삭제? (y/n): ");
                default -> System.out.print("(y/n): ");
            }
            String val = sc.nextLine().trim().toLowerCase();
            if (val.equals("y")) return true;
            if (val.equals("n")) return false;
            printError("입력");
        }
    }

    /* 좌석판 출력 (컨트롤러 seatGrid) */
    private void printSeatGrid(Map<String, String[]> grid) {
        System.out.println("┌───────────────────────────────────────┐");
        System.out.println("│                Screen                 │");
        System.out.println("└───────────────────────────────────────┘");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        for (Map.Entry<String, String[]> e : grid.entrySet()) {
            System.out.print(e.getKey() + "열 |  ");
            for (String cell : e.getValue()) System.out.print("[" + cell + "] ");
            System.out.println();
        }
    }

    /* 영화-좌석 보드 출력 */
    private void printMovieBoard() {
        List<Map<String, Object>> rows = ctrl.movieBoardData();
        System.out.println("영화 목록 |  (등록된 영화 수: " + rows.size() + ")");
        int i = 1;
        for (Map<String, Object> r : rows) {
            System.out.printf("[%02d] : 제목: %s | 장르: %s | 등급: %s | 가격: %,d원 | 전체좌석: %d | 남은좌석: %d%n",
                    i++,
                    r.get("title"),
                    r.get("genre"),
                    r.get("type"),
                    (int) r.get("price"),
                    (int) r.get("total"),
                    (int) r.get("left")
            );
        }
    }

    /* 영화-좌석 보드 출력 */
    private boolean printReservedBoard() {
        List<Map<String, Object>> rows = ctrl.reservedBoardData();
        if (rows.isEmpty()) {
            printError("예매없음");
            return false;
        }
        System.out.println("예매된 영화 목록");
        int i = 1;
        for (Map<String, Object> r : rows) {
            System.out.printf("[%02d] : 제목: %s | 장르: %s | 등급: %s | 가격: %,d원 | 전체좌석: %d | 남은좌석: %d%n",
                    i++,
                    r.get("title"),
                    r.get("genre"),
                    r.get("type"),
                    (int) r.get("price"),
                    (int) r.get("total"),
                    (int) r.get("left")
            );
        }
        return true;
    }

    /* 영화-좌석 단건 출력 */
    private void printMovieInfo(int id) {
        Map<String, Object> info = ctrl.movieInfoData(id);
        if (info == null || info.isEmpty()) {
            printError("정보없음");
            return;
        }
        System.out.printf("제목: %s | 장르: %s | 등급: %s | 가격: %,d원 | 전체좌석: %d | 남은좌석: %d%n",
                info.get("title"), info.get("genre"), info.get("type"),
                (int) info.get("price"), (int) info.get("total"), (int) info.get("left"));
    }

    /* 메뉴 */
    public void consoleMenu() {
        printTitle("영화 관리자 시스템");
        System.out.println("1. 예매 등록            2. 예매 취소");
        System.out.println("3. 영화 추가            4. 영화 삭제");
        System.out.println("5. 영화 목록            6. 종료");
        System.out.print("\n메뉴를 선택하세요: ");
    }

    /* 플로우 */
    // 1) 예매 등록
    public void reserveFlow() {
        printTitle("예매 등록 : 영화 선택");
        printMovieBoard();

        int id;
        while (true) {
            System.out.print("\n예매할 영화 번호 입력해주세요 (ex: 1 or 01)\n입력: ");
            String input = sc.nextLine().trim();
            try {
                id = ctrl.selectMovie("read", input);
            } catch (Exception e) {
                id = -1;
            }
            if (id == -1) printError("입력");
            else break;
        }
        printSuccess("선택");

        printTitle("예매 등록 : 좌석 예매");
        printMovieInfo(id);
        printSeatGrid(ctrl.seatGrid(id));

        while (true) {
            System.out.print("\n예매할 좌석 번호 입력해주세요 (예: A1, E6)\n입력: ");
            String code = sc.nextLine().trim().toUpperCase();
            if (!ctrl.codeCheck(id, code)) {
                printError("코드");
                continue;
            }
            boolean ok = ctrl.reserve(id, code);
            if (ok) {
                printSuccess("예매", code);
                break;
            } else {
                printError("예매");
            }
        }
    }

    // 2) 예매 취소
    public void cancelFlow() {
        printTitle("예매 취소 : 영화 선택");
        if (!printReservedBoard()) return;

        int id;
        while (true) {
            System.out.print("\n예매 취소할 영화 번호 입력해주세요 (ex: 1 or 01)\n입력: ");
            String input = sc.nextLine().trim().toUpperCase();
            try {
                id = ctrl.selectMovie("cancel", input);
            } catch (Exception e) {
                id = -1;
            }
            if (id == -1) printError("입력");
            else break;
        }
        printSuccess("선택");

        printTitle("예매 취소 : 좌석 취소");
        printMovieInfo(id);
        // printSeatGrid(ctrl.seatGrid(id));
        System.out.println(ctrl.reservedCodes(id));


        while (true) {
            System.out.print("\n예매 취소할 좌석 번호 입력해주세요 (예: A1, E6)\n입력: ");
            String code = sc.nextLine().trim().toUpperCase();
            if (!ctrl.codeCheck(id, code)) {
                printError("코드");
                continue;
            }
            boolean ok = ctrl.cancel(id, code);
            if (ok) {
                printSuccess("취소", code);
                break;
            } else {
                printError("없음");
            }
        }
    }

    // 3) 영화 추가
    public void addFlow() {
        printTitle("영화 등록 : 입력");
        String title, ageCode, genre;
        int price, rows, cols;

        while (true) {
            while (true) {
                System.out.print("제목입력: ");
                title = sc.nextLine().trim();
                if (title.isBlank()) printError("입력");
                else break;
            }
            while (true) {
                Map<String, String> opts = ctrl.ageOptions();
                int i = 1;
                for (Map.Entry<String, String> e : opts.entrySet()) {
                    String label = e.getValue();
                    System.out.printf("[%d] %s, ", i++, label);
                }
                List<String> codes = new ArrayList<>(opts.keySet());

                System.out.print("\n관람등급 번호 입력: ");
                String ageInput = sc.nextLine().trim().toUpperCase();
                int typeNum;
                try {
                    typeNum = Integer.parseInt(ageInput);
                    if (typeNum < 1 || typeNum > opts.size()) {
                        printError("입력");
                    } else {
                        ageCode = codes.get(typeNum - 1);
                        break;
                    }
                } catch (NumberFormatException e) {
                    printError("입력");
                }
            }
            while (true) {
                System.out.print("장르입력: ");
                genre = sc.nextLine().trim();
                if (genre.isBlank()) printError("입력"); else break;
            }
            while (true) {
                System.out.print("가격입력: ");
                try { price = Integer.parseInt(sc.nextLine().trim()); break; }
                catch (NumberFormatException e) { printError("입력"); }
            }
            while (true) {
                try {
                    System.out.print("좌석 행(rows, 1~9): ");
                    rows = Integer.parseInt(sc.nextLine().trim());
                    if (rows <= 0 || rows >= 10) {
                        throw new NumberFormatException();
                    }
                    System.out.print("좌석 열(cols, 1~9): ");
                    cols = Integer.parseInt(sc.nextLine().trim());
                    if (cols <= 0 || cols >= 10) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    printError("입력");
                }
            }

            System.out.printf("입력된 값: [ 제목:%s, 등급:%s, 장르:%s, 가격: %,d원, 좌석: %dx%d ]%n",
                    title, ctrl.ageLabel(ageCode), genre, price, rows, cols
            );

            if (!askBack("재입력")) break;
        }

        boolean ok = ctrl.add(title, ageCode, genre, price, rows, cols);
        if (ok) printSuccess("등록");
        else printError("실패");
    }

    // 4) 영화 삭제
    public void removeFlow() {
        printTitle("영화 삭제 : 영화 선택");
        printMovieBoard();

        int id;
        while (true) {
            System.out.print("\n삭제할 영화 번호 입력해주세요 (ex: 1 or 01)\n입력: ");
            String input = sc.nextLine().trim();
            try {
                id = ctrl.selectMovie("read", input);
            } catch (Exception e) {
                id = -1;
            }
            if (id == -1) {
                printError("입력");
            } else {
                System.out.println("선택한 영화");
                printMovieInfo(id);
                if (askBack("삭제")) break;
            }
        }

        boolean ok = ctrl.remove(id);
        if (ok) printSuccess("삭제"); 
        else printError("실패");
    }

    // 5) 영화 목록
    public void listFlow() {
        while (true) {
            printTitle("영화 목록");
            printMovieBoard();

            int id;
            while (true) {
                System.out.print("\n좌석표를 확인할 영화 번호 입력해주세요 (ex: 1 or 01)\n입력: ");
                String input = sc.nextLine().trim();
                try {
                    id = ctrl.selectMovie("read", input); // ← MoiveController: "read"
                } catch (Exception e) {
                    id = -1;
                }
                if (id == -1) printError("입력");
                else break;
            }

            printTitle("영화 목록 - 좌석표");
            printMovieInfo(id);
            printSeatGrid(ctrl.seatGrid(id));

            if (!askBack("이전")) break;
        }
    }

    // 종료
    public void endFlow() {
        printTitle("시스템을 종료 합니다.");
    }
}
