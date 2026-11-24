# Task Scheduler

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array of CPU `tasks`, each labeled with a letter from A to Z, and a number `n`. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of  **at least**  `n` intervals between two tasks with the same label.

Return the  **minimum**  number of CPU intervals required to complete all tasks.

 

Original
Java
 **Example 1:** 

 **Input:**  tasks = ["A","A","A","B","B","B"], n = 2

 **Output:**  8

 **Explanation:**  A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

 **Example 2:** 

 **Input:**  tasks = ["A","C","A","B","D","B"], n = 1

 **Output:**  6

 **Explanation:**  A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

 **Example 3:** 

 **Input:**  tasks = ["A","A","A", "B","B","B"], n = 3

 **Output:**  10

 **Explanation:**  A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.

 

 **Constraints:** 

- 1 <= tasks.length <= 104
- tasks[i] is an uppercase English letter.
- 0 <= n <= 100

## Solution

**Language:** Java  
**Runtime:** 28 ms (beats 36.89%)  
**Memory:** 48.2 MB (beats 32.69%)  
**Submitted:** 2026-11-24T16:51:19.543Z  

```java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.add(f);
        }
        
        int time = 0;
        while (!pq.isEmpty()) {
            int interval = n + 1;
            List<Integer> temp = new ArrayList<>();
            
            while (interval > 0 && !pq.isEmpty()) {
                temp.add(pq.poll());
                interval--;
            }
            
            for (int f : temp) {
                if (f - 1 > 0) pq.add(f - 1);
            }
            
            time += temp.size() + (pq.isEmpty() ? 0 : interval);
        }
        
        return time;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/task-scheduler/)