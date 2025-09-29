package week_08._0929;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ThreadLocalExam {
    private static final ThreadLocal<SimpleDateFormat> dateFormatter =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public String formatDate(Date date) {
        // 각 스레드가 자신만의 SimpleDateFormat 인스턴스 사용
        return dateFormatter.get().format(date);
    }

    public static void main(String[] args) {

        // 여러 스레드에서 안전하게 사용
        for (int i = 0; i < 5; i++) {
            int cnt = i;
            new Thread(() -> {
                // yyyy-MM-dd HH:mm:ss
                LocalDateTime now = LocalDateTime.now();
                String formatted = now.format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                );
                // currentThread().getName()
                // ->  현재 실행중인 스레드 이름 (Thread-0, Thread-1, ...)
                System.out.println("[" + cnt + "] " + Thread.currentThread().getName() +
                        ": " + formatted);
            }).start();
        }
    }
}
