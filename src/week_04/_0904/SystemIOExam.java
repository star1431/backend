package week_04._0904;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SystemIOExam {
    public static void main(String[] args) {
        String fileSrc = "src/etc/io_test/";
        try (
                // System.in을 BufferedReader로 감싸기
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            // System.out으로 프롬프트 출력
            System.out.print("이름을 입력하세요: ");
            String name = br.readLine();

            System.out.print("나이를 입력하세요: ");
            int age = Integer.parseInt(br.readLine());

            // 오류 출력
            if (age < 0) {
                System.err.println("오류: 나이는 음수일 수 없습니다. 입력값: " + age);
            } else {
                // 정상 출력
                String printStr1 = "안녕하세요, " + name + "님!";
                String printStr2 = "당신은 " + age + "살입니다.";
                
                // 해당값 쓰기
                try(
                    FileWriter fw = new FileWriter((fileSrc + "info_test.txt"));
                    // PrintWriter pw = new PrintWriter(fw);
                ) {
                    System.out.println(printStr1 + "\n" + printStr2);
                    fw.write(printStr1 + "\n" + printStr2);
                    // or
                    // pw.println(printStr1);
                    // pw.println(printStr2);
                }
            }
        } catch (IOException e) {
            System.err.println("입력 오류: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("숫자 형식 오류: " + e.getMessage());
        }
    }
}
