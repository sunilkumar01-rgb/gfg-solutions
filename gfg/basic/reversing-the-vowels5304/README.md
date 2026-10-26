# Reverse Vowels

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a string consisting of lowercase English alphabets, reverse only the vowels present in it and print the resulting string.

 **Examples:** 

```
Input: s = "geeksforgeeks"
Output: "geeksforgeeks"
Explanation: The vowels are: e, e, o, e, e. Reverse of these is also e, e, o, e, e.

```

```
Input: s = "practice"
Output: "prectica"
Explanation: The vowels are a, i, e. Reverse of these is e, i, a.

```

```
Input: s = "bcdfg"
Output: "bcdfg"
Explanation: There are no vowels in s.
```

 **Constraints:** 
1<=|s|<=105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-26T17:32:13.488Z  

```java
class Solution {
    String modify(String s) {
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left = 0, right = chars.length - 1;

        while (left < right) {
            if (vowels.indexOf(chars[left]) == -1) {
                left++;
            } else if (vowels.indexOf(chars[right]) == -1) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/reversing-the-vowels5304/1)