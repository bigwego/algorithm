package Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    public static void main(String[] args) {
        int[] arr = new int[]{ 7, 8, 9, 1, 2, 3, 4, 5 };
        System.out.println(findRotateArray(arr, 7));
    }
}
