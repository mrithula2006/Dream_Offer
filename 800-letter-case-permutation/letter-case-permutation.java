class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s.toCharArray(), 0, ans);
        return ans;
    }

    private void backtrack(char[] arr, int index, List<String> ans) {
        if (index == arr.length) {
            ans.add(new String(arr));
            return;
        }

        if (Character.isLetter(arr[index])) {
            arr[index] = Character.toLowerCase(arr[index]);
            backtrack(arr, index + 1, ans);

            arr[index] = Character.toUpperCase(arr[index]);
            backtrack(arr, index + 1, ans);
        } else {
            backtrack(arr, index + 1, ans);
        }
    }
}