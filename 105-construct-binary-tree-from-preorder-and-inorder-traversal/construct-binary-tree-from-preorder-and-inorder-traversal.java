/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preIndex,
                           int[] inorder, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        // First element in preorder is the root
        int rootValue = preorder[preIndex];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int index = inStart;

        while (inorder[index] != rootValue) {
            index++;
        }

        // Number of elements in left subtree
        int leftSize = index - inStart;

        // Build left subtree
        root.left = build(
            preorder,
            preIndex + 1,
            inorder,
            inStart,
            index - 1
        );

        // Build right subtree
        root.right = build(
            preorder,
            preIndex + leftSize + 1,
            inorder,
            index + 1,
            inEnd
        );

        return root;
    }
}