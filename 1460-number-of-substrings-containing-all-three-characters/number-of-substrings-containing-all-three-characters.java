class Solution {
    public int numberOfSubstrings(String s) {

        int[] count = new int[3];

        int left = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            count[s.charAt(right) - 'a']++;

            // Window contains a, b and c
            while (count[0] > 0 &&
                   count[1] > 0 &&
                   count[2] > 0) {

                // All substrings starting from left
                // up to right are valid
                answer += s.length() - right;

                // Remove left character
                count[s.charAt(left) - 'a']--;

                left++;
            }
        }

        return answer;
    }
}