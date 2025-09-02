package week_04._0902;

public class ExamException {
    public static void main(String[] args) {
        exam01();
    }

    public static void method1(int[] arr) {
        try {
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array: " + e);
        } catch (Exception e) {
            System.out.println("Exception:");
            e.printStackTrace();
        }
    }

    public static void exam01() {
        int[] arr1 = new int[5];
        int[] arr2 = null;
        method1(arr1);
        System.out.println("메서드(arr1) 실행 후");
        method1(arr2);
        System.out.println("메서드(arr2) 실행 후");
    }
}
