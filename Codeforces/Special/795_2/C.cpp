#include <bits/stdc++.h>

using namespace std;

void solve()
{
    // good luck big guy
    int n, k;

    cin >> n >> k;

    int total = 0;

    int first = 0;
    int last = 0;

    string s;

    cin >> s;

    char arr[n];

    int sz = s.size();

    for (int i = 0; i < sz; i++) arr[i] = s[i];

    for (first = 0 ; first < sz; first++)
    {
        if (arr[first] == '1') break;
    }

    for (last = sz - 1; last >= first; last--)
    {
        if (arr[last] == '1') break;
    }

    if (!last) {
        cout << "0\n";
        return;
    }

    if (last == first)
    {
        if (sz - last - 1 && sz - last - 1 <= k) {
            while (sz - last - 1) {
                char temp = arr[last];
                arr[last] = arr[last+1];
                arr[last+1] = temp;
                k--;
                last++;
            }
        } else if (first && first <= k) {
           while (first)
           {
                char temp = arr[first];
                arr[first] = arr[first-1];
                arr[first-1] = temp;
                first--;
                k--;
           }
        }
    } else {
         if (sz - last - 1 && sz - last - 1 <= k) {
            while (sz - last - 1) {
                char temp = arr[last];
                arr[last] = arr[last+1];
                arr[last+1] = temp;
                k--;
                last++;
            }
        } 
         
        if (first && first <= k) {
           while (first)
           {
                char temp = arr[first];
                arr[first] = arr[first-1];
                arr[first-1] = temp;
                first--;
                k--;
           }
        }
    }

    for (int i = 0; i < sz; i++)
    {
        string cur = "";
        cur += arr[i];
        cur += arr[i+1];

        cout << "/" << cur << "/" << "\n";

        total += stoi(cur);
    }

    cout << max(0, total) << "\n";
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

