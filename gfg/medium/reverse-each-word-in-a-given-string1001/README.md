# Reverse Each Word in String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string  **s**, you need to reverse each word in it where the words are separated by spaces and return the modified string.

 **Note:** The string may contain leading or trailing spaces, or multiple spaces between two words. The returned string should only have a single space separating the words, and no extra spaces should be included.

 **Examples:** 

```
Input: s = " i like this program very much "
Output: "i ekil siht margorp yrev hcum"
Explanation: The words are reversed as follows:
"i" -> "i","like"->"ekil",
"this"->"siht","program" -> "margorp",
"very" -> "yrev","much" -> "hcum".
```

```
Input: s = " pqr mno "
Output: "rqp onm"
Explanation: The words are reversed as follows: "pqr" -> "rqp" and "mno" -> "onm"

```

```
Input: s = "pqr"
Output: "rqp"
Explanation: The words are reversed as follows: "pqr" -> "rqp"
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-20T17:33:02.808Z  

```java
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            ans.append(sb.reverse());

            if (i < words.length - 1) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/reverse-each-word-in-a-given-string1001/1)