# Generate IP Addresses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string  **s**  containing only digits, your task is to restore it by returning all possible valid IP address combinations. You can return your answer in  **any** order.

A  **valid**  IP address must be in the form of A.B.C.D, where A, B, C, and D are numbers from 0-255(inclusive).

 **Note:** The numbers cannot be 0 prefixed unless they are 0. For example, 1.1.2.11 and 0.11.21.1 are valid IP addresses while 01.1.2.11 and 00.11.21.1 are not.
If there are no possible valid IP address return an empty list. The driver code will print -1 in this case.

 **Examples:** 

```
Input: s = “255678166”
Output: [“25.56.78.166”, “255.6.78.166”, “255.67.8.166”, “255.67.81.66”]
Explanation: These are the only valid possible IP addresses.
```

```
Input: s = “25505011535”
Output: []
Explanation: We cannot generate a valid IP address with this string.
```

 **Constraints:** 
1 ≤ s.size() ≤ 16
s contains only digits(i.e. 0-9)

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-26T16:58:16.884Z  

```java
import java.util.ArrayList;

class Solution {
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> ans = new ArrayList<>();
        // Minimum 4 digits (0.0.0.0) aur max 12 digits (255.255.255.255) chahiye
        if (s.length() < 4 || s.length() > 12) return ans;

        backtrack(s, 0, 0, "", ans);
        return ans;
    }

    private void backtrack(String s, int index, int dots, String current, ArrayList<String> ans) {
        // Jab 3 dots lag jayein, toh aakhri part bachega
        if (dots == 3) {
            String lastPart = s.substring(index);
            // Check karo ki aakhri part valid hai ya nahi
            if (isValid(lastPart)) {
                ans.add(current + lastPart);
            }
            return;
        }

        // Ek part me 1 se 3 character tak ho sakte hain
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String part = s.substring(index, index + i);
            if (isValid(part)) {
                // Part valid hai, toh dot lagakar aage badho
                backtrack(s, index + i, dots + 1, current + part + ".", ans);
            }
        }
    }

    private boolean isValid(String part) {
        // Empty string check (Runtime Error se bachne ke liye)
        if (part.length() == 0) return false;

        // Leading zero allowed nahi hai (jaise "01" ya "00")
        if (part.length() > 1 && part.charAt(0) == '0') return false;

        // Value 0 se 255 ke beech honi chahiye
        int val = Integer.parseInt(part);
        return val >= 0 && val <= 255;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1)