package week_04._0903;

public class ExamExceptionInfo {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("abc"); // NumberFormatException 발생
        } catch (NumberFormatException e) {
            System.out.println("getMessage(): " + e.getMessage());
            System.out.println("toString(): " + e.toString());
            System.out.println("getClass(): " + e.getClass());
            System.out.println("getStackTrace()[0]: " + e.getStackTrace()[0]);
            System.out.println("printStackTrace(): ");
            e.printStackTrace();
        }
    }
}