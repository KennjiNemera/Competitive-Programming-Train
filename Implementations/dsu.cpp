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
const int MAXN = 1e5+5;

int par[MAXN], sz[MAXN];

int find(int x) {
    while(par[x] != x) x = par[x];
    return x;
}

void unite(int a, int b) {
    int pa = find(a);
    int pb = find(b);

    if (pa == pb) return;

    if (sz[b] > sz[a]){
        swap(a,b);
    }

    par[b] = a;
    sz[a] += sz[b];
}

void solve()
{
    int n;
    FOR(i,1,n+1) {
        par[i] = i;
        sz[i] = 1;
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

