class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = txt.length(), m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            if (txt.substring(i, i + m).equals(pat)) {
                ans.add(i);
            }
        }

        return ans;
    }
}