#include <bits/stdc++.h>

using namespace std;

void solve()
{
    // good luck big guy
    int n, x;

    cin >> n >> x;

    int pref[n+1];

    pref[0] = 0;
    for (int i = 1; i <= n; i++) {
        cin >> pref[i];
        pref[i] += pref[i-1];
    }

    int a = 1, b = 1, ans = 0;

    int sum = pref[1];

    while (a <= n)
    {
        if (sum < x) {
            if (b < n) {
                b++;
            } else break;
        } else if (sum == x) {
            ans++;
            b++;
        }
        else {
            a++;
        }

        sum = pref[b] - pref[a-1];
    }

    cout << ans << "\n";
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

