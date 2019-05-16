package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {

    private List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();

        if ((N & 1) == 0) {
            return res;
        }

        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        for (int i = 1; i < N - 1; i += 2) {
            TreeNode node = new TreeNode(0);
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    node.left = leftNode;
                    node.right = rightNode;
                    res.add(node);
                }
            }

        }

        return res;
    }
}
