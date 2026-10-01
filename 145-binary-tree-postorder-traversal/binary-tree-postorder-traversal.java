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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        postorder(root, result);

        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        // Visit left subtree
        postorder(root.left, result);

        // Visit right subtree
        postorder(root.right, result);

        // Visit root
        result.add(root.val);
    }
}