# Leap Year

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

You are given an Integer  **n**. Return  **true** if It is a Leap Year otherwise return  **false**.

 **Examples:** 

```
Input: n = 4
Output: true
Explanation: 4 is not divisible by 100 and is divisible by 4 so its a leap year
```

```
Input: n = 2021
Output: false
Explanation: 2021 is not divisible by 100 and is also not divisible by 4 so its not a leap year
```

 **Constraints:** 
1<= n < 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-07T09:31:47.248Z  

```java
class Solution {
    static boolean checkYear(int n) {
        // code here
        if(n%400==0 || (n%4==0 && n%100!=0))
        return true;
        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/leap-year0943/1)