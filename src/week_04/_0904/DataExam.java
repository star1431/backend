package week_04._0904;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataExam {
    public static void main(String[] args) {
        String path = "src/etc/io_test/data.txt";
        try(
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
        ) {
            dos.writeBoolean(true);
            dos.writeChar('a');
            dos.writeInt(10);
            dos.writeDouble(3.14);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (
                DataInputStream dis = new DataInputStream(new FileInputStream(path));
        ) {
            System.out.println(dis.readBoolean());
            System.out.println(dis.readChar());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
