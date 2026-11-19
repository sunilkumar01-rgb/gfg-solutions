# Smallest Sufficient Team

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

In a project, you have a list of required skills `req_skills`, and a list of people. The `ith` person `people[i]` contains a list of skills that the person has.

Consider a sufficient team: a set of people such that for every required skill in `req_skills`, there is at least one person in the team who has that skill. We can represent these teams by the index of each person.

- For example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].

Return  *any sufficient team of the smallest possible size, represented by the index of each person*. You may return the answer in  **any order**.

It is  **guaranteed**  an answer exists.

 

Original
Java
 **Example 1:** 

```
Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
Output: [0,2]

```

 **Example 2:** 

```
Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
Output: [1,2]

```

 

 **Constraints:** 

- 1 <= req_skills.length <= 16
- 1 <= req_skills[i].length <= 16
- req_skills[i] consists of lowercase English letters.
- All the strings of req_skills are unique.
- 1 <= people.length <= 60
- 0 <= people[i].length <= 16
- 1 <= people[i][j].length <= 16
- people[i][j] consists of lowercase English letters.
- All the strings of people[i] are unique.
- Every skill in people[i] is a skill in req_skills.
- It is guaranteed a sufficient team exists.

## Solution

**Language:** Java  
**Runtime:** 19 ms (beats 72.48%)  
**Memory:** 44.7 MB (beats 82.17%)  
**Submitted:** 2026-11-19T16:02:53.848Z  

```java
class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int target = (1 << n) - 1;
        HashMap<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillMap.put(req_skills[i], i);
        }
        
        int[] peopleMask = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int mask = 0;
            for (String skill : people.get(i)) {
                mask |= (1 << skillMap.get(skill));
            }
            peopleMask[i] = mask;
        }
        
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int[] parent = new int[1 << n];
        int[] parentPerson = new int[1 << n];
        Arrays.fill(parent, -1);
        
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == Integer.MAX_VALUE) continue;
            for (int i = 0; i < people.size(); i++) {
                int nextMask = mask | peopleMask[i];
                if (nextMask != mask && dp[mask] + 1 < dp[nextMask]) {
                    dp[nextMask] = dp[mask] + 1;
                    parent[nextMask] = mask;
                    parentPerson[nextMask] = i;
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int curr = target;
        while (curr != 0) {
            ans.add(parentPerson[curr]);
            curr = parent[curr];
        }
        
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/smallest-sufficient-team/)