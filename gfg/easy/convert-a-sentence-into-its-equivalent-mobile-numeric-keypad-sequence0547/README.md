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
**Submitted:** 2026-10-26T17:31:34.733Z  

```java
class Solution {
    public String printSequence(String s) {
        String[] keypad = {
            "2", "22", "222",  // A, B, C
            "3", "33", "333",  // D, E, F
            "4", "44", "444",  // G, H, I
            "5", "55", "555",  // J, K, L
            "6", "66", "666",  // M, N, O
            "7", "77", "777", "7777", // P, Q, R, S
            "8", "88", "888",  // T, U, V
            "9", "99", "999", "9999" // W, X, Y, Z
        };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                result.append("0");
            } else {
                result.append(keypad[ch - 'A']);
            }
        }

        return result.toString();
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent-mobile-numeric-keypad-sequence0547/1)