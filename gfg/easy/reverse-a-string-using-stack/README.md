# Reverse Using Stack

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a string **s**, the task is to reverse the string using stack.

 **Examples:** 

```
Input: s ="GeeksforGeeks"
Output:  skeeGrofskeeG

```

```
Input: s ="Geek"
Output: keeG
```

 **Constraints:** 
1 ≤ s.length() ≤ 100

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-21T17:22:19.894Z  

```java
class Solution {
    public String reverse(String S) {
        char[] arr = S.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/reverse-a-string-using-stack/1)