package week_04._0903;
import java.io.FileReader;
import java.io.IOException;

public class ExamCheckedThrows {
    // FileReader는 파일이 없으면 IOException 발생 (Checked Exception)
    public static void readFile() throws IOException {
        FileReader fr2 = new FileReader("README.md");
        System.out.println("README.md 파일 열기 완료");
        FileReader fr1 = new FileReader("null.txt");
        System.out.println("null.txt 파일 열기 완료");
    }

    public static void main(String[] args) {
        try {
            readFile(); // 호출자가 예외 처리
        } catch (IOException e) {
            System.out.println("없는 파일: " + e.getMessage());
        }
    }
}