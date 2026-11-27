# Implement Trie

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Implement the  **Trie**  class with the following functions:

- insert(word): Inserts the string word into the trie.
- search(word): Returns true if word exists in the trie; otherwise returns false.
- isPrefix(word): Returns true if word is a prefix of at least one string stored in the trie; otherwise returns false.

For input, the driver uses a 2D array  **query[][]**, where each query is one of the following:

- Type 1: [1, word] -> Calls insert(word).
- Type 2: [2, word] -> Calls search(word) and stores the returned value.
- Type 3: [3, word] -> Calls isPrefix(word) and stores the returned value.

The output consists of the results of all Type 2 and Type 3 queries in the order they are processed.

 **Examples :** 

```
Input: query[][] = [[1, "abcd"], [1, "abc"], [1, "bcd"], [2, "bc"], [3, "bc"], [2, "abc"]]
Output: [false, true, true]
Explanation: string "bc" does not exist in the trie, "bc" exists as prefix of the word "bcd" in the trie, and "abc" also exists in the trie.
```

```
Input: query[][] = [[1, "gfg"], [1, "geeks"], [3, "fg"], [3, "geek"], [2, "for"]]
Output: [false, true, false]
Explanation: The string "for" is not present in the trie, "fg" is not a valid prefix, while "geek" is a valid prefix of the word "geeks" in the trie.
```

**Constraints:
**1 ≤ query.size() ≤ 104
1 ≤ word.size() ≤ 103

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-27T18:12:34.667Z  

```java
class Trie {
    private TrieNode root;

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }

    public boolean isPrefix(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/trie-insert-and-search0651/1)