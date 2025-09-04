# java.time

```bash
java.io
    ├─ InputStream (abstract)
    │    ├─ FileInputStream
    │    ├─ BufferedInputStream
    │    └─ ObjectInputStream
    │
    ├─ OutputStream (abstract)
    │    ├─ FileOutputStream
    │    ├─ BufferedOutputStream
    │    └─ ObjectOutputStream
    │
    ├─ Reader (abstract)
    │    ├─ FileReader
    │    ├─ BufferedReader
    │    └─ InputStreamReader
    │
    ├─ Writer (abstract)
    │    ├─ FileWriter
    │    ├─ BufferedWriter
    │    └─ PrintWriter
    │
    ├─ File
    ├─ Serializable (interface)
    └─ ...

```

## 1. InputStream / OutputStream 바이트 기반 클래스

| 클래스                  | 설명             | 예시                            |
| -------------------- | -------------- | ----------------------------- |
| FileInputStream      | 파일에서 바이트 단위 읽기 | new FileInputStream("a.txt")  |
| FileOutputStream     | 파일에 바이트 단위 쓰기  | new FileOutputStream("a.txt") |
| BufferedInputStream  | 버퍼링된 입력 (성능↑)  | new BufferedInputStream(in)   |
| BufferedOutputStream | 버퍼링된 출력 (성능↑)  | new BufferedOutputStream(out) |



```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("파일 복사 완료");
            // 파일 복사 완료
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("input.jpg"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output.jpg"))) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            bos.flush();
            System.out.println("이미지 복사 완료");
            // 이미지 복사 완료
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 2. Reader / Writer 문자 기반 클래스

| 클래스            | 설명            | 예시                                          |
| -------------- | ------------- | ------------------------------------------- |
| FileReader     | 파일에서 문자 단위 읽기 | new FileReader("a.txt")                     |
| FileWriter     | 파일에 문자 단위 쓰기  | new FileWriter("a.txt")                     |
| BufferedReader | 한 줄 단위 읽기 지원  | new BufferedReader(new FileReader("a.txt")) |
| BufferedWriter | 버퍼 출력         | new BufferedWriter(new FileWriter("a.txt")) |
| PrintWriter    | println 지원    | new PrintWriter("a.txt")                    |




```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             FileWriter fw = new FileWriter("output.txt")) {

            String line;
            while ((line = br.readLine()) != null) {
                fw.write(line + "\n");
            }
            System.out.println("문자 단위 파일 복사 완료");
            // 문자 단위 파일 복사 완료
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 3. File 클래스

| 메서드             | 설명       | 예시                   |
| --------------- | -------- | -------------------- |
| exists()        | 존재 여부    | file.exists()        |
| isFile()        | 파일 여부    | file.isFile()        |
| isDirectory()   | 디렉토리 여부  | file.isDirectory()   |
| length()        | 크기(byte) | file.length()        |
| createNewFile() | 새 파일 생성  | file.createNewFile() |
| delete()        | 파일 삭제    | file.delete()        |
| mkdir()         | 디렉토리 생성  | file.mkdir()         |
| listFiles()     | 하위 목록    | file.listFiles()     |




```java
import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File f = new File("test.txt");

        if (!f.exists()) {
            f.createNewFile();
            System.out.println("파일 생성");
            // 파일 생성
        }

        System.out.println("경로: " + f.getAbsolutePath());
        // 절대경로 출력

        System.out.println("크기(byte): " + f.length());
        // 0

        if (f.isFile()) {
            System.out.println("이건 파일입니다.");
            // 이건 파일입니다.
        }

        f.delete();
        System.out.println("파일 삭제됨");
        // 파일 삭제됨
    }
}
```