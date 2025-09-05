package week_04._0904;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogTest {
    static final String PATH = "src/etc/log/";

    /** 로그파일 생성 */
    public static void createLog(String type, int count, int cycle, int delay) {
        String baseName = (type.equals("error")) ? "errorLog" : "accessLog";

        for (int i = 0; i < count; i++) {
            String filePath = PATH + baseName + i + ".txt";
            File file = new File(filePath);

            System.out.print("생성중...");
            try (
                PrintWriter writer = new PrintWriter(new FileWriter(file))
            ) {
                for (int j = 0; j < cycle; j++) {
                    LocalTime now = LocalTime.now();
                    writer.println("[" + type + "]" + now);

                    // 넣고 딜레이
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(" → " + filePath + " 생성완료");
        }
        System.out.println("─".repeat(5) + " 생성종료 " + "─".repeat(5));
    }

    /** 파일읽기 */
    public static void readLog(String type, int count) {
        String baseName = (type.equals("error")) ? "errorLog" : "accessLog";

        for (int i = 0; i < count; i++) {
            String filePath = PATH + baseName + i + ".txt";
            System.out.println(baseName + i + ".txt 정보");
            try (
                BufferedReader reader = new BufferedReader(new FileReader(filePath))
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }  catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("─".repeat(10));
        }
    }
    

    /** 병합 */
    public static void mergeLog(String type) {
        String baseName = (type.equals("error")) ? "errorLog" : "accessLog";
        List<String> typeFiles = new ArrayList<>();
        LocalDate today = LocalDate.now();
        
        // 병합파일명 : baseName_MMDD.txt
        String mergeFile = PATH + baseName + "_" 
            + String.format("%02d", today.getMonthValue()) 
            + String.format("%02d", today.getDayOfMonth()) + ".txt";
        
        try {
            File dir = new File(PATH);
            String[] allfiles = dir.list(); // 디렉토리 모든 파일

            // 해당 타입 파일만 add
            for (String item : allfiles) {
                if (item.startsWith(baseName)) {
                    typeFiles.add(item);
                }
            }

            if(typeFiles.size() == 0) {
                System.out.println("병합할 파일이 없습니다.");
                return;
            }

            System.out.println(baseName + " 파일 병합중...");

            try ( PrintWriter writer = new PrintWriter(new FileWriter(mergeFile)) ) {
                // 해당타입 병합
                for (String item : typeFiles) {
                    String files = PATH + item;
                    try ( BufferedReader reader = new BufferedReader(new FileReader(files)) ) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            writer.println(line);
                        }
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(mergeFile + " 병합완료!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int count;  // 파일 생성갯수
        int cycle;  // 기록 횟수
        int delay;  // 기록 딜레이

        Scanner sc = new Scanner(System.in);

        System.out.println("─".repeat(5) + " 성공파일생성 " + "─".repeat(5));
        System.out.print("생성갯수: ");
        count = Integer.parseInt(sc.nextLine());
        System.out.print("기록횟수: ");
        cycle = Integer.parseInt(sc.nextLine());
        System.out.print("딜레이(ms): ");
        delay = Integer.parseInt(sc.nextLine());

        // 액세스로그
        createLog("access", count, cycle, delay);
        // readLog("access", count);
        mergeLog("access");

        System.out.println("─".repeat(5) + " 에러파일생성 " + "─".repeat(5));
        System.out.print("생성갯수: ");
        count = Integer.parseInt(sc.nextLine());
        System.out.print("기록횟수: ");
        cycle = Integer.parseInt(sc.nextLine());
        System.out.print("딜레이(ms): ");
        delay = Integer.parseInt(sc.nextLine());

        // 에러로그
        createLog("error", count, cycle, delay);
        // readLog("error", count);
        mergeLog("error");

        sc.close();
    }
}
