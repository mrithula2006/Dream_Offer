class Solution {
    public List<Integer> countSmaller(int[] nums) {
        

        int n = nums.length;

        int[] count = new int[n];
        int[] indexes = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, indexes, count, 0, n - 1);

        List<Integer> result = new ArrayList<>();

        for (int x : count) {
            result.add(x);
        }

        return result;
    }

    private void mergeSort(int[] nums, int[] indexes,
                           int[] count, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, indexes, count, left, mid);
        mergeSort(nums, indexes, count, mid + 1, right);

        merge(nums, indexes, count, left, mid, right);
    }

    private void merge(int[] nums, int[] indexes,
                       int[] count, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        int rightSmaller = 0;

        while (i <= mid && j <= right) {

            if (nums[indexes[j]] < nums[indexes[i]]) {

                temp[k] = indexes[j];

                rightSmaller++;
                j++;

            } else {

                temp[k] = indexes[i];

                count[indexes[i]] += rightSmaller;

                i++;
            }

            k++;
        }

        while (i <= mid) {

            temp[k] = indexes[i];

            count[indexes[i]] += rightSmaller;

            i++;
            k++;
        }

        while (j <= right) {

            temp[k] = indexes[j];

            j++;
            k++;
        }

        for (int x = 0; x < temp.length; x++) {
            indexes[left + x] = temp[x];
        }
        
    }
}