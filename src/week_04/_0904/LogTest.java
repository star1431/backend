package week_04._0904;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalTime;
import java.util.Scanner;

public class LogTest {
    static final String PATH = "src/etc/log/";

    /** 로그파일 생성 */
    public static void createLog(String type, int count, int cycle, int delay) {
        String baseName = (type.equals("error")) ? "errorLog" : "accessLog";

        for (int i = 0; i < count; i++) {
            String filePath = PATH + baseName + i + ".txt";
            File file = new File(filePath);

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

            System.out.println(filePath + "생성완료");
        }
        System.out.println("─".repeat(3) + " 생성종료 " + "─".repeat(3));
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

    public static void main(String[] args) {
        int count;  // 파일 생성갯수
        int cycle;  // 기록 횟수
        int delay;  // 기록 딜레이

        Scanner sc = new Scanner(System.in);

        System.out.println("성공파일생성 " + "─".repeat(5));
        System.out.print("생성갯수: ");
        count = Integer.parseInt(sc.nextLine());
        System.out.print("기록횟수: ");
        cycle = Integer.parseInt(sc.nextLine());
        System.out.print("딜레이(ms): ");
        delay = Integer.parseInt(sc.nextLine());

        // 액세스로그
        createLog("access", count, cycle, delay);
        readLog("access", count);

        System.out.println("에러파일생성 " + "─".repeat(5));
        System.out.print("생성갯수: ");
        count = Integer.parseInt(sc.nextLine());
        System.out.print("기록횟수: ");
        cycle = Integer.parseInt(sc.nextLine());
        System.out.print("딜레이(ms): ");
        delay = Integer.parseInt(sc.nextLine());

        // 에러로그
        createLog("error", count, cycle, delay);
        readLog("error", count);

        sc.close();
    }
}
