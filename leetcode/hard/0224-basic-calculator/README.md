# Basic Calculator

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string `s` representing a valid expression, implement a basic calculator to evaluate it, and return  *the result of the evaluation*.

 **Note:**  You are  **not**  allowed to use any built-in function which evaluates strings as mathematical expressions, such as `eval()`.

 

 **Example 1:** 

```
Input: s = "1 + 1"
Output: 2

```

 **Example 2:** 

```
Input: s = " 2-1 + 2 "
Output: 3

```

 **Example 3:** 

```
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

```

 

 **Constraints:** 

- 1 <= s.length <= 3 * 105
- s consists of digits, '+', '-', '(', ')', and ' '.
- s represents a valid expression.
- '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
- '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
- There will be no two consecutive operators in the input.
- Every number and running calculation will fit in a signed 32-bit integer.

## Solution

**Language:** Java  
**Runtime:** 12 ms (beats 39.81%)  
**Memory:** 45.8 MB (beats 96.05%)  
**Submitted:** 2026-11-06T17:11:45.219Z  

```java
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
        }
        if (number != 0) result += sign * number;
        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/basic-calculator/)