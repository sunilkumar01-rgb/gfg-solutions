import java.util.Arrays;

class Solution {
    public int toyCount(int[] arr, int k) {
        Arrays.sort(arr); // Sasti toys pehle kharido

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k -= arr[i];
                count++;
            } else {
                break; // Agar ye nahi khareed sakte, toh aage wale bhi nahi khareed sakte
            }
        }

        return count;
    }
}