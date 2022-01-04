#include <bits/stdc++.h>
#include <cmath>

using namespace std;

int main()
{
  int t;
  cin >> t;

  while (t-- > 0)
  {
    int m, n, rb, cb, rd, cd;

    cin >> n >> m >> rb >> cb >> rd >> cd;

    int rowmatch, colmatch;

    if (rb <= rd)
    {
      rowmatch = rd - rb;
    }
    else
    {
      rowmatch = 2 * n - rb - rd;
    }

    if (cb <= cd)
    {
      colmatch = cd - cb;
    }
    else
    {
      colmatch = 2 * m - cb - cd;
    }

    int ans = min(rowmatch, colmatch);

    cout << ans << "\n";
  }

  return 0;
}