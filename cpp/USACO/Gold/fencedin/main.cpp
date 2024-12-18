#include <bits/stdc++.h>

using namespace std;

#define f first
#define s second
#define pb push_back
#define mk make_pair
#define ll long long

struct edge {
    int a, b, w;
};

const int MAXN = 2002;
const int INF = 1e9+7;
int par[MAXN * MAXN], sz[MAXN * MAXN], hor[MAXN], vert[MAXN];
vector<edge> edges;

bool customComp (const edge &a, const edge &b)
{
    return a.w < b.w;
}

// DSU FUNCTIONS
int findp(int a)
{
    while (a != par[a]) a = par[a];
    return a;
}

void unite(int a, int b)
{
    int ap = findp(a);
    int bp = findp(b);

    if (ap == bp) return;

    if (sz[ap] < sz[bp])
    {
        swap(ap, bp);
    }

    par[bp] = ap;
    sz[ap] += sz[bp];
}

int main()
{
    int a, b, n, m;

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    freopen("fencedin.in", "r", stdin);
    freopen("fencedin.out", "w", stdout);

    cin >> a >> b >> n >> m;

    for (int i = 0; i < n; i++) cin >> vert[i];
    for (int i = 0; i < m; i++) cin >> hor[i];
    
    sort(hor, hor + m);
    sort(vert, vert + n);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            int cx = hor[j];
            int cy = vert[i];

            int bx, by;

            if (!i) by = 0;
            else by = vert[i-1];

            if (!j) bx = 0;
            else bx = hor[j-1];

            int fx = cx - bx;
            int from = j * (n + 1) + i, to = j * (n + 1) + i + 1;
            edges.pb({from, to, fx});

            if (j == m - 1)
            {
                fx = b - cx;
                from = (j + 1) * (n + 1) + i, to = (j + 1) * (n + 1) + i + 1;
                edges.pb({from, to, fx});
            }

            int fy = cy - by;
            from = j * (n + 1) + i, to = (j + 1) * (n + 1) + i;
            edges.pb({from, to, fy});

            if (i == n - 1)
            {
                fy = a - cy;
                from++;
                to++;
                edges.pb({from, to, fy});
            }
        }
    }

    // INIT DSU STRUCTURE

    int tiles = (n + 1) * (m + 1);

    for (int i = 0; i < tiles; i++)
    {
        par[i] = i;
        sz[i] = 1;
    }

    sort(begin(edges), end(edges), customComp);

    long long ans = 0;

    for (int i = 0; i < edges.size(); i++)
    {
        int a,b,w;
        a = edges[i].a;
        b = edges[i].b;
        w = edges[i].w;

        int ap = findp(a);
        int bp = findp(b);

        bool cut = (sz[ap] + sz[bp] == tiles);

        if (ap == bp) continue;

        unite(a, b);

        ans += w;

        if (cut) break;
    }

    cout << ans << "\n";

    return 0;
}
