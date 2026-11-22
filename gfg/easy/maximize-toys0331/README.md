# Maximum Count with Sum Limited to K

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array arr[ ] consisting cost of n toys and an integer k depicting the amount you have. Find the maximum number of toys that you can buy with amount k and return it. 

 **Examples:** 

```
Input: arr[] = [1, 12, 5, 111, 200, 1000, 10], k = 50
Output: 4
Explanation: The costs of the toys you can buy are 1, 12, 5 and 10.
```

```
Input: arr[] = [20, 30, 50], k = 100
Output: 3
Explanation: You can buy all toys.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-22T17:10:46.406Z  

```java
import java.util.Arrays;

class Solution {
    public int toyCount(int[] arr, int k) {
        Arrays.sort(arr); // Sasti toys pehle kharido

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k -= arr[i];
                count++;
            } else {
                break; // Agar ye nahi khareed sakte, toh aage wale bhi nahi khareed sakte
            }
        }

        return count;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/maximize-toys0331/1)