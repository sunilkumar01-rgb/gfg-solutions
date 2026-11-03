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