package week_04._0904;

import java.io.File;
import java.io.IOException;

public class Fileinfo {
    public static void main(String[] args) {
        String fileSrc = "src/etc/io_test/";

        File file = new File((fileSrc + "test.md"));
        // 파일 존재여부
        if(file.exists()) {
            System.out.println("length : " + file.length());
            System.out.println("canRead : " + file.canRead());
            System.out.println("canWrite : " + file.canWrite());
            System.out.println("getAbsolutePath : " + file.getAbsolutePath());
            try {
                System.out.println("getCanonicalPath : " + file.getCanonicalPath());
            } catch(IOException e) {
                System.out.println(e);
            }
            System.out.println("getName : " + file.getName());
            System.out.println("getParent : " + file.getParent());
            System.out.println("getPath : " + file.getPath());
        }
    }
}
