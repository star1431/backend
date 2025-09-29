package week_08._0929.work0929_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileReaderTask implements Runnable {
    private String filePath;

    public FileReaderTask(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        File file = new File(filePath);
        if(!file.exists()) {
            System.out.println("[FileReaderTask] 파일없음");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int cnt = 0;
            while ((line = br.readLine()) != null) {
                try {
                    System.out.println("[readLine-" + cnt++ + "]: " + line);
                    Thread.sleep(1000); // 확인용 지연
                } catch (InterruptedException e) {
                    System.out.println("[FileReaderTask] 중단: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("[FileReaderTask] 확인: " + e.getMessage());
        }
    }
}
