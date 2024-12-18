#include <bits/stdc++.h>
#include <cmath>

using namespace std;

int const INF = 1e9;

int main()
{

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n, m;

  cin >> n >> m;

  vector<vector<int>> dist(n+1, vector<int>(n+1, INF));

  for (int i = 0; i <= n; i++)
    dist[i][i] = 0;

  for (int i = 0; i < m; i++)
  {
    int a, b, w;

    cin >> a >> b >> w;

    dist[a][b] = min(dist[a][b], w);
  }

  // run bellman ford for each node
  int k, q;
  cin >> k >> q;

  k = min(k, n);
  k--;

  // cout << k << "\n";
  auto sol = dist;

  while (k--)
  {
    auto cursol = sol;
    for (int i = 1; i <= n; i++)
    {
      for (int j = 1; j <= n; j++)
      {
        for (int z = 1; z <= n; z++)
        {
          cursol[i][j] = min(cursol[i][j], sol[i][z] + dist[z][j]);
        }
      }
    }
    sol = cursol;
  }

  while (q-- > 0)
  {
    int x, y;
    cin >> x >> y;

    long long ans = sol[x][y] == INF ? -1 : sol[x][y];

    cout << ans << "\n";
  }

  return 0;
}
