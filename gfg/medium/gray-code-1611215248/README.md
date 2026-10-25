# Generate Gray Codes

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a number  **n**, generate n bit Gray codes. A Gray code sequence starts with a string of n zeros, and every consecutive Gray code in the sequence differs from the previous one by exactly one bit.
 
 **Examples:** 

```
Input: n = 2
Output: ["00", "01", "11", "10"]
Explanation: The sequence starts with 00, and every consecutive pair of codes differs by exactly one bit.
```

```
Input: n = 3
Output: ["000", "001", "011", "010", "110", "111", "101", "100"]
Explanation: The sequence starts with 000, and each consecutive Gray code differs from the previous one by exactly one bit.
```

 **Constraints :** 
1 ≤ n ≤ 16

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-25T17:30:32.255Z  

```java
class Solution {
    public ArrayList<String> generateGrayCodes(int n) {
        ArrayList<String> result = new ArrayList<>();
        int total = 1 << n;

        for (int i = 0; i < total; i++) {
            int gray = i ^ (i >> 1);
            result.add(String.format("%" + n + "s",
                    Integer.toBinaryString(gray)).replace(' ', '0'));
        }

        return result;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/gray-code-1611215248/1)