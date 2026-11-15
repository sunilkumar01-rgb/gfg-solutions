# Merge Without Extra Space

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two sorted arrays  **a[]**  and  **b[]** of size  **n** and  **m** respectively, the task is to merge them in sorted order without using any  **extra space**. Modify  **a[]**  so that it contains the first  **n**  elements and modify  **b[]**  so that it contains the last  **m**  elements.

 **Examples:** 

```
Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output: a[] = [2, 2, 3, 4], b[] = [7, 10]
Explanation: After merging the two non-decreasing arrays, we get, [2, 2, 3, 4, 7, 10]
```

```
Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
Output: a[] = [1, 2, 3, 5, 8, 9], b[] = [10, 13, 15, 20]
Explanation: After merging two sorted arrays we get [1, 2, 3, 5, 8, 9, 10, 13, 15, 20].

```

```
Input: a[] = [0, 1], b[] = [2, 3]
Output: a[] = [0, 1], b[] = [2, 3]
Explanation: After merging two sorted arrays we get [0, 1, 2, 3].
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-15T14:02:00.573Z  

```java

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

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1)