import java.util.HashMap;

class Solution {
    int countPairs(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;

            // Agar complement pehle mil chuka hai, toh utne pairs banenge
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            // Current number ko map me add karo
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}