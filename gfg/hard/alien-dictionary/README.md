# Alien Dictionary

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

An alien language uses the lowercase English alphabet, but the order of its letters is unknown. You are given an array of strings  **words[]**  that is claimed to be sorted lexicographically according to the rules of the alien language.

Determine the order of the letters in the alien alphabet.

- If a valid ordering exists, return a string containing all unique letters in lexicographical order according to the alien language.
- Otherwise, return an empty string.

If a string s1 is lexicographically smaller than a string s2, and the first position at which they differ contains letter a in s1 and letter b in s2, then a must appear before b in the alien alphabet.
If one word is a prefix of the other, the shorter word must appear before the longer word.

 **Note:**  The driver code prints true if the returned order is valid; otherwise, it prints false.

 **Examples:** 

```
Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
Output: true
Explanation: A possible correct order of letters in the alien dictionary is "bdac".
The pair "baa" and "abcd" suggests 'b' appears before 'a' in the alien dictionary.
The pair "abcd" and "abca" suggests 'd' appears before 'a' in the alien dictionary.
The pair "abca" and "cab" suggests 'a' appears before 'c' in the alien dictionary.
The pair "cab" and "cad" suggests 'b' appears before 'd' in the alien dictionary.
So, 'b' -> 'd' -> 'a' -> 'c' is a valid ordering.
```

```
Input: words[] = ["caa", "aaa", "aab"]
Output: true
Explanation: A possible correct order of letters in the alien dictionary is "cab".
The pair "caa" and "aaa" suggests 'c' appears before 'a'.
The pair "aaa" and "aab" suggests 'a' appear before 'b' in the alien dictionary. 
So, 'c' -> 'a' -> 'b' is a valid ordering.
```

```
Input: words[] = ["ab", "cd", "ef", "ad"]
Output: ""
Explanation: No valid ordering of letters is possible.
The pair "ab" and "ef" suggests "a" appears before "e".
The pair "ef" and "ad" suggests "e" appears before "a", which contradicts the ordering rules.
```

**Constraints:
**1 ≤ words.size() * words[i].size()  ≤ 106
words[i] consists only of lowercase English letters.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-03T18:57:15.703Z  

```cpp
class Solution {
  public:
    string findOrder(vector<string> &words) {
        int N = words.size();
        vector<vector<int>> adj(26);
        vector<int> indegree(26, 0);
        vector<bool> present(26, false);

        for (string &word : words) {
            for (char ch : word) {
                present[ch - 'a'] = true;
            }
        }

        for (int i = 0; i < N - 1; i++) {
            string s1 = words[i];
            string s2 = words[i + 1];

            int len = min(s1.size(), s2.size());
            bool found = false;

            for (int j = 0; j < len; j++) {
                if (s1[j] != s2[j]) {
                    int u = s1[j] - 'a';
                    int v = s2[j] - 'a';

                    adj[u].push_back(v);
                    indegree[v]++;
                    found = true;
                    break;
                }
            }

            if (!found && s1.size() > s2.size()) {
                return "";
            }
        }

        queue<int> q;

        for (int i = 0; i < 26; i++) {
            if (present[i] && indegree[i] == 0) {
                q.push(i);
            }
        }

        string ans = "";

        while (!q.empty()) {
            int u = q.front();
            q.pop();

            ans += char(u + 'a');

            for (int v : adj[u]) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    q.push(v);
                }
            }
        }

        int total = 0;
        for (int i = 0; i < 26; i++) {
            if (present[i]) total++;
        }

        if (ans.size() != total) {
            return "";
        }

        return ans;
    }
};
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/alien-dictionary/1)