class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Count characters in s1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        // Create the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // Check the first window
        if (matches(count1, count2)) {
            return true;
        }

        // Slide the window
        for (int right = s1.length(); right < s2.length(); right++) {

            // Add the new character
            count2[s2.charAt(right) - 'a']++;

            // Remove the leftmost character
            int left = right - s1.length();
            count2[s2.charAt(left) - 'a']--;

            // Check if frequencies match
            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] count1, int[] count2) {

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }
}