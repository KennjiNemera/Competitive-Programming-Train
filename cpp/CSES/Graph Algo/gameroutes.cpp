#include <bits/stdc++.h>

using namespace std;

const int MAXN = 100001;
const int MOD = 1000000007;
vector<vector<pair<int, int>>> adj;
vector<int> topo;
bool vis[MAXN] = {0};
int deg[MAXN];

// TODO: Redo this algorithm with the original topo ordering approach. See what went wrong.

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

    // PERFORM DP ON THE TOPOLOGICAL ORDERING

    long long dp[n] = {0};

    queue<int> q;

    for (int i = 0; i < n; i++) 
    {
        if (!deg[i]) {
            q.push(i);
        }
    }

    while (!q.empty())
    {
    
        int cur = q.front();

        q.pop();

        topo.push_back(cur);

        for (pair<int, int> child : adj[cur]) 
        {
            if (child.second == 0) continue;

            deg[child.first]--;

            if (!deg[child.first]) q.push(child.first);
        }
    }

    for (int i = 0; i < n; i++)
    {
        cout << topo[i] << " ";
    }

    cout << endl;

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
