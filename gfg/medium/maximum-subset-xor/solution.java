class Solution {
    public static int maxSubsetXOR(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int index = 0;

        for (int bit = 31; bit >= 0; bit--) {
            int maxIndex = index;
            for (int i = index; i < n; i++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    maxIndex = i;
                    break;
                }
            }

            if (index >= n || (arr[maxIndex] & (1 << bit)) == 0) {
                continue;
            }

            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;

            for (int i = 0; i < n; i++) {
                if (i != index && (arr[i] & (1 << bit)) != 0) {
                    arr[i] = arr[i] ^ arr[index];
                }
            }

            index++;
        }

        for (int i = 0; i < index; i++) {
            ans = Math.max(ans, ans ^ arr[i]);
        }

        return ans;
    }
}