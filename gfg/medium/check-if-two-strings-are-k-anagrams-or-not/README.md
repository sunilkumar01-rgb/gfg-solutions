# k-Anagram

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two strings  **s1**  and  **s2**  consisting of lowercase English alphabets, and an integer value  **k**, return  **true**  if two strings are k-anagrams of each other. Otherwise, return  **false**.

Two strings are called k-anagrams if both of the below conditions are true.

- Both have same number of characters.
- Two strings can become anagram by changing at most k characters in a string.

 **Example:** 

```
Input: s1 = "fodr", s2 = "gork", k = 2
Output: true
Explanation: We can change 'f' -> 'g' and 'd' -> 'k' in s1.
```

```
Input: s1 = "geeks", s2 = "eggkf", k = 1
Output: false
Explanation: We can update or modify only 1 value but there is a need of modifying 2 characters i.e. 'g' and 'f' in s2.
```

```
Input: s1 = "adb", s2 = "fdab", k = 2
Output: false
Explanation: Both the strings have different numbers of characters.
```

 **Constraints:** 
1 ≤ s1.size(), s2.size() ≤ 105
1 ≤ k ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-28T17:02:11.632Z  

```java
class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        if (s1.length() != s2.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) diff += count[i];
        }

        return diff <= k;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not/1)