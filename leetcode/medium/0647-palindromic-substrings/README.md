# Palindromic Substrings

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, return  *the number of  **palindromic substrings**  in it*.

A string is a  **palindrome**  when it reads the same backward as forward.

A  **substring**  is a contiguous sequence of characters within the string.

 

 **Example 1:** 

```
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

```

 **Example 2:** 

```
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

```

 

 **Constraints:** 

- 1 <= s.length <= 1000
- s consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 62.52%)  
**Memory:** 42.8 MB (beats 80.34%)  
**Submitted:** 2026-10-13T17:13:06.777Z  

```java
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);
            count += expand(s, i, i + 1);
        }
        return count;
    }
    
    private int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindromic-substrings/)