import java.util.*;

class Solution {
    public boolean subArrayExists(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : arr) {
            sum += num;

            if (sum == 0 || set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }

        return false;
    }
}