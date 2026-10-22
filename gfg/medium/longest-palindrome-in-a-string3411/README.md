# Longest Palindrome in String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string s, your task is to find the longest palindromic substring within s. If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.

 **Examples :** 

```
Input: s = “forgeeksskeegfor” 
Output: “geeksskeeg”
Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.
```

```
Input: s = “Geeks” 
Output: “ee”
Explanation: "ee" is the longest palindromic substring of "Geeks". 
```

```
Input: s = “abc” 
Output: “a”
Explanation: "a", "b" and "c" are longest palindromic substrings of same length. So, the first occurrence is returned.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-22T16:28:27.948Z  

```java
class Solution {
    static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {

            // Odd-length palindrome
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    start = left;
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }

            // Even-length palindrome
            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    start = left;
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }
        }

        return s.substring(start, start + maxLength);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1)