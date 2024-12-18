#include <bits/stdc++.h>

using namespace std;

const int MAXN = 101, MAXT = 10001;
pair<int,int> dp[MAXN][MAXT];

constexpr inline pair<int, int> mmin(pair<int, int> a, pair<int, int> b) {
    return (a.first < b.first) ? a : ((a.second > b.second) ? a : b);
}

void solve()
{
    // good luck big guy
    int n, d;

    cin >> n >> d;

    int s[n];

    int total = 0;

    for (int i = 0; i < n; i++) {
        cin >> s[i];
        total += s[i];
    }
    

    // init dp with max value
    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= total; j++)
        {
            dp[i][j] = make_pair{INT_MAX, d};
        }
    }

    dp[0][0] = make_pair{0, d};

    for (int i = 1; i <= n; i++)
    {
        for (int j = 0; j <= total; j++)
        {
            // we can either skip a case 
            dp[i][j] = mmin(dp[i][j], dp[i-1][j]);

            auto tmp = s[i-1];
            if  (j < tmp) continue;
            else if (j == tmp) {
               if (j <= d) dp[i][j] = make_pair{1,d-j};
               else if (dp[i][j-d].first != INT_MAX) {
                   if (dp[i][j-d].second < dp[i][j] = dp[i][j-d]+1;
               else break;
            } else {
                if (j > d)
                {
                    // we know that we'll add a day
                } else {
                    //
                }
            }
            // we can add a new value based on a previous state
            /*if (j >= s[i-1])
            {
                int a = dp[i][j], b = dp[i-1][j - s[i]] * 2 + 1;

                if (a < b)
                {
                    
                } else if (a == b) 
                {
                   dp[i][j] = min(a, b);
                }
            } */
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


    cout << maxSum << " " << minDay << "\n";
    
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

