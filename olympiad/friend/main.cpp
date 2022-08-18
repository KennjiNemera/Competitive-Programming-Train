#include <bits/stdc++.h>

#define pi pair<int, int>
#define vi vector<int>
#define f first
#define s second
#define pb push_back
#define FOR(i,x,y) for (int i = x; i < y; i++)

using namespace std;

int findSample(int n, int* confidence, int* host, int* protocol)
{
    vector<pi> dp;

    FOR(i,0,n) dp.pb({confidence[i], 0});

    for (int i = n - 1; i > 0; i--)
    {
        // we want to pair the last node with the host and then merge
        int par = host[i];
        int prot = protocol[i];

        //cout << prot << "<-\n";

        if (prot == 0)
        {
            // I am your friend
            dp[par].f = dp[par].f + dp[i].s;
            dp[par].s = max(dp[par].s + dp[i].f, dp[par].s + dp[i].s);
        } else if (prot == 1)
        {
            // my friends are your friends
            //cout << dp[i].f << " : " << dp[par].f << "\n";
            dp[par].f = max(max(dp[i].f + dp[par].f, dp[par].f + dp[i].s), dp[i].f + dp[par].s);
            dp[par].s += dp[i].s;
        } else {
            // we are all friends
            dp[par].f = max(dp[par].f + dp[i].s, dp[par].s + dp[i].f);
            dp[par].s = dp[par].s + dp[i].s;
        }

        //cout << i << "th stage: \n";
    }

    return max(dp[0].s, dp[0].f);
}

//void input()
//{
//    int n;
//    
//    cin >> n;
//
//    vi confidence(n), host(n), protocol(n);
//
//    FOR(i,0,n) cin >> confidence[i];
//    FOR(i,0,n) cin >> host[i];
//    FOR(i,0,n) cin >> protocol[i];
//    
//    cout << "solution = " << findSample(n, confidence, host, protocol) << "\n";
//}
//
//int main()
//{
//    auto start = chrono::high_resolution_clock::now();
//    ios_base::sync_with_stdio(false);
//    freopen("test.in", "r", stdin);
//    cin.tie(0);
//    cout.tie(0);
//    int t = 1;
//    // cin >> t;
//    for(int i = 0; i < t; i++){
//        // cout << "Case #" << i + 1 << ": ";
//        input();
//    }
//    auto stop = chrono::high_resolution_clock::now(); 
//    auto duration = chrono::duration_cast<chrono::milliseconds>(stop - start); 
//    // cout <<"Time taken : "<<duration.count() <<" milliseconds\n";
//}
//
