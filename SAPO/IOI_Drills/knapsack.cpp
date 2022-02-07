#include <bits/stdc++.h>
#include <cmath>

using namespace std;

int unboundedKS(int vals[], int weight[], int n, int w)
{
  int dp[w + 1] = {0};

  for (int i = 0; i <= w; i++)
  {
    for (int j = 0; j < n; j++)
    {
      if (weight[j] <= i)
        dp[i] = max(dp[i], dp[i - weight[j]] + vals[j]);
    }
  }

  return dp[w];
}

int classicKS(int vals[], int weight[], int n, int w)
{
  int dp[n + 1][w + 1];

  for (int i = 0; i <= n; i++)
  {
    for (int j = 0; j <= w; j++)
    {
      dp[i][j] = 0;
    }
  }

  for (int i = 0; i <= n; i++)
  {
    for (int j = 0; j <= w; j++)
    {
      if (i == 0 || j == 0)
        continue;
      else if (j >= weight[i - 1])
      {
        dp[i][j] = max(vals[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
      }
      else
      {
        dp[i][j] = dp[i - 1][j];
      }
    }
  }

  return dp[n][w];
}

int main()
{

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n, w;

  cin >> n >> w;

  int vals[n];
  int weight[n];

  for (int i = 0; i < n; i++)
  {
    int a, b;
    cin >> a >> b;

    vals[i] = b;
    weight[i] = a;
  }

  cout << unboundedKS(vals, weight, n, w) << " " << classicKS(vals, weight, n, w) << "\n";

  return 0;
}
