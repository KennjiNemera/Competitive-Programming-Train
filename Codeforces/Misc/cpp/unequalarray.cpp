#include <bits/stdc++.h>

using namespace std;

void solve()
{
    int n;

    cin >> n;

    int first = n;
    int last = 0;

    int arr[n];

    for (int i = 0; i < n; i++) {
       cin >> arr[i];
       if (i)
       {    
            if (arr[i] == arr[i-1]) {
                first = min(first, i);
                last = i;
            }
       }
    }

    if (first == n || first == last)
    {
        cout << "0\n";
        return;
    }
    
    last--;

    cout << max(1, last - first) << "\n";

    return;
}

int main()
{
    int t;

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> t;

    while (t-- > 0)
    {
        solve();
    }
}
