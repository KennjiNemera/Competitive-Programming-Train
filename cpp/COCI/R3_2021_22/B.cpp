#include <bits/stdc++.h>

using namespace std;

const int MAXN = 100001;

vector<vector<int>> adj(MAXN);
bool vis[MAXN] = {0};
pair<int, int> store[MAXN];

pair<int, int> dfs(int cur, int par) {
    vis[cur] = 1;

    pair<int, int> ret(cur, 1);

    for (int child : adj[cur]) {
        if (child != par) {
            pair<int, int> temp = dfs(child, cur);
            temp.second++;
            if (temp.second > ret.second) {
                ret = temp;
            }
        }
    }

    return ret;
}

int diameter(int node) {
    auto start = dfs(node, -1);
    return dfs(start.first, -1).second;
}

int main() {
    int n, m;

    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int a, b;

        cin >> a >> b;

        a--;
        b--;

        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    // for each component, find the diameter of the component
    int sol = 0;

    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            int ans = diameter(i);
            sol += ans;
        }
    }

    cout << sol << "\n";
}