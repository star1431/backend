package week_08._0929.work0929_02;



public class FileReadWriteApp {
    private static final String src = 
        "src/" + 
        FileReadWriteApp.class.getPackageName()
        .replace(".", "/") + "/";

    private static final String inputFile = "input.txt";
    private static final String outputFile = "output.txt";

    public static void main(String[] args) {
        FileReaderTask readTask = new FileReaderTask(src + inputFile);
        FileWriterTask writeTask = new FileWriterTask(src + outputFile);
        
        Thread th1 = new Thread(readTask);
        Thread th2 = new Thread(writeTask);

        th1.start();
        th2.start();
    }
}
