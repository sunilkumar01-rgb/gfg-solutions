# Subarrays with given sum

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an unsorted array  **arr[]**  of integers and a sum  **k**. Count the number of subarrays that add to a given number k.

 **Examples:** 

```
Input: arr[] = [10, 2, -2, -20, 10], k = -10
Output: 3
Explanation: Subarrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and [-20, 10].

```

```
Input: arr[] = [1, 4, 20, 3, 10, 5], k = 33
Output: 1
Explanation: Only 1 subarray exist with sum 33 is: [20, 3, 10].
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T18:36:35.757Z  

```java
class Solution {
    public int subArraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int sum = 0;

        for (int num : arr) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/subarray-range-with-given-sum2804/1)