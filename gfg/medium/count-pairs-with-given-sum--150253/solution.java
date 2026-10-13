class Solution {
    int countPairs(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            if (map.containsKey(k - num)) {
                count += map.get(k - num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}