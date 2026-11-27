import java.util.Arrays;

class Solution {
    public int minPlatform(int[] arr, int[] dep) {
        // Dono arrays ko sort kar liya taaki chronological order me process kar sakein
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int platforms = 1;
        int maxPlatforms = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            // Agar next train aane se pehle pichli train chali gayi (arr[i] > dep[j])
            if (arr[i] > dep[j]) {
                platforms--; // Ek platform khali ho gaya
                j++;
            } else {
                // Train aayi par koi khali nahi, naya platform chahiye
                platforms++;
                i++;
            }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }
}