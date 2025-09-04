package week_04._0904;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class FileExam2 {

    /** 입력 후 파일 및 List<UserInfo> 저장 */
    public static void infoInput(String path, List<UserInfo> lists, int cnt) {
        String name, tel, addr;
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(new FileWriter(path, true));
        ) {

            for (int i = 0; i < cnt; i++) {
                System.out.printf("[ 입력 | %d번쨰 중 %d번째 ]%n", cnt, (i + 1));

                System.out.print("이름: ");
                name = reader.readLine();

                System.out.print("전화번호: ");
                tel = reader.readLine();

                System.out.print("주소: ");
                addr = reader.readLine();

                writer.println(name + "," + tel + "," + addr);

                lists.add(new UserInfo(name, tel, addr));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    /** 파일 쓰기 */

    /** 파일 읽기 */
    public static void infoOutput(String path) {
        try (
            BufferedReader reader = new BufferedReader(new FileReader(path))
        ) {
            System.out.println("─".repeat(8) + "[ 파일 내용 ]" + "─".repeat(8));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /** 파일정보 List<UserInfo> 에 삽입 */
    public static void joinList(String path, List<UserInfo> lists) {
        File file = new File(path);
        if (!file.exists()) return;
        try (
                BufferedReader read = new BufferedReader(new FileReader(file))
        ) {
            String line;
            while ((line = read.readLine()) != null) {
                // 이름 | 전화 | 주소
                String[] join = line.split(",", 3);
                System.out.println(Arrays.toString(join));
                if (join.length == 3) lists.add(new UserInfo(join[0], join[1], join[2]));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        String path = "src/etc/file_exam/info.txt";
        Scanner sc = new Scanner(System.in);
        List<UserInfo> lists = new ArrayList<>();

        joinList(path, lists);
        System.out.println("수정전 배열정보:\n" + lists);
        System.out.println("─".repeat(20));

        int cnt;
        System.out.print("횟수입력: ");
        cnt = Integer.parseInt(sc.nextLine());

        System.out.println("─".repeat(20));
        infoInput(path, lists, cnt);
        infoOutput(path);

        System.out.println("─".repeat(20));
        System.out.println("수정 후 배열정보:\n" + lists);
    }
}