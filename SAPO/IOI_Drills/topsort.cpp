#include <bits/stdc++.h>

using namespace std;

#define MAXN 1000001

vector<vector<int>> adj(MAXN);
int vis[MAXN];
bool flag = true;
vector<int> topo;

void dfs(int cur) {
    vis[cur] = 1;

    for (int child : adj[cur]) {

        if (vis[child] == 2) continue;

        if (vis[child] == 1) {
            flag = 0;
            return;
        }

        dfs(child);
    }

    vis[cur] = 2;

    topo.push_back(cur);
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
    }

    for (int i = 0; i < n && flag; i++) {
        flag = 1;
        if (vis[i] == 0) {
            dfs(i);
        }
    }

    reverse(topo.begin(), topo.end());

    if (!flag) {
        cout << "IMPOSSIBLE" << endl;
    } else {
        for (int i = 0; i < n; i++) {
            cout << (topo[i] + 1) << " ";
        }
        cout << "\n";
    }

    return 0;
}