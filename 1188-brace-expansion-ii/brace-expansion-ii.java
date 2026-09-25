class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = solve(expression);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> solve(String s) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == ',') {
                result.addAll(current);
                current.clear();
                current.add("");
                i++;
            } 
            else if (ch == '{') {
                int j = i;
                int count = 0;

                while (j < s.length()) {
                    if (s.charAt(j) == '{') count++;
                    if (s.charAt(j) == '}') count--;

                    if (count == 0) break;
                    j++;
                }

                Set<String> temp = solve(s.substring(i + 1, j));
                current = combine(current, temp);
                i = j + 1;
            } 
            else {
                Set<String> temp = new HashSet<>();
                temp.add(String.valueOf(ch));
                current = combine(current, temp);
                i++;
            }
        }

        result.addAll(current);
        return result;
    }

    private Set<String> combine(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}