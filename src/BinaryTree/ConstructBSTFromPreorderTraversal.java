package BinaryTree;

public class ConstructBSTFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        return help(preorder, 0, preorder.length - 1);
    }

    private TreeNode help(int[] arr, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(arr[l]);
        }
        TreeNode node = new TreeNode(arr[l]);
        if (arr[l + 1] < arr[l]) {
            int mid = l + 2;
            while (mid <= r && arr[mid] < arr[l]) {
                mid++;
            }
            node.left = help(arr, l + 1, mid - 1);
            node.right = help(arr, mid, r);
        } else {
            node.left = null;
            node.right = help(arr, l + 1, r);
        }
        return node;
    }
}
