package week_08._0929;

// 우선순위 예제
// public class PriorityExam {
//     public static void main(String[] args) {
//         Thread highPriority = new Thread(() -> {
//             for (int i = 0; i < 10; i++) {
//                 System.out.println("높은 우선순위: " + i);
//             }
//         });

//         Thread lowPriority = new Thread(() -> {
//             for (int i = 0; i < 10; i++) {
//                 System.out.println("낮은 우선순위: " + i);
//             }
//         });

//         // highPriority.setPriority(Thread.MAX_PRIORITY); // 10
//         // lowPriority.setPriority(Thread.MIN_PRIORITY);  // 1

//         highPriority.setPriority(10); // 10
//         lowPriority.setPriority(1);  // 1

//         highPriority.start();
//         lowPriority.start();
//     }
// }

public class PriorityExam {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("[thread1] 작업중 " + i + "/3");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("[thread1] 작업 중단!");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("[thread2] 작업중 " + i + "/3");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("[thread2] 작업 중단!");
                }
            }
        });


        Thread thread3 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("[thread3] 작업중 " + i + "/3");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("[thread3] 작업 중단!");
                }
            }
        });
    
        // setPriority 높은값일수록 우선순위 높음
        thread1.setPriority(Thread.MIN_PRIORITY); // 우선순위 낮음 - 1
        thread2.setPriority(Thread.MAX_PRIORITY); // 우선순위 높음 - 10
        thread3.setPriority(5); // 정수로 지정가능

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
