class Solution {
    static long inversionCount(int[] arr) {
        int n = arr.length;
        long[] temp = new long[n];
        return mergeSort(arr, temp, 0, n - 1);
    }

    static long mergeSort(int[] arr, long[] temp, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(arr, temp, left, mid);
            count += mergeSort(arr, temp, mid + 1, right);
            count += merge(arr, temp, left, mid, right);
        }
        return count;
    }

    static long merge(int[] arr, long[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        long count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int x = left; x <= right; x++) {
            arr[x] = (int) temp[x];
        }
        return count;
    }
}