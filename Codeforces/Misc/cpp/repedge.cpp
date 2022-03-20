#include <bits/stdc++.h>
#include <cmath>

using namespace std;

const int maxn = 75;
int n;
double arr[maxn];


int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int t;

  cin >> t;

  // we will be trying a brute force so that I don't go crazy over here

  while (t-- > 0)
  {
    cin >> n;

    for (int i = 0; i < n; i++)
      cin >> arr[i];

    // edge cases
    if (n < 3)
    {
      cout << 0 << "\n";
      continue;
    }

    // pair two nodes and simulate that arithmetic progression

    int ans = 75;

    for (int i = 0; i < n - 1; i++)
    {
      for (int j = i + 1; j < n; j++)
      {
        double d = (double)(arr[j] - arr[i]) / (j - i);        
        int count = 0;
        for (int k = 0; k < n; k++) {
          if (k == i || k == j) continue;
          double temp = (double)(arr[i] - arr[k]) / (i - k);
          if (temp != d) count++;
        }

        ans = min(count, ans);
      }
    }

    cout << ans << "\n";
  }
  return 0;
}
