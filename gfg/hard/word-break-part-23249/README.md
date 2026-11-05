# Word Break Combinations

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string s and an array of strings dict[] containing valid words, return all possible sentences that can be formed by adding spaces in s such that:

- Every word of the sentence is present in dict[].
- A word of dict[] can be used any number of times. 

Return the sentences in any order, and return an empty list if no sentence is possible.

 **Examples:** 

```
Input: s = "likegfg", dict[] = ["lik", "like", "egfg", "gfg"]
Output: ["lik egfg", "like gfg"]
Explanation:
"likegfg" can be split as "lik" + "egfg", and both words are in the dictionary.
It can also be split as "like" + "gfg", and both words are in the dictionary.
No other split works. For example, after "lik" the rest is "egfg", which can only be matched by the single word "egfg", and after "like" the rest is "gfg", which can only be matched by "gfg".
```

```
Input: s = "geeksforgeeks", dict[] = ["for", "geeks"]
Output: ["geeks for geeks"]
Explanation: 
"geeksforgeeks" starts with "geeks", then "for" follows, then "geeks" again. 
The word "geeks" is used twice, which is allowed. This is the only valid way to split the string.
```

```
Input: s = "aaa", dict[] = ["a", "aa"]
Output: ["a a a", "a aa", "aa a"]
Explanation:
"a a a" uses the word "a" three times.
"a aa" uses "a" followed by "aa".
"aa a" uses "aa" followed by "a".
The whole string "aaa" is not in the dictionary, so it cannot be used as a single word.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T16:19:16.373Z  

```java
class Solution {
    public ArrayList<String> wordBreak(String[] dict, String s) {
        HashSet<String> set = new HashSet<>(Arrays.asList(dict));
        ArrayList<String>[] dp = new ArrayList[s.length() + 1];

        return solve(0, s, set, dp);
    }

    private ArrayList<String> solve(int index, String s,
                                    HashSet<String> set,
                                    ArrayList<String>[] dp) {

        if (dp[index] != null) {
            return dp[index];
        }

        ArrayList<String> ans = new ArrayList<>();

        if (index == s.length()) {
            ans.add("");
            return dp[index] = ans;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);

            if (set.contains(word)) {
                ArrayList<String> suffixes = solve(i, s, set, dp);

                for (String suffix : suffixes) {
                    if (suffix.isEmpty()) {
                        ans.add(word);
                    } else {
                        ans.add(word + " " + suffix);
                    }
                }
            }
        }

        return dp[index] = ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/word-break-part-23249/1)