class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // Add players 1 to n
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {

            // Move k-1 players to the back
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }

            // Remove the kth player
            queue.poll();
        }

        return queue.peek();
    }
}