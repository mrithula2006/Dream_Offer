import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] window = new int[26];

        
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int k = p.length();

        
        for (int i = 0; i < k; i++) {
            window[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, window)) {
            result.add(0);
        }

       
        for (int i = k; i < s.length(); i++) {
            
            window[s.charAt(i) - 'a']++;

            
            window[s.charAt(i - k) - 'a']--;

           
            if (Arrays.equals(pCount, window)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }
}