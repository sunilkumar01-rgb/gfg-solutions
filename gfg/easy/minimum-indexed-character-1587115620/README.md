# Minimum Indexed Character

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings  **s1**  and  **s2** containing lowercase English letters, return the  **smallest**  index of a character in s1 that is also present in s2. If no common character exists between the two strings, return -1.

 **Examples :** 

```
Input: s1 = "geeksforgeeks", s2 = "set"
Output: 1
Explanation: The character 'e' is present in both s1 and s2. Its first occurrence in s1 is at index 1, which is the minimum such index.

```

```
Input: s1 = "geeks", s2 = "hop"
Output: -1
Explanation: There is no character that is common to both s1 and s2. Hence, the answer is -1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-22T16:35:24.298Z  

```java

class Solution {
    public static int minIndexChar(String str, String patt) {
        boolean[] present = new boolean[Character.MAX_VALUE + 1];

        for (int i = 0; i < patt.length(); i++) {
            present[patt.charAt(i)] = true;
        }

        for (int i = 0; i < str.length(); i++) {
            if (present[str.charAt(i)]) {
                return i;
            }
        }

        return -1;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-indexed-character-1587115620/1)