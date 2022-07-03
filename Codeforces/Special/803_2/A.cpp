#include <bits/stdc++.h>

using namespace std;

void solve()
{
    // good luck big guy
    int n; 
    
    cin >> n;
    
    int arr[n];

    for (int i = 0; i < n; i++) cin >> arr[i];

    cout << arr[0] << "\n"; 
}

int main()
{
    auto start = chrono::high_resolution_clock::now();
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t = 1;
    cin >> t;
    for(int i = 0; i < t; i++){
        // cout << "Case #" << i + 1 << ": ";
        solve();
    }
    auto stop = chrono::high_resolution_clock::now(); 
    auto duration = chrono::duration_cast<chrono::milliseconds>(stop - start); 
    // cout <<"Time taken : "<<duration.count() <<" milliseconds\n";
}

