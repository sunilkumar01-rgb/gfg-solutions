class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        // Agar students books se zyada hain toh allocation possible nahi hai
        if (k > n) return -1;

        // Overflow se bachne ke liye low aur high ko long rakha hai
        long low = 0, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        long ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private boolean isPossible(int[] arr, int m, long maxPages) {
        int students = 1;
        long currentPages = 0;

        for (int i = 0; i < arr.length; i++) {
            if (currentPages + arr[i] <= maxPages) {
                currentPages += arr[i];
            } else {
                students++;
                currentPages = arr[i];
            }
        }
        return students <= m;
    }
}