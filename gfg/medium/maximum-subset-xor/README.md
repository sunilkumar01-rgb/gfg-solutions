# Maximum Subset XOR

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**, choose any subset of elements (possibly all elements) such that the XOR of the chosen elements is maximized.

 **Examples:** 

```
Input : arr[] = [2, 4, 5]
Output: 7
Explanation: The subset {2, 5} has the maximum XOR value.
```

```
Input : arr[] = [9, 8, 5]
Output: 13
Explanation: The subset {8, 5} has the maximum XOR value.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-18T06:36:56.333Z  

```java
class Solution {
    public static int maxSubsetXOR(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int index = 0;

        for (int bit = 31; bit >= 0; bit--) {
            int maxIndex = index;
            for (int i = index; i < n; i++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    maxIndex = i;
                    break;
                }
            }

            if (index >= n || (arr[maxIndex] & (1 << bit)) == 0) {
                continue;
            }

            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;

            for (int i = 0; i < n; i++) {
                if (i != index && (arr[i] & (1 << bit)) != 0) {
                    arr[i] = arr[i] ^ arr[index];
                }
            }

            index++;
        }

        for (int i = 0; i < index; i++) {
            ans = Math.max(ans, ans ^ arr[i]);
        }

        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/maximum-subset-xor/1)