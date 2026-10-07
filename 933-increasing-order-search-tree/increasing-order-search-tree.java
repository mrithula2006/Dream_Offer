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
    TreeNode dummy = new TreeNode(0);
    TreeNode current = dummy;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return dummy.right;
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        root.left = null;
        current.right = root;
        current = root;

        inorder(root.right);
    }
}