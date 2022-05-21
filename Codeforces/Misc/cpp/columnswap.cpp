#include <bits/stdc++.h>

using namespace std;

#define pi pair<int, int>
#define f first
#define s second
#define pb push_back

void solve()
{
    int n, m;

    cin >> n >> m;

    vector<int> arr[n];

    for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) 
    {
        int temp;

        cin >> temp;

        arr[i].pb(temp);   
    }

    vector<int> bad;

    for (int i = 0; i < n && bad.empty(); i++)
    {
        
        vector<int> b = arr[i];

        sort(begin(b), end(b));

        for (int j = 0; j < m; j++)
        {
            if (arr[i][j] != b[j])
            {
                bad.push_back(j);
            }
        }
    }

    int sz = bad.size();

    if (sz == 0)
    {
        cout << "1 1" << "\n";
        return;
    } 

    if (sz > 2)
    {
        cout << "-1\n";
        return;
    }

    // perform the swap
    for (int i = 0; i < n; i++)
    {
        swap(arr[i][bad[0]], arr[i][bad[1]]);
    }

    // check if the array is good
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m - 1; j++)
        {
            if (arr[i][j+1] < arr[i][j])
            {
                cout << "-1" << "\n";
                return;
            }
        }
    }

    cout << (bad[0] + 1) << " " << (bad[1] + 1) << "\n";
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

