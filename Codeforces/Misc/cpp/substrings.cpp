#include <bits/stdc++.h>

using namespace std;

#define pb push_back
#define f first
#define s second
#define mp make_pair

const int MAXN = 300001;
vector<vector<pair<int, int>>> adj;
int in[MAXN];
bool possible = 1;
vector<int> topo(MAXN);
bool vis[MAXN];
int dp[MAXN][26];

int main()
{

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, m;

    cin >> n >> m;

    string s;

    cin >> s;

    adj.resize(n);

    for (int i = 0; i < m; i++)
    {
        int a,b;

        cin >> a >> b;

        a--;
        b--;

        in[b]++;
        adj[a].pb({b, 1});
        adj[b].pb({a, 0});
    }

    queue<int> q;
    int count = 0;

    for (int i = 0; i < n; i++)
    {
        if (!in[i]) {
           q.push(i);
           dp[i][s[i] - 'a'] = 1;
           count++;
        } 
    }

    int ans = 0;

    // take note of the mem condition as it may cause errors...
    while (!q.empty())
    {
        int cur = q.front();
        q.pop();

        for (pair<int, int> edge : adj[cur])
        {
            if (!edge.s) continue;

            in[edge.f]--;

            for (int i = 0; i < 26; i++)
            {
                int temp = (s[edge.f] - 'a' == i);
                dp[edge.f][i] = max(dp[cur][i] + temp, dp[edge.f][i]);
            }

            if (!in[edge.f]) {
                count++;
                q.push(edge.f);
            }
        }
    }
 
    for (int i = 0; i < n; i++) for (int j = 0; j < 26; j++) ans = max(ans, dp[i][j]);

    if (count == n) {
        cout << ans << "\n";
    } else cout << "-1\n";

    return 0;
}
