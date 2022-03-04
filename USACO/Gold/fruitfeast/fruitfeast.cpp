#include <bits/stdc++.h>
#include <iostream>
#include <cmath>

using namespace std;

#define inp(s) freopen(s, "r", stdin);
#define out(s) freopen(s, "w", stdout);

#define fr(i, a, b) for (int i = a; i <= b; i++)

bool dp[2][5000001];

int main()
{
  inp("feast.in");
  out("feast.out");

  int t, a, b;

  cin >> t >> a >> b;

  int w[2] = {a, b};

  dp[0][0] = true;

  int best = 0;

  for (int i = 0; i <= t; i++)
  {
    if (i - a >= 0)
      dp[0][i] |= dp[0][i - a];
    if (i - b >= 0)
      dp[0][i] |= dp[0][i - b];

    dp[1][i / 2] |= dp[0][i];
  }

  for (int i = 0; i <= t; i++)
  {
    if (i - a >= 0)
      dp[1][i] |= dp[1][i - a];
    if (i - b >= 0)
      dp[1][i] |= dp[1][i - b];
  }

  for (int i = t; i >= 0; i--)
  {
    if (dp[1][i]) {
      cout << i << "\n";
      break;
    }
  }

  return 0;
}