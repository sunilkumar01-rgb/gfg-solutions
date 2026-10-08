# Consecutive Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

The  **power**  of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string `s`, return  *the  **power**  of*  `s`.

 

 **Example 1:** 

```
Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.

```

 **Example 2:** 

```
Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.

```

 

 **Constraints:** 

- 1 <= s.length <= 500
- s consists of only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 100.00%)  
**Memory:** 43 MB (beats 97.85%)  
**Submitted:** 2026-10-08T13:54:35.001Z  

```java
class Solution {
    public int maxPower(String s) {
        int max = 1, current = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                current++;
                max = Math.max(max, current);
            } else {
                current = 1;
            }
        }
        
        return max;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/consecutive-characters/)