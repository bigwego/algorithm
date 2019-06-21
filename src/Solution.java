import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {

    static int[] nums = { 1, 2, 3 };

    static char[] chs = { 'a', 'b', 'c' };

    static final ReentrantLock lock = new ReentrantLock();

    static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            lock.lock();
            while (i++ < 3) {
                System.out.println(nums[i]);
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
            lock.unlock();
        }).start();

        new Thread(() -> {
            int i = 0;
            lock.lock();
            while (i++ < 3) {
                System.out.println(chs[i]);
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
        });
    }
}