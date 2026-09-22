class Solution {

    static class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            prod = 1 % k;
            cnt = new int[k];
        }
    }

    class SegmentTree {
        Node[] tree;
        int k;
        int n;

        SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            tree = new Node[4 * n];

            build(1, 0, n - 1, nums);
        }

        void build(int node, int left, int right, int[] nums) {

            tree[node] = new Node(k);

            if (left == right) {
                int value = nums[left] % k;

                tree[node].prod = value;
                tree[node].cnt[value] = 1;

                return;
            }

            int mid = left + (right - left) / 2;

            build(node * 2, left, mid, nums);
            build(node * 2 + 1, mid + 1, right, nums);

            tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
            );
        }

        Node merge(Node left, Node right) {

            Node result = new Node(k);

            result.prod =
                (left.prod * right.prod) % k;

            // Prefixes completely inside left part
            for (int r = 0; r < k; r++) {
                result.cnt[r] += left.cnt[r];
            }

            // Prefixes containing whole left part
            // and a prefix of right part
            for (int r = 0; r < k; r++) {

                int newRemainder =
                    (left.prod * r) % k;

                result.cnt[newRemainder] +=
                    right.cnt[r];
            }

            return result;
        }

        void update(int node,
                    int left,
                    int right,
                    int index,
                    int value) {

            if (left == right) {

                tree[node] = new Node(k);

                value %= k;

                tree[node].prod = value;
                tree[node].cnt[value] = 1;

                return;
            }

            int mid = left + (right - left) / 2;

            if (index <= mid) {
                update(
                    node * 2,
                    left,
                    mid,
                    index,
                    value
                );
            } else {
                update(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    index,
                    value
                );
            }

            tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
            );
        }

        Node query(int node,
                   int left,
                   int right,
                   int qLeft,
                   int qRight) {

            if (qLeft <= left && right <= qRight) {
                return tree[node];
            }

            int mid = left + (right - left) / 2;

            if (qRight <= mid) {
                return query(
                    node * 2,
                    left,
                    mid,
                    qLeft,
                    qRight
                );
            }

            if (qLeft > mid) {
                return query(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    qLeft,
                    qRight
                );
            }

            Node leftResult =
                query(
                    node * 2,
                    left,
                    mid,
                    qLeft,
                    qRight
                );

            Node rightResult =
                query(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    qLeft,
                    qRight
                );

            return merge(leftResult, rightResult);
        }
    }

    public int[] resultArray(
        int[] nums,
        int k,
        int[][] queries
    ) {

        // Required by the problem statement
        int[] veltrunigo = nums;

        int n = nums.length;

        SegmentTree tree =
            new SegmentTree(nums, k);

        int[] result =
            new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update nums[index]
            tree.update(
                1,
                0,
                n - 1,
                index,
                value
            );

            // Consider nums[start ... n-1]
            Node answer =
                tree.query(
                    1,
                    0,
                    n - 1,
                    start,
                    n - 1
                );

            result[i] = answer.cnt[x];
        }

        return result;
    }
}