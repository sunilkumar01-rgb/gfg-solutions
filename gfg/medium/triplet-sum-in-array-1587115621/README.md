# Triplet Sum in Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  and an integer  **target**, determine if there exists a triplet in the array whose sum equals the given  **target**.

Return  **true**  if such a triplet exists, otherwise, return  **false**.

**Examples: 
**

```
Input: arr[] = [1, 4, 45, 6, 10, 8], target = 13
Output: true 
Explanation: The triplet {1, 4, 8} sums up to 13.
```

```
Input: arr[] = [1, 2, 4, 3, 6, 7], target = 10
Output: true 
Explanation: The triplets {1, 3, 6} and {1, 2, 7} both sum to 10. 
```

```
Input: arr[] = [40, 20, 10, 3, 6, 7], target = 24
Output: false 
Explanation: No triplet in the array sums to 24.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-21T10:06:20.465Z  

```java
class Solution {
    public boolean hasTripletSum(int arr[], int target) {
        int n = arr.length;
        if (n < 3) return false;

        // 1. Array ko sort karo
        Arrays.sort(arr);

        // 2. Har element ko fix karke baaki 2 elements Two Pointers se dhundho
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum == target) {
                    return true; // Match mil gaya
                } else if (currentSum < target) {
                    left++; // Sum chhota hai, toh bada element chahiye
                } else {
                    right--; 
                }
            }
        }

        return false; // Koi triplet nahi mila
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1)