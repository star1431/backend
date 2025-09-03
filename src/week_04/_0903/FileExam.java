package week_04._0903;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileExam {
    public static void main(String[] args) {
        String srcFile = "src/etc/IOTEST.md";

        System.out.println("[파일 읽기 - 원본]");
        System.out.println("─".repeat(10));

        // 파일 읽기
        try (FileReader fr = new FileReader(srcFile)) {
            int ch;
            // 파일에서 한 글자씩 읽어서 int 값으로 반환
            // 더 이상 읽을 문자가 없으면 -1 반환됨
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("오류: " + e.getMessage());
        }
        System.out.println();
        System.out.println("─".repeat(10));

        // 파일 쓰기 (apeend)
        try (FileWriter fw = new FileWriter(srcFile, true)) {
            fw.write("\n## java로 추가. 반갑습니다");
        } catch (IOException e) {
            System.out.println("오류: " + e.getMessage());
        }

        // 다시 읽기
        System.out.println("\n[파일 쓰고 읽기 - 수정 후]");
        System.out.println("─".repeat(10));
        try (FileReader fr = new FileReader(srcFile)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("오류: " + e.getMessage());
        }
        System.out.println();
        System.out.println("─".repeat(10));
    }
}