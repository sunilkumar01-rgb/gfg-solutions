# Replace Words

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In English, we have a concept called  **root**, which can be followed by some other word to form another longer word - let's call this word  **derivative**. For example, when the  **root**  `"help"` is followed by the word `"ful"`, we can form a derivative `"helpful"`.

Given a `dictionary` consisting of many  **roots**  and a `sentence` consisting of words separated by spaces, replace all the derivatives in the sentence with the  **root**  forming it. If a derivative can be replaced by more than one  **root**, replace it with the  **root**  that has  **the shortest length**.

Return  *the `sentence`*  after the replacement.

 

Original
Java
 **Example 1:** 

```
Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

```

 **Example 2:** 

```
Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"

```

 

 **Constraints:** 

- 1 <= dictionary.length <= 1000
- 1 <= dictionary[i].length <= 100
- dictionary[i] consists of only lower-case letters.
- 1 <= sentence.length <= 106
- sentence consists of only lower-case letters and spaces.
- The number of words in sentence is in the range [1, 1000]
- The length of each word in sentence is in the range [1, 1000]
- Every two consecutive words in sentence will be separated by exactly one space.
- sentence does not have leading or trailing spaces.

## Solution

**Language:** Java  
**Runtime:** 12 ms (beats 69.07%)  
**Memory:** 65.4 MB (beats 29.94%)  
**Submitted:** 2026-11-21T17:43:28.018Z  

```java
class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        
        // Build Trie
        for (String word : dictionary) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }
        
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(findRoot(word, root));
        }
        return sb.toString();
    }
    
    private String findRoot(String word, TrieNode root) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return word; // No root found
            }
            curr = curr.children[c - 'a'];
            if (curr.word != null) {
                return curr.word; // Found shortest root
            }
        }
        return word;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/replace-words/)