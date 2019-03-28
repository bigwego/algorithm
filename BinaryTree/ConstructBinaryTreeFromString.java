/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class ConstructBinaryTreeFromString {
    /**
     * @param s: a string
     * @return: a root of this tree
     */
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        if (s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')')
            s = s.substring(1, s.length() - 1);
        int i = s.indexOf('(');
        if (i == -1) i = s.length();
        TreeNode node = new TreeNode(Integer.valueOf(s.substring(0, i)));
        int cnt = 0;
        int j = i;
        while (j < s.length()) {
            if (s.charAt(j) == '(') cnt++;
            else if (s.charAt(j) == ')') {
                cnt--;
                if (cnt == 0) {
                    j++;
                    break;
                }
            }
            j++;
        }
        node.left = str2tree(s.substring(i, j));
        node.right = str2tree(s.substring(j));
        return node;
    }
}
