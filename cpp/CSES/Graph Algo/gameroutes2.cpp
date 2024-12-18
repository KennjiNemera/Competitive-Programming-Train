#include <bits/stdc++.h>

using namespace std;

const int MAXN = 100001;
const int MOD = 1000000007;
vector<vector<pair<int, int>>> adj;
vector<int> topo;
bool vis[MAXN] = {0};
int deg[MAXN];

void dfs(int u, int v) {
    vis[u] = 1;
    for (pair<int, int> edge : adj[u])
    {
        if (!vis[edge.first] && edge.second) dfs(edge.first, u);
    }
    topo.push_back(u);
}

int main()
{
    int n, m;

    cin >> n >> m;

    adj.resize(n);

    for (int i = 0; i < m; i++)
    {
        int a, b;

        cin >> a >> b;

        a--;
        b--;

        adj[a].push_back(make_pair(b,1));
        adj[b].push_back(make_pair(a,0));
        deg[b] += 1;
    }

    // TOPO SORT
    for (int i = 0; i < n; i++)
    {
        if (!vis[i]) dfs(i, -1);
    }

    reverse(topo.begin(), topo.end());

    // PERFORM DP ON THE TOPOLOGICAL ORDERING

    long long dp[n] = {0};

    dp[0] = 1;

    for (int i = 0; i < n; i++)
    {
        for (pair<int, int> j : adj[topo[i]]) {
            if (j.second) continue;
            dp[topo[i]] += dp[j.first], dp[topo[i]] %= MOD;
        }
    }

    cout << dp[n-1] << endl;

    return 0;
}
