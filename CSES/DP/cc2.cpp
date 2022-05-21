#include <bits/stdc++.h>

using namespace std;

const int MX = 101, MS = 1e6+1;
int dp[MX][MS];
int v[MX];
void solve()
{
    // good luck big guy
    int n, x;

    cin >> n >> x;

    for (int i = 1; i <= n; i++){
        cin >> v[i];
        dp[i][v[i]] = 1;
    }   

    for (int i = 1; i <= n; i++)
    {
        for (int j = 0; j <= x; j++)
        {
            dp[i][j] = max(dp[i-1][j], dp[i][j]);

            if (j >= v[i]) {
                dp[i][j] += dp[i-1][j-v[i]];
            }
        }
    }
    
    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= x; j++)
        {
            cout << dp[i][j] << " ";
        }
        cout << endl;
    }
    cout << dp[n][x] << "\n";
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

