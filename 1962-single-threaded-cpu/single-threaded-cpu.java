import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // Store: [enqueueTime, processingTime, originalIndex]
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                return a[2] - b[2];
            }
        );

        int[] answer = new int[n];
        int index = 0;
        int resultIndex = 0;
        long time = 0;

        while (resultIndex < n) {

           
            if (pq.isEmpty() && time < arr[index][0]) {
                time = arr[index][0];
            }

            
            while (index < n && arr[index][0] <= time) {
                pq.offer(arr[index]);
                index++;
            }

            
            int[] task = pq.poll();

            answer[resultIndex++] = task[2];
            time += task[1];
        }

        return answer;
    }
}