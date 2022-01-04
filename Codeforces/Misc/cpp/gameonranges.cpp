#include <bits/stdc++.h>
#include <cmath>

using namespace std;

int main()
{
  int t;
  cin >> t;

  while (t-- > 0)
  {
    int n;
    cin >> n;

    bool arr[n + 1][n + 1] = {0};
    pair<int, int> ranges[n];

    for (int i = 0; i < n; i++)
    {
      int x, y;

      cin >> x >> y;

      ranges[i] = make_pair(x, y);

      arr[x][y] = true;
    }

    for (pair<int, int> p : ranges) {
      int l = p.first;
      int r = p.second;
      int ans = -1;

      if (l == r) {
        ans = l;
      } else if (arr[l+1][r]) {
        ans = l;
      } else if (arr[l][r-1]) {
        ans = r;
      } else {
        for (int i = l + 1; i < r; i++) {
          if (arr[l][i-1] && arr[i+1][r]) {
            ans = i;
            break;
          }
        }
      }

      cout << l << " " << r << " " << ans << "\n";
    }

    cout << "\n";
  }

  return 0;
}