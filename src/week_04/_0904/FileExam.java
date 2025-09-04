package week_04._0904;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileExam {
    static InputStreamReader isr = new InputStreamReader(System.in);

    public static void main(String[] args) {
        String src = "src/etc/file_exam/";
        String fileName = "sample.txt";
        String path = src + fileName;

        File dir = new File(src);
        File file = new File(path);


        try (BufferedReader br = new BufferedReader(isr)) {
            
            System.out.print("이름입력: ");
            String name = br.readLine();

            System.out.print("전화번호입력: ");
            String tel = br.readLine();

            System.out.print("주소입력: ");
            String addr = br.readLine();

            dir.mkdirs();
            file.createNewFile();

            // 해당값 쓰기
            try(PrintWriter wirter = new PrintWriter(new FileWriter(path))) {
                wirter.println("이름: " + name);
                wirter.println("전화: " + tel);
                wirter.println("주소: " + addr);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try (BufferedReader read = new BufferedReader(new FileReader(path))) {
                String line; // 한 줄 버퍼
                while ((line = read.readLine()) != null) { // ← null 비교가 정답!
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
