# Reading Books

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two arrays **arr1[]**  and **arr2[]**, and an integer **k**, where arr1[i] represents the time required to read a book of kind i once and arr2[i] represents the points earned after reading it once.

Geek has k minutes and can choose  **exactly one**  kind of book. He may read the chosen book repeatedly within the available time, but cannot read books of different kinds.

Return the  **maximum**  possible points Geek can earn.

 **Examples:** 

```
Input: k = 10, arr1[] = [3, 4, 5], arr2[] = [4, 4, 5]
Output: 12
Explanation:
Choosing the first kind allows Geek to read it ⌊10 / 3⌋ = 3 times and earn 3 × 4 = 12 points.
Choosing the second kind allows Geek to read it ⌊10 / 4⌋ = 2 times and earn 2 × 4 = 8 points.
Choosing the third kind allows Geek to read it ⌊10 / 5⌋ = 2 times and earn 2 × 5 = 10 points.
Therefore, the maximum points Geek can earn is 12.

```

```
Input: k = 12, arr1 = [8, 5], arr2 = [100, 5]
Output: 100
Explanation:
Choosing the first kind allows Geek to read it ⌊12 / 8⌋ = 1 time and earn 1 × 100 = 100 points.
Choosing the second kind allows Geek to read it ⌊12 / 5⌋ = 2 times and earn 2 × 5 = 10 points.
Therefore, the maximum points Geek can earn is 100.
```

 **Constraints:** 
1 ≤ arr.size() ≤ 105
1 ≤ k, arr1[i] ≤ 104
0 ≤ arr2[i] ≤ 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-06T10:50:21.730Z  

```java
class Solution {
    public int maxPoint(int k, int[] arr1, int[] arr2) {
        // code
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++){
            int time=k/arr1[i];
            int points=arr2[i]*time;
            ans=Math.max(ans,points);
        }
        return ans;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/reading-books3803/1)