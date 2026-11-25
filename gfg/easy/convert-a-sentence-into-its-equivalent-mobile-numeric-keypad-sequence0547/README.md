# Sentence to Mobile Numeric Sequence

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a sentence  **s**  consisting of uppercase English alphabets and spaces, convert it into its equivalent mobile numeric keypad sequence. For each character, press the corresponding keypad key as many times as its position on that key. For a space, press 0 once.

 **Note:** s contains only uppercase English alphabets (A-Z) and spaces.

 **Examples:** 

```
Input: s = "GFG"
Output: 43334
Explanation: For 'G', press '4' one time. For 'F', press '3' three times. For the second 'G', press '4' one time.

```

```
Input: s = "HEY U"
Output: 4433999088
Explanation: For 'H', press '4' two times. For 'E', press '3' two times. For 'Y', press '9' three times. For the space, press '0' one time. For 'U', press '8' two times.s contains only uppercase English alphabets (A-Z) and spaces.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-25T17:23:34.323Z  

```java
class Solution {
    String printSequence(String S) {
        String[] str = {"2", "22", "222", "3", "33", "333", "4", "44", "444", 
                        "5", "55", "555", "6", "66", "666", "7", "77", "777", "7777", 
                        "8", "88", "888", "9", "99", "999", "9999"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ' ') {
                sb.append("0");
            } else {
                sb.append(str[S.charAt(i) - 'A']);
            }
        }
        return sb.toString();
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent-mobile-numeric-keypad-sequence0547/1)