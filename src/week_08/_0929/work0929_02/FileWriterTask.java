package week_08._0929.work0929_02;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class FileWriterTask implements Runnable {
    private final String filePath;

    public FileWriterTask(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        File file = new File(filePath);

        if(!file.exists()) {
            System.out.println("[FileWriterTask] 파일없음 - 생성진행");
            try {
                boolean created = file.createNewFile();
                if (created) System.out.println("[FileWriterTask] 파일 생성 완료");
            } catch (IOException e) {
                System.out.println("[FileWriterTask] 오류: " + e.getMessage());
                return;
            }
        }

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(new FileWriter(file,  true))
            ) {
            String line;
            while (true) {
                System.out.print("[Writer] 한줄입력 (종료:exit)\n 한줄내용: ");

                line = br.readLine();

                // 종료 명령 처리 (대소문자 무시)
                if ("exit".equalsIgnoreCase(line.trim())) {
                    System.out.println("[Writer] 'exit' 입력됨. 저장완료");
                    break;
                }

                pw.println(line);
            }

        } catch (IOException e) {
            System.out.println("[FileWriterTask] 확인: " + e.getMessage());
        }
    }
}
