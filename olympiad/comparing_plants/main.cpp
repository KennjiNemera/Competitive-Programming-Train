#include <bits/stdc++.h>

using namespace std;

const int MAXN = 200010;
int arr[MAXN];
int n;

int compare_plants(int x, int y)
{
    if (arr[y] - arr[x] == y - x) return -1;
    if (arr[y] - arr[x] == 0) return 1;
    if (arr[n] - arr[y] + arr[x] == n - y + x) return -1;
    if (arr[n] - arr[y] + arr[x] == 0) return 1;
    return 0;
}

void init(int k, vector<int> r)
{
   // generate the prefix sum
   n = r.size();
   for (int i = 0; i < n; i++) arr[i+1] = arr[i] + r[i];
}

void solve()
{
    // good luck big guy
    int k, q;

    cin >> n >> k >> q;

    int r[n];

    for (int i = 0; i < n; i++) cin >> r[i];

    init(k, r);

    while (q--)
    {
        int x, y;

        cin >> x >> y;

        cout << compare_plants(x, y) << "\n";
    }

    return;
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

