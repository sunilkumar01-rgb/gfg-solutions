# Max Gap Between Two Same

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string **s**  consisting of lowercase English letters, find the maximum number of characters between any two identical characters. If no character repeats, return  **-1**.

 **Examples :** 

```
Input: s = "socks"
Output: 3
Explanation: There are 3 characters between the two occurrences of 's'.

```

```
Input: s = "for"
Output: -1
Explanation: No repeating character present.

```

 **Constraints:** 
1 ≤ |s| ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-06T18:29:14.138Z  

```java
class Solution {
    public int maxCharGap(String s) {
        HashMap<Character, Integer> first = new HashMap<>();
        int maxGap = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first.containsKey(c)) {
                maxGap = Math.max(maxGap, i - first.get(c) - 1);
            } else {
                first.put(c, i);
            }
        }

        return maxGap;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/maximum-number-of-characters-between-any-two-same-character4552/1)