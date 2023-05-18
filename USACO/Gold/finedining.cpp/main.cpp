#include <bits/stdc++.h>

using namespace std;

#define pb push_back
#define f first
#define s second
#define ll long long

const int MX = 50001;
vector<pair<int, int>> adj[MX];
bool vis[MX] = {0};
ll dist[MX], dist2[MX];
int balemax[MX];


int main()
{
    int n, m, k;

    freopen("dining.in", "r", stdin);
    freopen("dining.out", "w", stdout);

    cin >> n >> m >> k;

    for (int i = 0; i < m; i++)
    {
        int a, b, w;

        cin >> a >> b >> w;

        a--;
        b--;

        adj[a].pb({b,w});
        adj[b].pb({a,w});
    }

    // run the first dijkstra

    priority_queue<pair<int, int>> q;

    fill(begin(dist), end(dist), LONG_MAX);

    dist[n-1] = 0;

    q.push({0, n - 1});

    while (!q.empty())
    {
        pair<int, int> cur = q.top();
        q.pop();

        if (vis[cur.s]) continue;

        vis[cur.s] = 1;

        for (pair<int, int> child : adj[cur.s])
        {
            if (dist[child.f] > dist[cur.s] + child.s)
            {
                int val = dist[cur.s] + child.s;
                dist[child.f] = val;
                q.push({-val, child.f});
            }    
        }
    }

    for (int i = 0; i < k; i++)
    {
        int a, b;

        cin >> a >> b;

        a--;

        balemax[a] = max(balemax[a], b);
    }

    for (int i = 0; i < n; i++)
    {
        if (!balemax[i]) continue;
        adj[n].pb({i, dist[i] - balemax[i]}); // weight edge will be the difference between optimal dist to node i and max yumminess
    }

    fill(begin(dist2), end(dist2), LONG_MAX);

    q.push({0, n});

    dist2[n] = 0;
    
    fill(begin(vis), end(vis), 0);

    while (!q.empty())
    {
        pair<int, int> cur = q.top();
        q.pop();

        if (vis[cur.s]) continue;

        vis[cur.s] = 1;

        for (pair<int, int> child : adj[cur.s])
        {
            int temp = dist2[cur.s] + child.s;

            if (dist2[child.f] > temp)
            {
                dist2[child.f] = temp;
                q.push({-temp, child.f});
            }
        }
    }

    for (int i = 0; i < n - 1; i++)
    {
        cout << (dist2[i] <= dist[i]) << "\n";
    }

    return 0;
