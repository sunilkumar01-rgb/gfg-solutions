import java.util.*;

class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        int m = arr1.length;
        int n = arr2.length;

        int diff = Integer.MAX_VALUE;
        int res_l = 0, res_r = 0;

        int l = 0, r = n - 1;

        while (l < m && r >= 0) {
            int sum = arr1[l] + arr2[r];

            if (Math.abs(sum - x) < diff) {
                res_l = l;
                res_r = r;
                diff = Math.abs(sum - x);
            }

            if (sum > x) {
                r--;
            } else {
                l++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr1[res_l]);
        ans.add(arr2[res_r]);

        return ans;
    }
}