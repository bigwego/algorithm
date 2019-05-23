package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestStartingFromLeaf {

    public String smallestFromLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        help(root, list, "");
        Collections.sort(list, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        return list.get(0);
    }

    private void help(TreeNode node, List<String> list, String prev) {
        String tmp = (char) (node.val + 'a') + prev;
        if (node.left == null && node.right == null) {
            list.add(tmp);
            return;
        }
        if (node.left != null) {
            help(node.left, list, tmp);
        }
        if (node.right != null) {
            help(node.right, list, tmp);
        }
    }

    private String smallestFromLeaf2(TreeNode root) {
        if (root == null) {
            return "";
        }
        String l = smallestFromLeaf2(root.left);
        String r = smallestFromLeaf2(root.right);
        int lenL = l.length();
        int lenR = r.length();
        if (lenL > 0 && lenR > 0) {
            return (l.compareTo(r) < 0 ? l : r) + (char) (root.val + 'a');
        }
        if (lenL > 0) {
            return l + (char) (root.val + 'a');
        } else {
            return r + (char) (root.val + 'a');
        }
    }
}
