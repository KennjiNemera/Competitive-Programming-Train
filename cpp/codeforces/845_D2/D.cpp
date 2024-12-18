#include <bits/stdc++.h>

using namespace std;

#define ll long long
#define vvi vector<vector<int>>
#define pb push_back
#define vi vector<int>

const int MOD = 1e9+7;

int power(ll x, ll p, int y = MOD) {
    
    unsigned long long res = 1;

    x %= y;

    while (p) {
        if (p & 1) {
            res = (res * x) % y;
        }
        p = p >> 1;
        x = (x * x) % y;
    }

    return res % y;
}

void solve() {
    int n;
    cin >> n;
    vvi adj(n);
    vi deg(n, 0);

    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        u--;v--;
        adj[u].pb(v);
        adj[v].pb(u);
        deg[u]++;
        deg[v]++;
    }
    // check trivial case
    if (n == 1) {
        cout << "1\n";
        return;
    }
    vector<ll> lvl(n, 0);
    queue<int> q;
    deg[0]++; // we don't want to consider the head as a leaf if n = 2
    int level = 1;

    for (int i = 0; i < n; i++) {
        if (deg[i] == 1) {
            q.push(i);
            lvl[i] = level;
        }
    }

    while (!q.empty()) {
        level++;
        int sz = q.size();
        while (sz--) {
            int top = q.front();
            q.pop();
            for (int& child : adj[top]) {
                deg[child]--;
                if (deg[child] == 1) {
                    q.push(child);
                    lvl[child] = level;
                }
            }
        }   
    }

    ll ans = 0;
    int mult = power(2, n - 1);
    for (int i = 0; i < n; i++) {
        ans = (ans + (lvl[i] * mult) % MOD) % MOD;
    }
    cout << ans << "\n";
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while (t--) solve();
}
