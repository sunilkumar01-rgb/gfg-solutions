# String Rotation Check

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two strings  **s1** and  **s2**, of equal lengths. The task is to check if  **s2**  is a rotated version of the string  **s1**.

 **Note:**  A string is a rotation of another if it can be formed by moving characters from the start to the end (or vice versa) without rearranging them.

 **Examples :** 

```
Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: After 2 right rotations, s1 will become equal to s2.

```

```
Input: s1 = "aab", s2 = "aba"
Output: true
Explanation: After 1 left rotation, s1 will become equal to s2.
```

```
Input: s1 = "abcd", s2 = "acbd"
Output: false
Explanation: Strings are not rotations of each other.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-20T17:35:50.343Z  

```java
class Solution {
    public boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String text = s1 + s1;
        String pattern = s2;
        int n = text.length();
        int m = pattern.length();

        // KMP Algorithm for Pattern Searching
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        i = 0; // index for text
        int j = 0; // index for pattern
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                return true; // Pattern found
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1)