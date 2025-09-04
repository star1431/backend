package week_04._0904;

import java.io.File;
import java.io.IOException;

public class FileDel {
    public static void main(String[] args) {
        String fileSrc = "src/etc/del/";

        File dir = new File(fileSrc);
        File file = new File(fileSrc,"deltest.md");
        
        // 폴더 및 파일 생성
        try {
            if(dir.mkdirs() && file.createNewFile()) {
                System.out.println("폴더 및 파일 생성 시도 완료");
                System.out.println("파일 경로: " + file.getPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(3000); // 3초 동안 프로그램 멈춤
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        long end = System.currentTimeMillis();

        System.out.println("슬립 걸린 시간(ms): " + (end - start));

        if(file.exists()) {
            if(file.delete()) System.out.println("파일 삭제 성공: " + file.getPath());
            else System.out.println("파일 삭제 실패");
        }
        if(dir.exists()) {
            if (dir.delete()) System.out.println("폴더 삭제 성공: " + dir.getPath());
            else System.out.println("폴더 삭제 실패");
        }
    }
}
