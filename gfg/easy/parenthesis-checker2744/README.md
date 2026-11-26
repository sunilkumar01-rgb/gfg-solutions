# Parenthesis Checker

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string  **s**, composed of different combinations of '(', ')', '{', '}', '[', ']'. Determine whether the Expression is  **balanced** or not.
An expression is balanced if:

- Each opening bracket has a corresponding closing bracket of the same type.
- Opening brackets must be closed in the correct order.

 **Examples :** 

```
Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.
```

```
Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed.

```

```
Input: s = "([]"
Output: false
Explanation: The expression is not balanced as there is a missing ')' at the end.

```

```
Input: s = "([{]})"
Output: false
Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-26T16:45:29.770Z  

```java
import java.util.Stack;

class Solution {
    public boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1)