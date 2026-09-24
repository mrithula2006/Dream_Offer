import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int s : score) {
            pq.offer(s);
        }

        HashMap<Integer, String> map = new HashMap<>();

        int rank = 1;

        while (!pq.isEmpty()) {
            int s = pq.poll();

            if (rank == 1)
                map.put(s, "Gold Medal");
            else if (rank == 2)
                map.put(s, "Silver Medal");
            else if (rank == 3)
                map.put(s, "Bronze Medal");
            else
                map.put(s, String.valueOf(rank));

            rank++;
        }

        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            ans[i] = map.get(score[i]);
        }

        return ans;
    }
}