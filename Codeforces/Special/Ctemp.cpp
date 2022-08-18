#include <bits/stdc++.h>

using namespace std;

void solve()
{
    int n,q;
    cin >> n >> q;

    vector<int> arr(n);
    vector<bool> first(n);

    fill(begin(arr), end(arr), 0);
    fill(begin(first), end(first), 0);
    int cmax = 0;

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
        if (i && arr[i] > cmax) first[i] = 1;
        cmax = max(cmax, arr[i]);
    }

    while (q--)
    {
        int ind, k;

        cin >> ind >> k;
        ind--;
        int ans = 0;

        if (arr[ind] == n)
        {
            cout << k - ind << "\n";
            continue;
        }

        // check to see if we can win from the first round
        if (ind)
        {
            if (!first[ind] || (k - ind) < 0)
            {
                cout << "0\n";
                continue;
            }
            ans++;
            k -= ind;
        } 

        // find the index of the first node that is greater than arr[ind] given the configuration when arr[ind] is at the front of the row
        // first perform a forward sweep to try to find the first element
        bool found = 0;

        for (int pt = ind + 1; pt < n && !found; pt++)
        {
            if (arr[pt] > arr[ind])
            {
                found = 1;
                if (pt - ind - 1 <= k)
                {
                    ans += pt - ind - 1;
                }
            }
        }

        int a = 0, b = 1, opp = n - ind;

        while (b < ind && a < ind && !found)
        {
            opp++;
            if (a < b)
            {
                if (arr[b] > arr[ind])
                {
                    // we have met our match
                    found = 1;
                    ans += min(opp, k);
                }
                a = b;
                b++;
            } else {
                if (arr[a] > arr[ind])
                {
                    // we have met our match
                    found = 1;
                    ans += min(opp, k);
                } else b++;
            }   
        }

        cout << ans << "\n";
    }
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

