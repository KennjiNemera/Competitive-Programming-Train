#include <bits/stdc++.h>

using namespace std;

const int MX = 101, MT = 10001;
int dp[MX][MT];
int s[MX];

void solve()
{
    // good luck big guy
    int n, d;

    cin >> n >> d;

    int total = 0;

    for (int i = 0; i < n; i++)
    {
        cin >> s[i];
        total += s[i];
    }

    for (int i = 0; i <= n; i++) for (int j = 0; j <= total; j++) dp[i][j] = INT_MAX;

    dp[0][0] = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j <= total; j++)
        {

            if (dp[i][j] == INT_MAX) continue;
            
            auto tmp = s[i];

            dp[i+1][j] = min(dp[i][j], dp[i+1][j]);

            if (j + tmp <= total) // some condition
            {
                // single day move
                if ((j + tmp <= d) && dp[i][j]) 
                {
                    dp[i+1][j+tmp] = min(dp[i + 1][j + tmp], dp[i][j]); 
                } else {
                    // overnight move
                    if (j + d < tmp) continue;
                    
                    dp[i+1][tmp] = min(dp[i+1][tmp], dp[i][j] + 1);
                    if (tmp <= d) {
                        dp[i+1][j + tmp] = min(dp[i][j] + 1, dp[i+1][j + tmp]);
                    } else dp[i+1][j + tmp] = min(dp[i + 1][j + tmp], 2 * dp[i+1][j] + 1);
                }
            } 
        }      
    }

    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= total; j++)
        {
            cout << dp[i][j] << " ";
        }
        cout << endl;
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

