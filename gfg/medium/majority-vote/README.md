# Majority Element - More Than n/3

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr**  **[]**  consisting of  **n**  integers, find all the array elements which occurs more than  **floor(n/3)**  times. Return the resulting array in strictly increasing order. If no such elements exist, return an empty array.

 **Examples:** 

```
Input: arr[] = [2, 2, 3, 1, 3, 2, 1, 1]
Output: [1, 2]
Explanation: The frequency of 1 and 2 is 3, which is more than floor n/3 (8/3 = 2).
```

```
Input:  arr[] = [-5, 3, -5]
Output: [-5]
Explanation: The frequency of -5 is 2, which is more than floor n/3 (3/3 = 1).

```

```
Input:  arr[] = [3, 2, 2, 4, 1, 4]
Output: []
Explanation: There is no majority element.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-19T17:04:00.829Z  

```java
class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length;
        int count1 = 0, count2 = 0;
        int cand1 = Integer.MIN_VALUE, cand2 = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num == cand1) {
                count1++;
            } else if (num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if (count1 > n / 3) ans.add(cand1);
        if (count2 > n / 3) ans.add(cand2);

        Collections.sort(ans);
        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/majority-vote/1)