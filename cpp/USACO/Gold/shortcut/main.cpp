#include <bits/stdc++.h>

using namespace std;

#define ll long long
#define f first
#define s second
#define pb push_back
#define pi pair<long long,int>
 
int const MX = 10001;

bool vis[MX] = {0};
ll dist[MX];
int par[MX], c[MX], occ[MX];
vector<pi> arr[MX];

int main()
{
    ios_base::sync_with_stdio(0); cin.tie(0);

    int n, m, t;

    freopen("shortcut.in", "r", stdin);
    freopen("shortcut.out", "w", stdout);

    cin >> n >> m >> t;

    for (int i = 1; i <= n; i++)
    {
        cin >> c[i];        
    }

    for (int i = 0; i < m; i++)
    {
        int a, b, w;

        cin >> a >> b >> w;

        arr[a].pb({w,b});
        arr[b].pb({w,a});
    }

    fill(begin(dist), end(dist), INT_MAX);
    fill(begin(par), end(par), -1);

    dist[1] = 0;

    priority_queue<pi> pq;

    pq.push({0, 1});

    while (!pq.empty())
    {
        pi cur = pq.top();

        pq.pop();

        if (vis[cur.s]) continue;

        vis[cur.s] = 1;

        for (pi child : arr[cur.s])
        {
            ll temp = dist[cur.s] + child.f;

            if (dist[child.s] > temp) 
            {
                dist[child.s] = temp;
                par[child.s] = cur.s;
                pq.push({-temp, child.s});  
            } else if (dist[child.s] == temp) {
                if (par[child.s] > cur.s) 
                {
                    par[child.s] = cur.s;
                    pq.push({-temp, child.s});
                }
            }
        }
    }

    for (int i = 1; i <= n; i++)
    {
        int cur = i;

        while (cur != -1) 
        {
            occ[cur] += c[i];
            cur = par[cur];
        }
    }

    // find the max val -> dist - occ * T

    ll ans = 0;

    for (int i = 1 ; i <= n; i++)
    {
        ans = max(ans, occ[i] * (dist[i] - t));            
    }

    cout << ans << endl;

}
