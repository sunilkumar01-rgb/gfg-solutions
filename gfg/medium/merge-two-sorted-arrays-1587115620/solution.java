
class Solution {
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        int len = n + m;

        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {

                // Both pointers in array a
                if (left < n && right < n) {
                    if (a[left] > a[right]) {
                        swap(a, left, right);
                    }
                }

                // Left in a, right in b
                else if (left < n && right >= n) {
                    if (a[left] > b[right - n]) {
                        int temp = a[left];
                        a[left] = b[right - n];
                        b[right - n] = temp;
                    }
                }

                // Both pointers in array b
                else {
                    if (b[left - n] > b[right - n]) {
                        swap(b, left - n, right - n);
                    }
                }

                left++;
                right++;
            }

            if (gap == 1) {
                gap = 0;
            } else {
                gap = (gap / 2) + (gap % 2);
            }
        }
    }

    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
