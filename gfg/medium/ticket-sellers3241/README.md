# Max Amount by Selling K Tickets

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array  **arr[]**, where  **arr[i]**  denotes the number of tickets available with the i-th ticket seller.

- The price of each ticket is equal to the number of tickets remaining with that seller at the time of sale.
- A seller can sell at most one ticket at a time, and after each sale, the price of the next ticket from that seller decreases by 1.
- At most k tickets can be sold in total.

Find the maximum amount that can be earned by selling at most k tickets. Return the answer modulo 10? + 7.

 **Examples:** 

```
Input: arr[] = [4, 3, 6, 2, 4], k = 3
Output: 15
Explanation: Sell two tickets from the seller with 6 tickets, priced at 6 and 5 respectively, and one ticket from a seller with 4 tickets, priced at 4. The maximum earning is 15.
```

```
Input: arr[] = [5, 3, 5, 2, 4, 4], k = 2
Output: 10
Explanation: Sell one ticket from each of the two sellers with 5 tickets. Both tickets are priced at 5, giving a maximum earning of 10.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T18:05:41.206Z  

```java
import java.util.*;

class Solution {
    public int maxAmount(int[] arr, int k) {
        long MOD = 1_000_000_007;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int tickets : arr) {
            maxHeap.add(tickets);
        }

        long total = 0;

        while (k > 0 && !maxHeap.isEmpty()) {
            int current = maxHeap.poll();
            total = (total + current) % MOD;

            if (current - 1 > 0) {
                maxHeap.add(current - 1);
            }
            k--;
        }

        return (int) total;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/ticket-sellers3241/1)