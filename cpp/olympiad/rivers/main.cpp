#include <bits/stdc++.h>

using namespace std;

#define pb push_back
#define pi pair<int, int>
#define f first
#define s second
const int MAXN = 110, MAXK = 51;

int dist[MAXN], TreeSum[MAXN], start[MAXN], point[MAXN], DP[MAXN][MAXN][MAXK], DIFF[MAXN][MAXN];
vector<pair<int, int>> tree[MAXN];
int maxCost;

void gen(int cur, int d)
{
    dist[cur] = d;
    
    for (int i = 0; i < tree[cur].size(); i++)
    {
        pi ci = tree[cur][i];
        gen(ci.f, d + ci.s);
        TreeSum[cur] += TreeSum[ci.f];
        maxCost += TreeSum[ci.f] * ci.s;
    }

    if (tree[cur].size()) start[cur] = tree[cur][0].f;
    for (int i = 1; i < tree[cur].size(); i++) point[tree[cur][i - 1].f] = tree[cur][i].f;
}

int recur(int i, int j, int k)
{
    if (!i || !k) return 0;

    if (!DP[i][j][k])
    {
        int ans = 0;

        for (int mills = 0; mills < k; mills++)
        {
            ans = max(ans, recur(start[i], i, mills) + recur(point[i], j, k - mills - 1)); 
        }

        ans += DIFF[i][j];

        for (int mills = 0; mills <= k; mills++)
        {
            ans = max(ans, recur(start[i], j, mills) + recur(point[i], j, k - mills));
        }

        DP[i][j][k] = ans;
    }

    return DP[i][j][k];
}

void solve()
{
    // good luck big guy

    int n, k;

    cin >> n >> k;

    for (int i = 1; i <= n; i++)
    {
        int next, d;

        cin >> TreeSum[i] >> next >> d;

        tree[next].pb({i, d});
    }

    gen(0,0);

    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= n; j++)
        {
            DIFF[i][j] = TreeSum[i] * (dist[i] - dist[j]);
        }
    }

    cout << (maxCost - recur(start[0], 0, k)) << "\n";

    return;
}

int main()
{
    auto start = chrono::high_resolution_clock::now();
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t = 1;
    // cin >> t;
    for(int i = 0; i < t; i++){
        // cout << "Case #" << i + 1 << ": ";
        solve();
    }
    auto stop = chrono::high_resolution_clock::now(); 
    auto duration = chrono::duration_cast<chrono::milliseconds>(stop - start); 
    // cout <<"Time taken : "<<duration.count() <<" milliseconds\n";
}

