import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> up = new HashMap<>();
        Map<Integer, Integer> down = new HashMap<>();
        for (int[] trip : trips) {
            up.put(trip[1], up.getOrDefault(trip[1], 0) + trip[0]);
            down.put(trip[2], down.getOrDefault(trip[2], 0) + trip[0]);
        }

        int cnt = 0;

        for (int i = 0; i <= 1000; i++) {
            if (up.containsKey(i))
                cnt += up.get(i);
            if (down.containsKey(i))
                cnt -= up.get(i);
            if (cnt > capacity) return false;
        }

        return true;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        int l = 0, r = len - 1;
        int maxIdx = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int num = mountainArr.get(mid);
            int prev = mountainArr.get(mid - 1);
            int next = mountainArr.get(mid + 1);
            if (num > prev && num > next) {
                maxIdx = mid;
                break;
            } else if (num < next) {
                r = mid;
            } else if (num > prev) {
                l = mid + 1;
            }
        }

        int leftIdx = find(mountainArr, target, 0, maxIdx);
        if (leftIdx != -1) return leftIdx;
        return find2(mountainArr, target, maxIdx + 1, len - 1);
    }

    private int find(MountainArray mountainArr, int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) == target) return mid;
            if (mountainArr.get(mid) < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    private int find2(MountainArray mountainArr, int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) == target) return mid;
            if (mountainArr.get(mid) < target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }


}

interface MountainArray {
    public int get(int index);

    public int length();
}