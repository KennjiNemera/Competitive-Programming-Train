#include <bits/stdc++.h>

using namespace std;

const int MAXN = 100001;
vector<pair<int, int>> adj[MAXN];
int in[MAXN] = {0};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    freopen("timeline.in", "r", stdin);
    freopen("timeline.out", "w", stdout);

    int n, m, c;

    cin >> n >> m >> c;

    int S[n] = {0};

    for (int i = 0; i < n; i++) cin >> S[i];
    
    // MAKING THE TOPO SORT THE HARD WAY, BECAUSE I DON'T LIKE GLOBAL VARIABLES
    
    for (int i = 0; i < c; i++)
    {
        int a, b, w;

        cin >> a >> b >> w;

        a--;
        b--;

        adj[a].push_back({b, w});
        in[b]++;
    }

    queue<int> q;

    for (int i = 0; i < n; i++) if(!in[i]) q.push(i);

    while (!q.empty())
    {
        int cur = q.front();
        q.pop();

        for (pair<int, int> edge : adj[cur])
        {
            S[edge.first] = max(S[edge.first], S[cur] + edge.second);
            in[edge.first]--;
            if (!in[edge.first]) q.push(edge.first);
        }
    }

    for (int i = 0; i < n; i++)
    {
        cout << S[i] << "\n";
    }

    return 0; 
}
