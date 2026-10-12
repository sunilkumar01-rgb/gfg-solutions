# Frequency of Element

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array  **a**  **rr**  of positive integers and an integer  **x**. Return the frequency of  **x**  in the array.

 **Examples :** 

```
Input: arr = [1, 1, 1, 1, 1], x = 1
Output: 5
Explanation: Frequency of 1 is 5.
```

```
Input: arr = [1, 2, 3, 3, 2, 1], x=2
Output: 2
Explanation: Frequency of 2 is 2.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-12T17:35:23.343Z  

```java
class Solution {
    int findFrequency(int arr[], int x) {
        int count = 0;
        for (int num : arr) {
            if (num == x) count++;
        }
        return count;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-the-frequency/1)