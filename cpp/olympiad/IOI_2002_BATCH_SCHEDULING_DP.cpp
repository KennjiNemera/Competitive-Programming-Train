#include <bits/stdc++.h>

using namespace std;

#define ll long long

const int maxn = 10002;
const ll INF = 1e9;
int t[maxn], c[maxn];
ll dp[maxn];

void solve()
{
    int n, s;

    cin >> n >> s;

    for (int i = 1; i <= n; i++)
    {
        cin >> t[i] >> c[i];
        
        t[i] += t[i-1];
        c[i] += c[i-1];
    }

    // init the base case
    for (int i = n; i >= 1; i--)
    {
        ll temp = INF;

        for (int k = i + 1; k <= n + 1; k++)
        {   
            ll comp = dp[k] + (s + (t[k - 1] - t[i - 1])) * (c[n] - c[i-1]);
            temp = min(comp, temp);
        }

        dp[i] = temp;
    }

    cout << dp[1] << "\n";
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
        solve();
    }
    auto stop = chrono::high_resolution_clock::now(); 
    auto duration = chrono::duration_cast<chrono::milliseconds>(stop - start); 
    // cout <<"Time taken : "<<duration.count() <<" milliseconds\n";
}

