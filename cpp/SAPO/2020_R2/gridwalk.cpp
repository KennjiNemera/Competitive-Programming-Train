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
const int MAXN = 1001;
int64 arr[MAXN][MAXN];
int mod = 1e8;

void solve()
{
    int n, m;

    cin >> n >> m;

    vector<vector<char>> grid(n+1, vector<char>(m+1));

    for (int i = 1; i <= n; i++) {
        string line;
        cin >> line;
        for (int j = 1; j <= m; j++) {
            grid[i][j] = line[j - 1];
        }
    }

    arr[1][1] = 1;
    
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (grid[i][j] == '#') continue;
            if (j > 1) arr[i][j] += arr[i][j-1] % mod;
            if (i > 1) arr[i][j] += arr[i-1][j] % mod;
        }
    }    

    cout << arr[n][m] % mod << "\n";
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

