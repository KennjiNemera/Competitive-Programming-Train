#include <bits/stdc++.h>

using namespace std;

// SOLVING ALL 6 SUBTASKS;
// Create a single connected component of the n nodes and report this back to the second method
// Create many connected components
// Create many connected components but this time create a loop which would mean that there are 2 ways to reach each node in the components
// Lock nodes off with r[i][j] = 1 in a tree but loop the other trees by their roots in a loop.
// Verify consistent relationship amongst nodes in the tree
// we don't do 3's in these parts. Trivial subtask

const int MAXN = 1001;
int n;
bool vis[MAXN];

int construct(vector<int> p[])
{
    n = p[0].size();

    cout << n << "\n";

    vector<int> arr[n];
    
    for (int i = 0; i < n; i++) arr[i].resize(n);

    for (int i = 0; i < n - 1; i++)
    {
        if (!vis[i]) continue;

        for (int j = i + 1; j < n; j++)
        {
            if (p[i][j]) {
                arr[i][j] = 1;
                arr[j][i] = 1;
                vis[j] = 1;
            }
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << arr[i][j] << " ";
        }
        cout << "\n";
    }

    return 1;
}

void solve()
{
    int sz;

    cin >> sz;
    
    vector<int> arr[sz];

    for (int i = 0; i < sz; i++)
    {
        for (int j = 0; j < sz; j++)
        {
            int x;
            cin >> x;
            arr[i].push_back(x);
        }
    }

    cout << "woiiw\n";

    construct(arr);

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

