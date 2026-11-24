import java.util.*;

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        String concat = pat + "$" + txt;
        int n = concat.length();
        int[] Z = new int[n];

        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && concat.charAt(R - L) == concat.charAt(R)) R++;
                Z[i] = R - L;
                R--;
            } else {
                int k = i - L;
                if (Z[k] < R - i + 1) Z[i] = Z[k];
                else {
                    L = i;
                    while (R < n && concat.charAt(R - L) == concat.charAt(R)) R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (Z[i] == pat.length()) {
                ans.add(i - pat.length() - 1); // 0-based indexing
            }
        }
        return ans;
    }
}