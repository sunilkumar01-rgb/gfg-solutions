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