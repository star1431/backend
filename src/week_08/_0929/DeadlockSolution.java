package week_08._0929;

// 6-4. 데드락 락순서 통일
public class DeadlockSolution {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();

    // 진입점 락 통일 (lock1)
    public void method1() {
        synchronized(lock1) {
            synchronized(lock2) {
                synchronized(lock3) {
                    // 작업 수행
                }
            }
        }
    }

    // 진입점 락 통일 (lock1)
    public void method2() {
        synchronized(lock1) {
            synchronized(lock3) {
                synchronized(lock2) {
                    // 작업 수행
                }
            }
        }
    }
}