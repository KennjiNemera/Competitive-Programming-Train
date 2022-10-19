// state the problem source, problem name / contest, date solved 
// [...state the problem tags/topics...]
#include <bits/stdc++.h>

using namespace std;

#define vi vector<int>
#define pi pair<int, int>
#define f first
#define s second
#define pb push_back
#define vll vector<long long>
#define FOR(i, x, y) for(int i = x; i < y; i++)
#define set(vect, val) fill(begin(vect), end(vect), val)

typedef long long int64;
const int MAXN = 2 * (1e5 + 2);
vector<vi> adj(MAXN, vi());
int64 dp[MAXN][2];
int n;

void dfs(int v, int p) {
   int64 sub = 0, total = 0; 
    for (int c : adj[v]) {
        if (c == p) continue;
        dfs(c, v);
        sub += dp[c][1];
        total += dp[c][0] + dp[c][1];

    }
    dp[v][1] = sub + 1;
    dp[v][0] = total;
}

void dfs2(int c, int p) {
    // process the current node
    if (p != -1) {
        dp[c][0] = dp[c][0] + (dp[p][0] - dp[c][0] - dp[c][1]) + ((int64)n - dp[c][1]);
    }
    for(int v : adj[c]) if (v != p) dfs2(v, c);
}

void solve()
{
    int a, b;

    cin >> n;

    FOR(i,0,n-1) {
        cin >> a >> b;
        adj[a].pb(b);
        adj[b].pb(a);
    }    

    dfs(1, -1);

    // print out the results of the sparse table generation
    //FOR(i, 1, n + 1) cout << i << " : " << dp[i][0] << " : " << dp[i][1] << "\n";

    // iterate downward and out the sum dist
    dfs2(1, -1);

    FOR(i,1,n+1) cout << (int64)dp[i][0] << " ";
    cout << endl;
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

