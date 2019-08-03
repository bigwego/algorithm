package Array;

import java.util.*;

import BinaryTree.TreeNode;

public class Solution {

    public void change(String str) {
        if (str == null || str.length() == 0) return;

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '.') sb.append("\n");
            else sb.append(c);
        }
    }

    public static int findRotateArray(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] >= arr[l] && target >= arr[l]) {
                if (arr[mid] > target) r = mid - 1;
                else l = mid + 1;
            } else if (arr[mid] < arr[l] && target < arr[l]) {
                if (arr[mid] > target) r = mid - 1;
                else l = mid + 1;
            } else {
                if (arr[mid] > target) l = mid + 1;
                else r = mid - 1;
            }
        }

        return arr[l] == target ? l : -1;
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        Arrays.sort(bookings, (b1, b2) -> b1[0] - b2[0]);
        return null;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (root == null || to_delete == null || to_delete.length == 0) return res;

        res.add(root);

        for (int i = 0; i < to_delete.length && !res.isEmpty(); i++) {
            int d = to_delete[i];
            for (int j = 0; j < res.size(); j++) {
                TreeNode curr = res.poll();
                del(null, curr, res, d);
            }
        }

        return res;
    }

    private void del(TreeNode p, TreeNode curr, LinkedList<TreeNode> res, int d) {
        if (curr == null) return;

        if (curr.val == d) {
            if (p != null) {
                if (p.left == curr) p.left = null;
                else p.right = null;
            }
            if (curr.left != null) res.add(curr.left);
            if (curr.right != null) res.add(curr.right);
            return;
        }

        del(curr, curr.left, res, d);
        del(curr, curr.right, res, d);
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;

        for (int[] d : dominoes) {
            String key = "" + d[0] + d[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        Set<String> set = new HashSet<>();

        for (String key : map.keySet()) {
            if (map.get(key) > 1)
                res += map.get(key) * (map.get(key) - 1);
            String revKey = "" + key.charAt(1) + key.charAt(0);
            if (!revKey.equals(key) && map.containsKey(revKey) && !set.contains(revKey))
                res += map.get(key) * map.get(revKey);
            set.add(key);
        }

        return res;
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] res = new int[n];
        LinkedList<Integer> queue = new LinkedList<>();

        Arrays.fill(res, -1);
        res[0] = 0;
        queue.add(0);
        int d = 1;

        while (!queue.isEmpty()) {
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                int curr = queue.poll();

            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(alphabetBoardPath("leet"));
    }

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;

        int[] dp = new int[n];
        dp[1] = dp[2] = 1;

        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n - 1];
    }

    public static String alphabetBoardPath(String target) {
        String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0, len = board.length; i < len; i++) {
            String s = board[i];
            for (int j = 0, sz = s.length(); j < sz; j++)
                map.put(s.charAt(j), new int[]{i, j});
        }

        StringBuilder sb = new StringBuilder();
        int[] curr = new int[]{0, 0};

        for (char c : target.toCharArray()) {
            int[] pos = map.get(c);
            int x = pos[0] - curr[0];
            int y = pos[1] - curr[1];
            System.out.println(x + "" + y);
            if (x > 0) while (x-- > 0) sb.append("D");
            else if (x < 0) while (x++ < 0) sb.append("U");
            if (y > 0) while (y-- > 0) sb.append("R");
            else if (y < 0) while (y++ < 0) sb.append("L");
            sb.append("!");
            curr[0] = pos[0];
            curr[1] = pos[1];
        }

        return sb.toString();
    }
}
