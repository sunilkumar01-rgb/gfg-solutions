class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2]; // {value, original_index}
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], i};
        }
        
        int[] count = new int[n];
        mergeSort(arr, 0, n - 1, count);
        
        List<Integer> ans = new ArrayList<>();
        for (int c : count) ans.add(c);
        return ans;
    }
    
    private void mergeSort(int[][] arr, int left, int right, int[] count) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, count);
        mergeSort(arr, mid + 1, right, count);
        
        int[][] temp = new int[right - left + 1][2];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i][0] <= arr[j][0]) {
                count[arr[i][1]] += rightCount;
                temp[k++] = arr[i++];
            } else {
                rightCount++;
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) {
            count[arr[i][1]] += rightCount;
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}