/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {};
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        check(root);
        return maxSum;
    }

    int[] check(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = check(root.left);
        int[] right = check(root.right);

     
        if (left[0] == 1 && right[0] == 1 &&
            root.val > left[3] && root.val < right[2]) {

            int sum = left[1] + right[1] + root.val;

            maxSum = Math.max(maxSum, sum);

            int min = Math.min(root.val, left[2]);
            int max = Math.max(root.val, right[3]);

            return new int[]{1, sum, min, max};
        }

        return new int[]{0, 0, 0, 0};
    }
}