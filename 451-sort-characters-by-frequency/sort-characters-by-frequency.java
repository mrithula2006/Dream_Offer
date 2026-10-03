import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

       
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        
        List<Character>[] buckets = new ArrayList[s.length() + 1];

        for (char c : map.keySet()) {
            int freq = map.get(c);

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(c);
        }

        StringBuilder result = new StringBuilder();

        
        for (int freq = buckets.length - 1; freq >= 1; freq--) {
            if (buckets[freq] != null) {
                for (char c : buckets[freq]) {
                    for (int i = 0; i < freq; i++) {
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }
}