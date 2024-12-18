// state the problem source, problem name / contest, date solved 
// [...state the problem tags/topics...]
#include <bits/stdc++.h>

using namespace std;

#define vi vector<int>
#define pi pair<int, int>
#define f first
#define s second
#define pb push_back
#define vll vector<long long>
#define FOR(i, x, y) for(int i = x; i < y; i++)
#define set(vect, val) fill(begin(vect), end(vect), val)

typedef long long int64;
const int MAXN = 2 * (1e5 + 1);
// take into account that the values for the nodes can be 1e9
int node[MAXN], sz[MAXN], val[MAXN], loc[MAXN];
int64 sum[MAXN];
vector<vi> adj(MAXN, vi());
int cnode = 1;
int n;

int64 get(int x) {
    int64 ans = 0;
    while (x >= 1) {
        ans += sum[x];
        x -= (x & -x);
    }
    //cout << "returned from " << x << "\n";
    return ans;
}

void add(int64 x, int pos) {
    for (; pos <= n; pos += (pos & -pos)) { sum[pos] += x; }
}

void dfs(int v, int p) {
    int temp = cnode;
    cnode++;
    node[temp] = v;
    loc[v] = temp;
    add(val[v], temp);

    for (int c : adj[v])
        if (c != p) {
            dfs(c, v);
        }

    //cout << v << ", count: " << scount << "\n";

    sz[temp] = cnode - temp; 
}

void solve()
{
    // take n and q;
    // read in n integers that denote the value at each node
    // there are n - 1 lines that describe the edges
    // queuries in the format "1 s x"
    // 2 x -> where you calculate the sum at node x

    int q;

    cin >> n >> q;

    FOR(i,1,n+1) cin >> val[i];

    FOR(i,0,n-1){
        int a, b;
        cin >> a >> b;

        adj[a].pb(b);
        adj[b].pb(a);
    }

    // create the sparse table
    dfs(1,-1);

    //FOR(i,1,n+1) cout << node[i] << " : " << sz[i] << " : " << sum[i] << "\n";
    //FOR(i,1, n + 1) cout << loc[i] << "\n";


    while (q--) {
        int a;
        cin >> a;
        if (a == 1) {
            int s, x;
            cin >> s >> x;
            int64 delta = x - val[s];
            add(delta, loc[s]);
            val[s] = x;
            //FOR(i,1,n+1) cout << node[i] << " : " << sz[i] << " : " << sum[i] << "\n";
            //cout << "\n";
        } else {
            int s;
            cin >> s;
            int64 ans = get(loc[s] + sz[loc[s]] - 1) - get(loc[s] - 1);
            //cout << get(loc[s] + sz[loc[s]]) << " " << get(loc[s] - 1) << "<-\n";
            //cout << "ind A: " << get(loc[s] + sz[loc[s]] - 1) << "\n";
            cout << ans << "\n";
        }
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

