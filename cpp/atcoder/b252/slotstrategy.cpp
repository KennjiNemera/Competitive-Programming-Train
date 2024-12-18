#include <bits/stdc++.h>

using namespace std;

void solve()
{
    // good luck big guy

    int n;

    cin >> n;

    map<int, array<int, 10>> mp;

    for (int i = 0; i < n; i++)
    {
        string s;

        cin >> s;

        for (int i = 0; i < 10; i++)
        {
            int tmp = s[i] - '0';
            mp[tmp][i]++;
        }
    }

    // read over all digits
    int ans = INT_MAX;

    for (int i = 0; i < 10; i++)
    {
        // create queue for each digit based on the array tally

        queue<pair<int, int>> q;

        for (int j = 0; j < 10; j++)
        {
            if (mp[i][j])
            {
                q.push({j, mp[i][j]});
            }
        }

        // loop over the q until it is empty

        int prev = -1;
        int val = 0;

        while (!q.empty())
        {
            pair<int, int> cur = q.front();
            q.pop();

            if (cur.second > 1) q.push({cur.first, cur.second - 1});

            // process the cur
            if (cur.first < prev)
            {
                // wrap the value around 10
                val += (10 - prev) + cur.first;
            } else if (cur.first == prev){
                // add the 10 oof
                val += 10;
            } else {
                // find the difference
                if (prev == -1) val += cur.first;
                else val += (cur.first - prev);
            }

            prev = cur.first;   
        }

        ans = min(ans, val);
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

