# Check Palindrome

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a string  **s**, you need to check if it is palindrome or not. A palidrome is a string that reads the same from front and back.

 **Note:**  Ignore the case in this question.

 **Examples:** 

```
Input: s = "Hello"
Output: false
Explanation: Hello is not equal to olleH so it's not a palindrome.
```

```
Input: s = "TenEt"
Output: true
Explanation: TenEt == tEneT as we are ignoring the case.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-12T17:25:22.153Z  

```java
class Solution {
    boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));

            if (l != r) return false;

            left++;
            right--;
        }

        return true;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/check-palindrome--141628/1)