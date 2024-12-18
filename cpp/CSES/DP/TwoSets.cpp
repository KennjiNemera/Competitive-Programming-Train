#include <bits/stdc++.h>
#include <cmath>
#include <iostream>

using namespace std;

long long dp[501][125251];
int mod = 1e9 + 7;

int main()
{
  int n;

  cin >> n;

  dp[0][0] = 1;

  int total = 0;

  int maxSum = (n * (n + 1)) / 2;

  if (maxSum % 2 != 0) {
    cout << "0 \n";
    return 0;
  }

  maxSum /= 2;

  for (int i = 1; i <= n; i++)
  {
    for (int j = 0; j <= maxSum; j++)
    {
      dp[i][j] += dp[i-1][j];
      if (j - i >= 0)
      {
        dp[i][j] += dp[i-1][j-i];
      }
      dp[i][j] %= mod;
    }
  }

  // for (int i = 0; i <= n; i++) {
  //   for (int j = 0; j <= maxSum; j++) {
  //     cout << dp[i][j] << " ";
  //   }
  //   cout << "\n";
  // }

  cout << dp[n-1][maxSum] << "\n";

  return 0;
}