# Power Set

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a string. You need to return the power set (in any order) of the string.

 **Examples:** 

```
Input: s = a
Output: ["","a"]
Explanation: empty string and "a" are only sets.
```

```
Input: s = abc
Output: ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Explanation: empty string, a, ab, abc, ac, b, bc, c are the sets.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T13:16:47.019Z  

```java
class Solution {
    public ArrayList<String> powerSet(String s) {

        ArrayList<String> result = new ArrayList<>();

        int n = s.length();

        int total = 1 << n;

        for (int i = 0; i < total; i++) {

            StringBuilder sub = new StringBuilder();

            for (int j = 0; j < n; j++) {

                if ((i & (1 << j)) != 0) {
                    sub.append(s.charAt(j));
                }
            }

            result.add(sub.toString());
        }

        Collections.sort(result);

        return result;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/power-set-using-recursion/1)