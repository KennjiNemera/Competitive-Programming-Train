#include <bits/stdc++.h>

using namespace std;

#define ll long long

void solve()
{
    // good luck big guy
    int n;

    cin >> n;

    ll arr[n];

    for (int i = 0; i < n; i++) cin >> arr[i];

    ll ans = 0;
    ll x = 0;
    ll state = arr[0];

    for (int i = 0; i < n - 1; i++)
    {
        int del = (arr[i+1] - x) - state;
        ans += abs(del);

        if (del < 0)
        {
            state = arr[i+1] - x;
        } else
        {
            x += del;
        }   
    }

    ans += abs(state);

    cout << ans << "\n";

}

int main()
{
    auto start = chrono::high_resolution_clock::now();
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t = 1;
    cin >> t;
    for(int i = 0; i < t; i++) {
        // cout << "Case #" << i + 1 << ": ";
        solve();
    }
    auto stop = chrono::high_resolution_clock::now(); 
    auto duration = chrono::duration_cast<chrono::milliseconds>(stop - start); 
    // cout <<"Time taken : "<<duration.count() <<" milliseconds\n";
}

