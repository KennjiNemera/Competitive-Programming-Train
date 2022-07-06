// include "plants.h"
#include <bits/stdc++.h>

using namespace std;

const int MAXN = 200001;
int arr[MAXN];
int n;

int compare_plants(int x, int y)
{
    // we are looking for either a strictly increasing or strictly decreasing segment of plants to ensure that we can determine a conclusive answer
    // use the prefix sum to determine this answer in O(1) time

    if (x < y)
    {
        // check that it is strictly decreasing
        if (arr[x] == arr[y-1]) return 1;
        // check that it is strictly increasing
        if (arr[y-1] - arr[x] == y - x - 1) return -1;
    } else {
        // this means that we need to wrap around the array and combine answers
        
        // check for strictly decreasing
        if (arr[y] == 0 && arr[x] - arr[x-1] == 0) return 1;
 
        if (y) {
            if (arr[n - 1] - arr[x-1] + arr[y] == n - x + y) return -1;
        } else {
            if (arr[n - 1] - arr[x-1] == n - x) return -1; 
        }   
    }

    return 0;
}
    
void init(int k, int[] r)
{
    // we need to create a prefix sum for our array r that will allow us to verify the value between two points in O(1) time4
    arr[0] = r[0];
    for (int i = 1; i < n; i++) arr[i] = arr[i-1] + r[i];

    return;
}

void solve()
{
    // good luck big guy
    int k, q;

    cin >> n >> k >> q;

    int h[n];

    for (int i = 0; i < n; i++) cin >> h[i];

    init(k, h);

    while (q-- > 0)
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

