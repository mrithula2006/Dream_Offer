
class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();

        for (int num : nums) {
            sb.append(num);
        }

        String s = sb.toString();
        int[] ans = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            ans[i] = s.charAt(i) - '0';
        }

        return ans;
    }
}