/* ____  _____  ________  ________  ______     ____    ____   ___   _______     ________   ______        _     _________  _____  ___  ____   
|_   \|_   _||_   __  ||_   __  ||_   _ `.  |_   \  /   _|.'   `.|_   __ \   |_   __  | |_   _ \      / \   |  _   _  ||_   _||_  ||_  _|  
  |   \ | |    | |_ \_|  | |_ \_|  | | `. \   |   \/   | /  .-.  \ | |__| |    | |_ \_|   | |_| |    / _ \  |_/ | | \_|  | |    | |_/ /    
  | |\ \| |    |  _| _   |  _| _   | |  | |   | |\  /| | | |   | | |  __ /     |  _| _    |  __'.   / ___ \     | |      | |    |  __'.    
 _| |_\   |_  _| |__/ | _| |__/ | _| |_.' /  _| |_\/_| |_\  `-'  /_| |  \ \_  _| |__/ |  _| |__| |_/ /   \ \_  _| |_    _| |_  _| |  \ \_  
|_____|\____||________||________||______.'  |_____||_____|`.___.'|____| |___||________| |_______/|____| |____||_____|  |_____||____||____| 
*/

#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
#define vi vector<int>
#define vll vector<ll>
#define pi pair<int, int>
#define f first
#define s second
#define pb push_back
const int MAX = 1e9;

void solve()
{
    int n, q;

    cin >> n >> q;

    vi in(n+1), out(n+1), arr(n+1);
    
    fill(begin(in), end(in), -1);
    fill(begin(out), end(out), -1);

    for (int i = 0; i < n; i++) cin >> arr[i];

    int cur = 1;

    in[max(arr[0], arr[1])] = 1;
    cur = max(arr[0], arr[1]);

    for (int i = 2; i < n; i++)
    {
        if (arr[i] > cur)
        {
            out[cur] = i;
            in[arr[i]] = i;
            cur = arr[i];
        }
    }

    while (q--)
    {
      int i, k; cin >> i >> k;
      i--; 
      if (in[arr[i]] == -1){
          cout << "0\n";
          continue;
      }
      if (arr[i] != n){
          if (k < in[arr[i]]) cout << "0\n";
          else {
              cout << (min(k + 1, out[arr[i]]) - in[arr[i]]) << '\n';
          }
      }
      else{
          if (k < in[arr[i]]) cout << "0\n";
          else{
              //cout << tin[a[i]] << " IN\n";
              //cout << 1 + (k + n) % n << '\n';
              cout << (k / n) * n + 1 + (k + n) % n - in[arr[i]] << '\n';
          }
      }
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

