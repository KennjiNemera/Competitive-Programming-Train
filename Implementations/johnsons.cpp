#include <bits/stdc++.h>

using namespace std;

#define pi pair<int, int>
#define f first
#define s second
#define pb push_back

struct edge {
    int a, b, w;
};

int const MAXN = 1002, INF = 1e9;
vector<edge> edges;
int arr[MAXN][MAXN];
int ford[MAXN], dist[MAXN][MAXN];
bool vis[MAXN];
vector<pair<int,int>> adj[MAXN];
int n;

void dijkstra(int i)
{
    priority_queue<pi> pq;

    fill(dist[i], dist[i] + n, INF);
    fill(vis, vis + n, 0);

    dist[i][i] = 0;

    pq.push({0,i});

    while (!pq.empty())
    {
        pi cur = pq.top();
        pq.pop();

        if (vis[cur.s]) continue;

        vis[cur.s] = 1;

        for (pi e : adj[cur.s])
        {
            int temp = dist[i][cur.s] + e.s;
            if (temp < dist[i][e.f])
            {
                dist[i][e.f] = temp;
                pq.push({-dist[i][e.f], e.f});
            }
        }
    }
}

void solve()
{
    int m;

    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        edges.push_back({n,i,0});
    }

    for (int i = 0; i < m; i++)
    {
        int a,b,w;

        cin >> a >> b >> w;

        a--;
        b--;

        edges.push_back({a,b,w});
    }

    for (int i = 0; i < n; i++) ford[i] = INF;

    ford[n] = 0; 

    for (int i = 0; i < n - 1; i++)
    {
        for (edge e : edges)
        {
            ford[e.b] = min(ford[e.b], ford[e.a] + e.w);
        }
    }

    // REWEIGHT THE EDGES

    for (edge e : edges)
    {
        e.w = e.w + ford[e.a] - ford[e.b];
        adj[e.a].pb({e.b, e.w});
    }

    // FOR EVERY EDGE, WE WILL NOW RUN DJIKSTRA
    for (int i = 0; i < n; i++) dijkstra(i);

    // print out the answers for all dist pairs

    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            cout << dist[i][j] << " ";
        }
        cout << endl;
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

