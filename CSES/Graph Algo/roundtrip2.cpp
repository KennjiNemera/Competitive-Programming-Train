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
const int MAXN = 1e5+5;
vector<vi> adj(MAXN, vi());
vi vis(MAXN, 0);
vi cycle;
int head;

int dfs(int v) {
    if (vis[v]) return 0;
    vis[v] = 1;
    for (int child : adj[v]) {
        if (!vis[child]){
            int res = dfs(child);
            // continue the search
            if (res) {
                if (res == 2) return 2;
                cycle.pb(v);
                if (v == head) return 2;
                return 1;
            }
        } else if (vis[child] == 1) {
            // cycle found
            cycle.pb(child);
            cycle.pb(v);
            head = child;
            return 1; // initiate cycle finding
        }
    }
    vis[v] = 2;
    return 0;
}

void solve()
{
    int n, m;

    cin >> n >> m;

    FOR(i, 0, m) {
        int a,b;
        cin >> a >> b;
        adj[a].pb(b);
    }

    FOR(i, 1, n + 1) {
        if (!vis[i]) dfs(i);
        if (size(cycle)) break;
    }

    if (size(cycle)) {
        cout << size(cycle) << "\n";
        reverse(begin(cycle), end(cycle));
        for (int i = 0; i < size(cycle); i++) {
            cout << cycle[i] << " ";
        }
    } else {
        cout << "IMPOSSIBLE\n";
    }
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

