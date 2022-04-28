#include <bits/stdc++.h>

using namespace std;

const int MAXN = 20001;
int sz[MAXN], ind[MAXN][MAXN];
pair<int, int> par[MAXN];

// DSU IMPLEMENTATION
int find(int v)
{
    while (par[v].first != v) v = par[v].first;
    return v;
}

bool same(int a, int b) {return find(a) == find(b);}

void join(int a, int b)
{
    int apar = find(a);
    int bpar = find(b);

    if (sz[bpar] > sz[apar])
    {   
        swap(apar, bpar);
    }       

    sz[apar] += sz[bpar];

    par[bpar].second = par[bpar].first;
    par[bpar].first = apar;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, q;

    cin >> n >> m >> q;
    
    // init our structures

    for (int i = 0; i <= n; i++)
    {
        par[i].first = i;
        sz[i] = 1;
    }

    int conn = 1;

    while (m-- > 0)
    {
        int a, b;

        cin >> a >> b;
        
        int apar = find(a);
        int bpar = find(b);

        if (apar != bpar) {
            join(a, b);
            ind[apar][bpar] = conn;
            ind[bpar][apar] = conn;
        }

        conn++;
    }

    while (q-- > 0)
    {
        int a, b;

        cin >> a >> b;

        int ap = find(a), bp = find(b);

        if (ap != bp) {
            cout << "-1\n";
        } else {
            cout << ind[ap][b] << "\n";
        }
    } 

    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= n;j++) {
            cout << ind[i][j] << " ";
        }
        cout << endl;
    }


    return 0;
}
