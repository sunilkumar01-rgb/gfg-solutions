# Check for Isogram String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string  **s**  of lowercase alphabets, check if it is Isogram or not.  An Isogram is a string in which no letter occurs more than once.

 **Examples:** 

```
Input: s = "machine"
Output: true
Explanation: "machine" is an Isogram as no letter has appeared twice. so we return true.

```

```
Input: s = "geeks"
Output: false
Explanation: "geeks" is not an Isogram as 'e' appears twice. so we return false.
```

 **Constraints:** 
1 ≤ |s| ≤ 103

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-26T17:28:03.695Z  

```java
class Solution {
    static boolean isIsogram(String data) {
        boolean[] seen = new boolean[26];
        for (char c : data.toCharArray()) {
            if (seen[c - 'a']) return false;
            seen[c - 'a'] = true;
        }
        return true;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/check-if-a-string-is-isogram-or-not-1587115620/1)