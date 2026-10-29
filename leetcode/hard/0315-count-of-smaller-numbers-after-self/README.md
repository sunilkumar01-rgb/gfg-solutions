# Count of Smaller Numbers After Self

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an integer array `nums`, return *an integer array* `counts` *where* `counts[i]` *is the number of smaller elements to the right of* `nums[i]`.

 

 **Example 1:** 

```
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

```

 **Example 2:** 

```
Input: nums = [-1]
Output: [0]

```

 **Example 3:** 

```
Input: nums = [-1,-1]
Output: [0,0]

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -104 <= nums[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 303 ms (beats 10.11%)  
**Memory:** 111.4 MB (beats 12.08%)  
**Submitted:** 2026-10-29T16:21:54.652Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)