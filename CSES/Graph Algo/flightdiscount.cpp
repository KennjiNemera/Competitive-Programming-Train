#include <bits/stdc++.h>

using namespace std;

#define vi vector<int>
#define f first
#define s second
#define pb push_back
#define pi pair<int, int>
typedef long long int64;

const int MAXN = 10005;
vector<vector<int>> adj[MAXN];
int n, m;
int64 dista[MAXN], distb[MAXN];

void solve()
{
    // read in all the input
    cin >> n >> m;

    for (int i = 0; i < m; i++)
    {
        int a, b, c;

        cin >> a >> b >> c;

        a--;
        b--;

        adj[i].pb({b, c});
    }

    // perform djikstra from node 1 and node n

    priority_queue<pi>

    // for all edges, find the minimum if we were to apply the discount to the i'th edge
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

