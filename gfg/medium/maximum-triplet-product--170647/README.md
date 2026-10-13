# Maximum Triplet product

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr**, find the maximum product that can be obtained by multiplying any three elements of the array. Return the maximum triplet product.

 **Examples:** 

```
Input: arr[] = [1, 2, 3, 5]
Output: 30
Explanation: (5) *(3)* (2) gives 30. This is the maximum possible triplet product in the array.

```

```
Input: arr[] = [-3, -5, 1, 0, 8, 3, -2]
Output: 120
Explanation: (-3) *(-5)* (8) gives 120. This is the maximum possible triplet product in the array.

```

 **Constraints:** 
3 ≤ n ≤ 5*106
-10-3 ≤ arr[i] ≤ 103

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-13T17:28:59.614Z  

```java
class Solution {
    int maxTripletProduct(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        long option1 = (long) arr[n - 1] * arr[n - 2] * arr[n - 3];
        long option2 = (long) arr[0] * arr[1] * arr[n - 1];

        return (int) Math.max(option1, option2);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/maximum-triplet-product--170647/1)