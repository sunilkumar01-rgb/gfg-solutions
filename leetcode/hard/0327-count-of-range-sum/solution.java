class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return mergeSort(prefix, 0, n, lower, upper);
    }
    
    private int mergeSort(long[] prefix, int left, int right, int lower, int upper) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(prefix, left, mid, lower, upper) + 
                    mergeSort(prefix, mid + 1, right, lower, upper);
        
        int j = mid + 1, k = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && prefix[j] - prefix[i] < lower) j++;
            while (k <= right && prefix[k] - prefix[i] <= upper) k++;
            count += k - j;
        }
        
        long[] temp = new long[right - left + 1];
        int i = left, p = mid + 1, t = 0;
        while (i <= mid && p <= right) {
            if (prefix[i] <= prefix[p]) temp[t++] = prefix[i++];
            else temp[t++] = prefix[p++];
        }
        while (i <= mid) temp[t++] = prefix[i++];
        while (p <= right) temp[t++] = prefix[p++];
        System.arraycopy(temp, 0, prefix, left, temp.length);
        
        return count;
    }
}