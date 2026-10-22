# All String Permutations in Sorted Order

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string  **s**. Find all permutations  of a given string. Return the permutations in lexicographically non-decreasing order.

 **Examples :** 

```
Input: s = "AA"
Output: ["AA", "AA"]
Explanation: There are total 2 permutations, as given in the output.

```

```
Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: There are total 6 permutations, as given in the output.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-22T16:32:41.653Z  

```java
import java.util.*;

class Solution {
    public ArrayList<String> permutation(String s) {
        ArrayList<String> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        char[] arr = s.toCharArray();
        generate(arr, 0, result);

        Collections.sort(result);
        return result;
    }

    private void generate(char[] arr, int index,
                          ArrayList<String> result) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);

            generate(arr, index + 1, result);

            swap(arr, index, i);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string-1587115620/1)