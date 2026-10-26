
class Solution {
    public int countTriplets(int[] nums) {
        int n = nums.length;
        int[] count = new int[1 << 16];

        for (int a : nums) {
            for (int b : nums) {
                count[a & b]++;
            }
        }

        int ans = 0;

        for (int c : nums) {
            for (int mask = 0; mask < (1 << 16); mask++) {
                if ((mask & c) == 0) {
                    ans += count[mask];
                }
            }
        }

        return ans;
    }
}
