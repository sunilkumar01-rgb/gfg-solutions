class Solution {
    static int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1, j = 0;
        int platforms = 1;
        int ans = 1;

        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }

            ans = Math.max(ans, platforms);
        }

        return ans;
    }
}