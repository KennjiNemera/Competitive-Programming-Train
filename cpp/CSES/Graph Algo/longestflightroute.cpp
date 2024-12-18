// state the problem source, problem name / contest, date solved 
// [...state the problem tags/topics...]
#include <bits/stdc++.h>

using namespace std;

#define vi vector<int>
#define v vector
#define pi pair<int, int>
#define f first
#define s second
#define pb push_back
#define vll vector<long long>
#define FOR(i, x, y) for(int i = x; i < y; i++)
#define set(vect, val) fill(begin(vect), end(vect), val)

typedef long long int64;
const int MAXN = 1e5+5;
v<vi> adj(MAXN, vi());
vi vis(MAXN, 0);
vi topo;

void dfs(int v) {
    vis[v] = 1;
    for (int child : adj[v]) {
        if (!vis[child]) dfs(child);
    }
    vis[v] = 2;
    topo.pb(v);
}

void solve()
{
    int n, m, a, b;
    cin >> n >> m;
    FOR(i, 0, m) {
        cin >> a >> b;
        adj[a].pb(b);
    }    
    
    FOR(i, 1, n+1) if (!vis[i]) dfs(i);

    reverse(begin(topo), end(topo));
    // define vars for dp
    vi ways(size(topo) + 1, 0);
    vi par(size(topo) + 1, -1);
    vi pos(size(topo) + 1, 0);
    vi ans;

    FOR(i, 0, size(topo)) pos[topo[i]] = i;
    ways[1] = 1;
    queue<int> q;
    q.push(1);
   
    while (!q.empty()) {
        int top = q.front();
        q.pop();
        for (int child : adj[top]) {
            if (ways[child] < ways[top] + 1) {
                ways[child] = ways[top] + 1;
                par[child] = pos[top];
                q.push(child);
            }
        }
    } 

    int cur = n;

    while (par[cur] != -1) {
        ans.pb(cur);
        cur = topo[par[cur]];
    }   

    ans.pb(cur);

    if (size(ans) <= 1) {
        cout << "IMPOSSIBLE\n";
        return;
    }

    cout << size(ans) << "\n";
    for (int i = size(ans) - 1; i >= 0; i--) cout << ans[i] << " ";
    cout << "\n";
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

