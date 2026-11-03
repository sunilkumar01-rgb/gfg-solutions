class Solution {
  public:
    int primMST(vector<vector<vector<int>>> &adj) {
        int V = adj.size();

        vector<int> key(V, INT_MAX);
        vector<bool> mst(V, false);

        priority_queue<
            pair<int, int>,
            vector<pair<int, int>>,
            greater<pair<int, int>>
        > pq;

        key[0] = 0;
        pq.push({0, 0});

        int sum = 0;

        while (!pq.empty()) {
            int wt = pq.top().first;
            int u = pq.top().second;
            pq.pop();

            if (mst[u]) continue;

            mst[u] = true;
            sum += wt;

            for (auto it : adj[u]) {
                int v = it[0];
                int weight = it[1];

                if (!mst[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.push({weight, v});
                }
            }
        }

        return sum;
    }
};