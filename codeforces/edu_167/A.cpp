#include <bits/stdc++.h>

using namespace std;

void solve()
{
    int x, y;
    cin >> x >> y;
    string s;
    s = y >= -1 ? "YES" : "NO";
    cout << s << "\n";
}

int main()
{
    // write generic main
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t = 1;
    cin >> t;
    for (int i = 0; i < t; i++)
        solve();
}
