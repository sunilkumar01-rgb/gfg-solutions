# Count Triplets with Sum in Sorted

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a sorted array  **arr[]**  and a  **target**  value, the task is to count triplets  **(i, j, k)**  of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

 **Examples:** 

```
Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Four triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2
```

```
Input: arr[] = [-2, 0, 1, 1, 5], target = 1
Output: 0
Explanation: There is no triplet whose sum is equal to 1. 
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-24T17:22:10.878Z  

```java
class Solution {
    int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    if (arr[left] == arr[right]) {
                        int len = right - left;
                        count += len * (len + 1) / 2;
                        break;
                    }

                    int leftCount = 1;
                    int rightCount = 1;

                    while (left + 1 < right &&
                           arr[left] == arr[left + 1]) {
                        leftCount++;
                        left++;
                    }

                    while (right - 1 > left &&
                           arr[right] == arr[right - 1]) {
                        rightCount++;
                        right--;
                    }

                    count += leftCount * rightCount;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1)