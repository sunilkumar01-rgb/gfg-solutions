# Maximum Profit in Job Scheduling

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

We have `n` jobs, where every job is scheduled to be done from `startTime[i]` to `endTime[i]`, obtaining a profit of `profit[i]`.

You're given the `startTime`, `endTime` and `profit` arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time `X` you will be able to start another job that starts at time `X`.

 

 **Example 1:** 

```
Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6], we get profit of 120 = 50 + 70.

```

 **Example 2:** 

```
Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.

```

 **Example 3:** 

```
Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6

```

 

 **Constraints:** 

- 1 <= startTime.length == endTime.length == profit.length <= 5 * 104
- 1 <= startTime[i] < endTime[i] <= 109
- 1 <= profit[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 30 ms (beats 84.70%)  
**Memory:** 66.8 MB (beats 78.00%)  
**Submitted:** 2026-10-29T16:24:31.642Z  

```java
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]); // Sort by end time
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        
        for (int i = 1; i < n; i++) {
            int include = jobs[i][2];
            int low = 0, high = i - 1, lastCompatible = -1;
            
            // Find the latest job that ends before current job starts
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (jobs[mid][1] <= jobs[i][0]) {
                    lastCompatible = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            if (lastCompatible != -1) include += dp[lastCompatible];
            dp[i] = Math.max(dp[i - 1], include);
        }
        return dp[n - 1];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-profit-in-job-scheduling/)