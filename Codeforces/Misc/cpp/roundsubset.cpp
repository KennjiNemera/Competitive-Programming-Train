#include <bits/stdc++.h>

using namespace std;

#define ll long long

const int MAXN = 201;
int arr[MAXN][2];
int dp[2][MAXN][6001];
int d3 = 0;


int main()
{
    int n, k;

    ios_base::sync_with_stdio(0); cin.tie(0);

    cin >> n >> k;

    vector <long long> a (n);
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < n; i++) {
        long long v = a[i];
        while (!(v % 5)) {
            v /= 5;
            d3++;
        }
    }

    int ans = 0;

    for (int i = 0; i < MAXN; i++)
    {
        for (int j = 0; j <= 6000; j++)
        {
            dp[0][i][j] = dp[1][i][j] = -1e9;
        }        
    }

    dp[0][0][0] = dp[0][1][0] = 0;

    for (int i = 1; i <= n; i++)
    {
        int fs = 0, es = 0;
        long long v = a[i - 1];
        while (!(v % 2)) {
            v /= 2;
            es++;
        }
        while (!(v % 5)) {
            v /= 5;
            fs++;
        }
        for (int j = 1; j <= min(k,i); j++)
        {
            for (int z = 0; z <= d3; z++)
            {
                dp[1][j][z] = max(dp[0][j][z], dp[1][j][z]);
                if (z >= fs) {
                    dp[1][j][z] = max(dp[0][j-1][z - fs] + es, dp[1][j][z]);
                }
            }
        }
        
        for (int s = 1; s <= k; s++)
        {
            for (int z = 0; z <= d3; z++)
            {
                dp[0][s][z] = dp[1][s][z]; 
            }
        }
    }

    for (int z = 0; z <= d3; z++)
    {
        ans = max(ans, min(z, dp[0][k][z]));
    }

    cout << ans << "\n";


    return 0;
}
