# Longest Valid Parentheses Substring

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string  **s**  consisting of opening and closing parenthesis ' **(** ' and ' **)** '. Find the length of the longest valid parenthesis substring.

A parenthesis string is valid if:

- For every opening parenthesis, there is a closing parenthesis.
- The closing parenthesis must be after its opening parenthesis.

 **Examples :** 

```
Input: s = "((()"
Output: 2
Explanation: The longest valid parenthesis substring is "()".
```

```
Input: s = ")()())"
Output: 4
Explanation: The longest valid parenthesis substring is "()()".
```

```
Input: s = "())()"
Output: 2
Explanation: The longest valid parenthesis substring is "()".
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-25T17:21:26.756Z  

```java
class Solution {
    static int maxLength(String s) {
        int left = 0, right = 0;
        int maxLen = 0;
        int n = s.length();

        // Left to Right pass
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0; 
        right = 0;

        // Right to Left pass (Handle cases like "(()")
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxLen;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/longest-valid-parentheses5657/1)