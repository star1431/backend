package week_04._0903;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteExam {
    public static void main(String[] args) {
        String srcFile = "src/etc/IOTEST.md";
        String srcCopy = "src/etc/IOTEST_COPY.md";

        // try-with-resources를 사용한 자동 리소스 관리
        try (FileInputStream in = new FileInputStream(srcFile);
             FileOutputStream out = new FileOutputStream(srcCopy)) {

            int byteData;
            // 파일 끝(-1)까지 한 바이트씩 읽기
            while ((byteData = in.read()) != -1) {
                out.write(byteData);
            }
            System.out.println("파일 복사 완료!");

        } catch (IOException e) {
            System.err.println("파일 처리 중 오류: " + e.getMessage());
        }


        // 복사 완료 후 확인
        System.out.println("[파일 읽기 - 바이트]");
        System.out.println("─".repeat(10));
        try (FileInputStream fis = new FileInputStream(srcCopy)) {
            int byteData;
            // 파일에서 한 글자씩 읽어서 int 값으로 반환
            // 더 이상 읽을 문자가 없으면 -1 반환됨
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }
        } catch (IOException e) {
            System.out.println("오류: " + e.getMessage());
        }
        System.out.println();
        System.out.println("─".repeat(10));

    }
}