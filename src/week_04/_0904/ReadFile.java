package week_04._0904;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws Exception {
        String fileSrc = "src/etc/io_test/";
        // HelloWorld!!!!

        FileInputStream fisTest = new FileInputStream((fileSrc + "0904.txt"));
        System.out.println(fisTest.read()); //  72 → H
        System.out.println((char)fisTest.read()); // e
        // read() : 읽을때마다 다음 것 진행

        fisTest.close();

        // 1바이트 -------------------------------------------------------
        // try-catch-finally 기본 방식
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream((fileSrc + "0904.txt"));
            fos = new FileOutputStream(fileSrc + "0904_output.md");
            int ch;
            int cnt = 0;
            // 1바이트씩 / -1 인 경우 파일의 끝
            while ((ch = fis.read()) != -1) {
                fos.write(ch); // 실제 쓰는 일은 OS가 함
                cnt++;
            }
            System.out.println("1byte 진행: " + cnt);
            // 1byte씩: 14
        } catch (IOException e) {
            System.out.println("오류: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 바이트 묶음 -------------------------------------------------------
        // try-with-resources 방식
        try (
            FileInputStream fis1 = new FileInputStream((fileSrc + "0904.txt"));
            FileOutputStream fos1 = new FileOutputStream(fileSrc + "0904_output.md");
        ) {
            int ch1;
            int cnt1 = 0;
            byte[] bytes = new byte[1024]; // 1KB

            // read(bytes[]) : 최대 bytes.length 만큼 읽고, 실제 읽힌 바이트 수를 반환
            while ((ch1 = fis1.read(bytes)) != -1) {
                // String str = new String(bytes, 0, ch1);
                // System.out.println(str);
                fos1.write(ch1);
                cnt1++;
            }
            System.out.println("byte[1024] 진행: " + cnt1);
            // byte[1024] 진행: 1

        } catch (IOException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
