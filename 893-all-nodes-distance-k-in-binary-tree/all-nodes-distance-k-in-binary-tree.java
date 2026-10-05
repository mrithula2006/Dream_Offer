/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        makeParent(root, null, parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            if (distance == k) {
                List<Integer> ans = new ArrayList<>();

                for (TreeNode node : q) {
                    ans.add(node.val);
                }

                return ans;
            }

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Left
                if (node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                    visited.add(node.left);
                }

                // Right
                if (node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                    visited.add(node.right);
                }

                // Parent
                TreeNode p = parent.get(node);

                if (p != null && !visited.contains(p)) {
                    q.add(p);
                    visited.add(p);
                }
            }

            distance++;
        }

        return new ArrayList<>();
    }

    private void makeParent(TreeNode node, TreeNode p,
                             Map<TreeNode, TreeNode> parent) {

        if (node == null)
            return;

        parent.put(node, p);

        makeParent(node.left, node, parent);
        makeParent(node.right, node, parent);
    }
}