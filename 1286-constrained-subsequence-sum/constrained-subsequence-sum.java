import java.util.*;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {

        int n = nums.length;
        int[] dp = new int[n];

        Deque<Integer> deque = new LinkedList<>();

        int answer = nums[0];

        for (int i = 0; i < n; i++) {

            // Remove indices outside the window
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            // Best previous dp value
            if (!deque.isEmpty()) {
                dp[i] = nums[i] + Math.max(0, dp[deque.peekFirst()]);
            } else {
                dp[i] = nums[i];
            }

            answer = Math.max(answer, dp[i]);

            // Maintain decreasing dp values
            while (!deque.isEmpty() &&
                   dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return answer;
    }
}