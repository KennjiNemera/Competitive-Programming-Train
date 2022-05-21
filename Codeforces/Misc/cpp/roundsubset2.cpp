#include <bits/stdc++.h>

using namespace std;

#define ll long long

const int MAXN = 201;
int arr[MAXN][2];
int dp[MAXN][MAXN][2];

void fact(ll a, int i)
{
    int lo = 0;
    int hi = 45;

    int c1 = 0, c2 = 0;
    
    while (!(a % 2LL)){
        a /= 2;
        c1++;
    }

    while (!(a % 5LL)){
        a /= 5;
        c2++;
    }

    arr[i][0] = c1;
    arr[i][1] = c2;
}

int main()
{
    int n, k;

    cin >> n >> k;

    for (int i = 0; i < n; i++)
    {
        long long a;

        cin >> a;

        fact(a, i);
    }

    int ans = 0;

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= k; j++)
        {

            int a = 0, b = 0;

            // s1 refers to ignoring item i
            for (int m = 0; m < i; m++)
            {            
                // s2 refers to adding onto the previous maxstate with one less item
                int s2a = dp[m][j-1][0] + arr[i-1][0];
                int s2b = dp[m][j-1][1] + arr[i-1][1];

                if (min(a,b) <= min(s2a, s2b))
                {
                    a = max(a, s2a);
                    b = max(s2b, b);     
                }          
            }

            if (min(a,b) >= min(dp[i][j][0], dp[i][j][1]))
                    {
                        dp[i][j][0] = a;
                        dp[i][j][1] = b;
                    }
        }
    }
    
    // for (int i = 0; i < n; i++)
    // {
    //     cout << arr[i][0] << " : " << arr[i][1] << endl;
    // }

    // for (int i = 0; i <= n; i++)
    // {
    //     for (int j = 0; j <= k; j++)
    //     {
    //         cout << "[" << dp[i][j][0] << "," << dp[i][j][1] << "] ";
    //     }
    //     cout << endl;
    // }

    for (int i = 0; i <= n; i++)
    {
        ans = max(ans, min(dp[i][k][0], dp[i][k][1]));
    }
    
    cout << ans << "\n";


    return 0;
}
