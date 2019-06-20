import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Condition condition = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " : " + 1);
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
                System.out.println(Thread.currentThread().getName() + " : " + 2);
                lock.unlock();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " : " + 1);
                System.out.println(Thread.currentThread().getName() + " : " + 2);
                condition.signal();
                lock.unlock();
            }
        }).start();


    }
}