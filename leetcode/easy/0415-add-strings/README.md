# Add Strings

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two non-negative integers, `num1` and `num2` represented as string, return  *the sum of*  `num1`  *and*  `num2`  *as a string*.

You must solve the problem without using any built-in library for handling large integers (such as `BigInteger`). You must also not convert the inputs to integers directly.

 

 **Example 1:** 

```
Input: num1 = "11", num2 = "123"
Output: "134"

```

 **Example 2:** 

```
Input: num1 = "456", num2 = "77"
Output: "533"

```

 **Example 3:** 

```
Input: num1 = "0", num2 = "0"
Output: "0"

```

 

 **Constraints:** 

- 1 <= num1.length, num2.length <= 104
- num1 and num2 consist of only digits.
- num1 and num2 don't have any leading zeros except for the zero itself.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 94.60%)  
**Memory:** 43.2 MB (beats 91.90%)  
**Submitted:** 2026-11-03T15:49:43.291Z  

```java
class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int a = 0;
            int b = 0;

            if (i >= 0) {
                a = num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                b = num2.charAt(j) - '0';
                j--;
            }

            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/add-strings/)