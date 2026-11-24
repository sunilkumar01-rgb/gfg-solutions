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
**Submitted:** 2026-11-24T16:50:48.560Z  

```java
import java.util.*;

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        String concat = pat + "$" + txt;
        int n = concat.length();
        int[] Z = new int[n];

        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && concat.charAt(R - L) == concat.charAt(R)) R++;
                Z[i] = R - L;
                R--;
            } else {
                int k = i - L;
                if (Z[k] < R - i + 1) Z[i] = Z[k];
                else {
                    L = i;
                    while (R < n && concat.charAt(R - L) == concat.charAt(R)) R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (Z[i] == pat.length()) {
                ans.add(i - pat.length() - 1); // 0-based indexing
            }
        }
        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/search-pattern0205/1)