# Position of Only Set Bit

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer  **n**, determine position of the  **only set bit** (1) in its binary representation. The position is counted starting from 1 at the least significant bit (LSB).

- If n contains exactly one set bit, return its position.
- If n contains no set bits or more than one set bit, return -1.

 **Examples:** 

```
Input: n = 2
Output: 2
Explanation: 2 is represented as "10" in binary. It has only one set bit, which is at position 2.

```

```
Input: n = 5
Output: -1
Explanation: 5 is represented as "101" in binary. It has two set bits; therefore, the output is -1.

```

 **Constraints:** 
0 ≤ n ≤ 108

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-17T17:28:32.961Z  

```java
class Solution {
    static int findPosition(int N) {
        // Agar N 0 hai, ya N me ek se zyada set bits hain
        if (N == 0 || (N & (N - 1)) != 0) {
            return -1;
        }

        int pos = 1;
        while (N > 0) {
            if ((N & 1) == 1) {
                return pos;
            }
            N >>= 1;
            pos++;
        }
        return -1;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1)