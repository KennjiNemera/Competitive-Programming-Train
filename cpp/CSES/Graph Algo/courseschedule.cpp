// state the problem source, problem name / contest, date solved 
// [...state the problem tags/topics...]
#include <bits/stdc++.h>

using namespace std;

#define vi vector<int>
#define pi pair<int, int>
#define f first
#define v vector
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

bool dfs(int v) {
    vis[v] = 1;
    for (int child : adj[v]) {
        if (vis[child] == 1) {
            // cycle found
            return false;
        } else if (!vis[child]) {
            if (!dfs(child)) return false;
        } 
    }
    vis[v] = 2;
    topo.pb(v);
    return true;
}

void solve()
{
    int n, m, a, b;
    cin >> n >> m;
    FOR(i, 0, m) {
        cin >> a >> b;
        adj[a].pb(b);
    }    
    FOR(i, 1, n + 1) {
        if (!vis[i]) {
            if (!dfs(i)) {
                cout << "IMPOSSIBLE\n";
                return; 
            }
        }
    }

    // assuming that we have a valid graph
    reverse(begin(topo), end(topo));
    FOR(i, 0, size(topo)) {
        cout << topo[i] << " ";
    }

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

