public class AtomicDemo {

    private static int cnt = 0;

    private static void incr() {
        cnt++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3000; i++) {
            new Thread(() -> {
                AtomicDemo.incr();
            }).start();
        }

        System.out.println(cnt);
    }
}
