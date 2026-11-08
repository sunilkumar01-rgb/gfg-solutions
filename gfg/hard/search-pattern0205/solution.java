class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            if (txt.startsWith(pat, i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}