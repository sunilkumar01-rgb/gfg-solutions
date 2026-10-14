# Search Pattern

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given two strings, a text string  **txt**  and a pattern string  **pat**, both consisting of lowercase English alphabets. Return the starting  **indices**  (0-based) of all the occurrences of the pattern string pat in the text string txt.

 **Note:** Return an empty list in case of no occurrences of pattern.

 **Examples:** 

```
Input: txt = "geeksforgeeks", pat = "geek"
Output: [0, 8]
Explanation: The string "geek" occurs twice in txt, one starts at index 0 and the other at index 8.

```

```
Input: txt = "abesdu", pat = "edu"
Output: []
Explanation: There's no substring "edu" present in txt.

```

```
Input: txt = "aabaacaadaabaaba", pat = "aaba"
Output: [0, 9, 12]
Explanation:

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-14T17:34:49.618Z  

```java
class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = txt.length(), m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            if (txt.substring(i, i + m).equals(pat)) {
                ans.add(i);
            }
        }

        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/search-pattern0205/1)