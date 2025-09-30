package week_08._0929;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ThreadLocalExam {
    // 각 스레드마다 독립적인 SimpleDateFormat 객체를 생성
    private static final ThreadLocal<SimpleDateFormat> dateFormatter =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public String formatDate(Date date) {
        // 각 스레드가 자신만의 SimpleDateFormat 인스턴스 사용
        return dateFormatter.get().format(date);
    }

    public static void main(String[] args) {
        ThreadLocalExam exam = new ThreadLocalExam();

        // 여러 스레드에서 안전하게 사용
        for (int i = 0; i < 5; i++) {
            int cnt = i;
            new Thread(() -> {
                Date now = new Date(); // java.util.Date 객체
                String formatted = exam.formatDate(now); // ThreadLocal 포맷 사용
                System.out.println("[" + cnt + "] " + Thread.currentThread().getName() +
                        ": " + formatted);
            }).start();
        }
    }
}
