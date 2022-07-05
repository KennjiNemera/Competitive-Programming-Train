#include "dreaming.h"
#include <bits/stdc++.h>

using namespace std;

// THE ANSWER WAS THAT WE FIND THE REPRESENTATIVE FOR EACH COMPONENT

// THE LONGEST DISTANCE WILL EITHER BE C1 + C2 + L OR 2L + C2 + C3

// WHERE C[] ARE OUR COMPONENTS SORTED BY MIN MAX LENGTH TO LEAF (DESCENDING)

/* 1. PROCESS EACH COMPONENT {
        STORE 2 MAX LENGTHS
        KEEP AN ARRAY TO STORE THE PARENTS
        POSSIBLE STORE MAX LENGTH IN PAIRS WHERE WE STORE THE LENGTH AND THE CHILD
    }
*/

#define pi pair<int, int>
#define pb push_back
#define f first
#define s second

const int MAXN = 100010;
vector<pi> adj[MAXN];
bool vis[MAXN];
pi dist[MAXN][2];
pi par[MAXN];
vector<int> comp, totals;
const int INF = 1e7;

void dfs(int v, int p)
{
    if (vis[v]) return;
    comp.pb(v);
    vis[v] = 1;

    dist[v][0] = {-1, 0};
    dist[v][1] = {-1, 0};

    // we want to store the 2 longest distances from node v to a leaf
    for (pi child : adj[v])
    {
        // store the parent of the current node and the length of the edge between them
        if (child.f == p) {
            par[v] = {p, child.s};   
            continue;
        }

        // process the child of the current node so that we can use it's information
        dfs(child.f, v);

        int prop = dist[child.f][0].s + child.s; // get the max dist to leaf through child adj[v][i]
        
        // store the two maximum lengths from node v through a child
        if (prop > dist[v][1].s)
        {
            if (prop >= dist[v][0].s)
            {
                dist[v][1] = dist[v][0];
                dist[v][0] = {child.f , prop};
            } else {
                // replace max2
                dist[v][1] = {child.f, prop};
            }
        }
    }
}

int travelTime(int N, int M, int L, int A[], int B[], int T[])
{
    // returns the min max travel time

    // init the adj list

    for (int i = 0; i < M; i++)
    {
        adj[A[i]].pb({B[i], T[i]});
        adj[B[i]].pb({A[i], T[i]});
    }

    int diam = 0;

    // we can perform dfs on this for each component
    for (int i = 0; i < N; i++)
    {
        // go through all the nodes / entry points for components
        int compmax = 0;
        if (!vis[i]) 
        {
            // perform DFS to find 2 Max Lengths
            dfs(i, i);

            // we now have all the downward max lengths.
            // process each node in the component and query for the node with the min max dist
            int imax = INF;

            //cout << "starting node: " << i << "\n";

            for (int j = 0; j < comp.size() ; j++)
            {
                int node = comp[j]; 

                int len = dist[node][0].s;
                
                if (node != i)
                {
                    // add parent distance
                    int d;

                    if (dist[par[node].f][0].f == node) {
                        d = dist[par[node].f][1].s + par[node].s;
                    } else {
                        d = dist[par[node].f][0].s + par[node].s;
                    }

                    if (d > dist[node][1].s)
                    {
                        if (d >= dist[node][0].s)
                        {
                            dist[node][1] = dist[node][0];
                            dist[node][0] = {par[node].f, d};
                        } else {
                            dist[node][1] = {par[node].f, d};
                        }
                    }

                    len = dist[node][0].s;

                    compmax = max(compmax, dist[node][0].s + dist[node][1].s);
                }

                imax = min(imax, len); 

                // print out the distances for each of our nodes
               // cout << node << " : { " << dist[node][0].f << ", " << dist[node][0].s << "} {" << dist[node][1].f << "," << dist[node][1].s << "}\n"; 

            }

            diam = max(diam, compmax);

            totals.pb(imax);
            comp.clear();
        }
    }

    int val = totals.size();
    sort(totals.begin(), totals.end(), greater<int>());

    int ans;

    //cout << "Totals size: " << to_string(totals.size()) << "\n";
    //for (int i = 0; i < totals.size(); i++) cout << "t" << i << ": " << totals[i] << "\n";

    if (totals.size() > 2) ans = max(L + totals[0] + totals[1], 2 * L + totals[1] + totals[2]);
    else if (totals.size() == 2) ans = L + totals[0] + totals[1];
    else ans = totals[0]; 

    return max(ans, diam);
}

//void solve()
//{
//    // take in input and call travelTime
//    int n, m, l;
//
//    cin >> n >> m >> l;
//    
//    int A[m], B[m], T[m];
//
//    for (int i = 0; i < m; i++) cin >> A[i] >> B[i] >> T[i];
//    
//    cout << travelTime(n, m, l, A, B, T) << "\n";
//
//    return;
//}
//
//int main()
//{
//    auto start = chrono::high_resolution_clock::now();
//    ios_base::sync_with_stdio(false);
//    cin.tie(0);
//    cout.tie(0);
//
//    freopen("input.in", "r", stdin);
//   
//    int t = 1;
//    // cin >> t;
//    for(int i = 0; i < t; i++){
//        // cout << "Case #" << i + 1 << ": ";
//        solve();
//    }
//    auto stop = chrono::high_resolution_clock::now(); 
//    auto duration = chrono::duration_cast<chrono::milliseconds>(stop - start); 
//    // cout <<"Time taken : "<<duration.count() <<" milliseconds\n";
//}

