#include <bits/stdc++.h>

using namespace std;

long long total()

int DistanceSum(int n, int *X, int *Y)
{

}

void solve()
{
    // take in input and generate vector lists for each of our axes
    int n;

    cin >> n;

    int x[n], y[n];

    int startx = INT_MAX, starty = INT_MAX;

    for (int i = 0; i < n; i++)
    {
        cin >> x[i] >> y[i];

        startx = min(startx. x[i]);
        starty = min(starty, y[i]);
    }

    map<int, vector<int>> mp;
    
    for (int i = 0; i < n; i++)
    {
        mp[x[i]].push_back();
    }


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

