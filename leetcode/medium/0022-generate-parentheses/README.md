# Generate Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given `n` pairs of parentheses, write a function to  *generate all combinations of well-formed parentheses*.

 

Original
Java
 **Example 1:** 

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

```

 **Example 2:** 

```
Input: n = 1
Output: ["()"]

```

 

 **Constraints:** 

- 1 <= n <= 8

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 18.16%)  
**Memory:** 44.4 MB (beats 58.50%)  
**Submitted:** 2026-11-25T17:18:09.999Z  

```java
import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    
    private void backtrack(List<String> ans, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            ans.add(current);
            return;
        }
        if (open < max) {
            backtrack(ans, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, current + ")", open, close + 1, max);
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/generate-parentheses/)