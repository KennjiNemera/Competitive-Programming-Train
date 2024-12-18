#include <bits/stdc++.h>

using namespace std;

#define ll long long
#define f first
#define s second
#define sz(x) int(x.size())

const int MAXN = 100005;
vector<pair<int, int>> adj[MAXN];
bool vis[MAXN] = {0};
priority_queue<pair<ll, int>, vector<pair<ll, int>>,greater<pair<ll, int>>> pq;
priority_queue<ll> bes[MAXN];

int main()
{
    int n, m, k;

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m >> k;

    for (int i = 0; i < m; i++)
    {
        int a, b, w;

        cin >> a >> b >> w;

        a--;
        b--;

        adj[a].push_back({b,w}); 
    }

    pq.push({0,0});
    bes[0].push(0);

    while (sz(pq))
    {
        auto cur = pq.top();

        pq.pop();

        if (cur.f > bes[cur.s].top()) continue;

        for (pair<int, int> child : adj[cur.s])
        {
            ll tmp = cur.f + child.s;

            if (sz(bes[child.f]) < k)
            {
                bes[child.f].push(tmp);
                pq.push({tmp, child.f});
            } else if (tmp < bes[child.f].top())
            {
                bes[child.f].pop();
                bes[child.f].push(tmp);
                pq.push({tmp, child.f});
            }
        }
    }

    int len = bes[n-1].size();
    vector<ll> ans;

    while (sz(bes[n-1]))
    {
        ans.push_back(bes[n-1].top());
        bes[n-1].pop();
    }

    sort(ans.begin(), ans.end());

    for (int i = 0; i < len; i++)
    {
        cout << ans[i] << " ";
    }

    cout << endl;

    return 0;
}
