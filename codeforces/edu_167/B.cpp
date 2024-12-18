#include <bits/stdc++.h>

using namespace std;

const int MOD = 1e9 + 7;

void solve()
{
    string a, b;
    cin >> a >> b;
    int ans = a.size() + b.size();

    for (int i = 0; i < b.size(); i++)
    {
        int ptr = i;
        for (int j = 0; j < a.size(); j++)
        {
            if (ptr < b.size() && b[ptr] == a[j])
                ptr++;
        }
        ans = min(ans, (int)a.size() + (int)b.size() - ptr + i);
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
    cin >> t;
    for (int i = 0; i < t; i++)
    {
        // cout << "Case #" << i + 1 << ": ";
        solve();
    }
    auto stop = chrono::high_resolution_clock::now();
    auto duration = chrono::duration_cast<chrono::milliseconds>(stop - start);
    // cout <<"Time taken : "<<duration.count() <<" milliseconds\n";
}
