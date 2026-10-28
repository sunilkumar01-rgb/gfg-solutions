# PascalCase Pattern Matching

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a dictionary of words `arr[]` where each word follows  **PascalCase notation**, print all words in the dictionary that match with a given pattern `pat` consisting of uppercase characters only.  **PascalCase**  is the practice of writing compound words or phrases such that each word or abbreviation begins with a capital letter.
i.e. PowerPoint, Wikipedia, GeeksForGeeks, CodeBlocks, etc.

A word matches the pattern if the sequence of its uppercase letters, when concatenated, forms a string that has `pat` as a prefix.

Note: The driver code will sort your answer before checking and return the answer in any order.

 **Examples:** 

```
Input: arr[] = ["WelcomeGeek", "WelcomeToGeeksForGeeks", "GeeksForGeeks"], pat = "WTG"
Output: ["WelcomeToGeeksForGeeks"]
Explanation: Since only "WelcomeToGeeksForGeeks" matches the pattern, it is the only answer.
```

```
Input: arr[] = ["Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab"], pat = "HA"
Output: []
Explanation: None of the words matches the given pattern.
```

 **Constraints:** 
1 ≤ arr.size() ≤ 1000
1 ≤ pat.size() ≤ 100
1 ≤ arr[i].size() ≤ 100

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-28T17:04:35.136Z  

```java
class Solution {
    public List<String> pascalCase(String[] arr, String pat) {
        List<String> ans = new ArrayList<>();

        for (String word : arr) {
            StringBuilder sb = new StringBuilder();

            // Word me se saare Uppercase letters nikaalo
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append(c);
                }
            }

            // Agar uppercase letters pattern se start hote hain, to add karo
            if (sb.toString().startsWith(pat)) {
                ans.add(word);
            }
        }

        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/camelcase-pattern-matching2259/1)