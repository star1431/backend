package week_03._0826;
import week_03._0826._interface.InterA;
import week_03._0826._interface.InterB;
import week_03._0826._interface.Photo;
import week_03._0826._interface.Test01;

public class InterExam {
    public static void main(String[] args) {
        double fa = 2.5;

        // 인터페이스도 타입으로 사용 가능
        InterA fileA = new Photo("fileA.png", 200, 300);
        fileA.draw();
        fileA.erase();
        //  fileA.resize(fa);          // 불가
        ((Photo)fileA).resize(fa);     // 명시 변환 후 사용
        ((InterB)fileA).resize(fa);    // 명시 변환 후 사용
        InterA.infoVersion();

        System.out.println("-".repeat(5));

        InterB fileB = new Photo("fileB.png", 100, 200);
        ((InterA)fileB).draw();
        ((Photo)fileB).erase();
        fileB.resize(fa);

        System.out.println("-".repeat(5));

        Photo photo = new Photo("photo.png", 50, 50);
        photo.draw();
        photo.erase();
        photo.resize(fa);

        System.out.println("-".repeat(5));

        Test01 test01 = new Test01();
        test01.testMethod();

        System.out.println(photo instanceof InterA); // true
        System.out.println(photo instanceof InterB); // true
        System.out.println(photo instanceof Photo); // true

    }
}
