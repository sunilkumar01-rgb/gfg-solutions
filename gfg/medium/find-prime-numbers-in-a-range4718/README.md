# Primes in a Range

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two integers **l**  and  **r**, find and return all prime numbers in the range  **[l, r]**  (inclusive).

 **Examples:** 

```
Input: l = 1, r = 10
Output: [2, 3, 5, 7]
Explanation:
The prime numbers between 1 and 10 are 2, 3, 5 and 7.
```

```
Input: l = 2, r = 5
Output: [2, 3, 5]
Explanation:
The prime numbers between 2 and 5 are 2, 3 and 5.
```

 **Constraints:** 
1≤ l ≤ r ≤ 106

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-19T17:01:50.745Z  

```java
class Solution {
    public List<Integer> primeRange(int l, int r) {
        List<Integer> ans = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            if (isPrime(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-prime-numbers-in-a-range4718/1)