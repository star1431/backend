package week_04._0902;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class ExamDate {
    public static void main(String[] args) {

        // Date 올드 클래스  -----------------------------------------
        Date date = new Date();
        System.out.println(date); // Tue Sep 02 13:18:20 KST 2025 (현재날짜)
        Date date1 = new Date(2000,01,01);
        System.out.println(date1); // Thu Feb 01 00:00:00 KST 3900
        // 연도 1900부터 , 월 0~11 (출력할떄+1)

        int _calcyear = 1900;
        int _calcMonth = 1;
        Date date2 = new Date((2000 - _calcyear),(10 - _calcMonth),9);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(sdf.format(date)); // 2025-09-02 13:21:33
        System.out.println(sdf.format(date1)); // 3900-02-01 00:00:00
        System.out.println(sdf.format(date2)); // 2000-10-09 00:00:00
    }
}
