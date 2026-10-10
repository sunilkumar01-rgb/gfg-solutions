# Sum Array Puzzle

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an array  **arr[]**  of integers, modify the array such that each element at index i becomes the sum of all elements of the array except the element present at index i.

That is, update each element as:
arr[i] = arr[0] + arr[1] +... + arr[i-1] + arr[i+1] +... + arr[n-1]

 **Examples:** 

```
Input: arr[] = [3, 6, 4, 8, 9]
Output: [27, 24, 26, 22, 21]
Explanation: For each index, replace the current element with the sum of all remaining elements in the array.
At index 0, sum = 6 + 4 + 8 + 9 = 27
At index 1, sum = 3 + 4 + 8 + 9 = 24
At index 2, sum = 3 + 6 + 8 + 9 = 26
At index 3, sum = 3 + 6 + 4 + 9 = 22
At index 4, sum = 3 + 6 + 4 + 8 = 21
Thus, the modified array becomes [27, 24, 26, 22, 21].
```

```
Input: arr[] = [0, 0, 1]
Output: [1, 1, 0]
Explanation: Each element is replaced with the sum of all other elements in the array.
At index 0, sum = 0 + 1 = 1
At index 1, sum = 0 + 1 = 1
At index 2, sum = 0 + 0 = 0
Thus, the modified array becomes [1, 1, 0].
```

 **Constraint :** 
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-10T10:43:16.903Z  

```java
class Solution {
    public void sumArray(int[] arr) {
        // code here
        int n=arr.length;
        int[] ans= new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        for(int i=0;i<n;i++){
            arr[i]=sum-arr[i];
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sum-array-puzzle/1)