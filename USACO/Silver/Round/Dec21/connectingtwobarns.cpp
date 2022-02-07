#include <bits/stdc++.h>
#include <cmath>
#include <set>

using namespace std;

void dfs(vector<vector<int>> &list, vector<int> &comp, int curv, int id)
{
  // cout << "oof" << "\n";
  for (int child : list[curv])
  {
    if (comp[child] != id)
    {
      comp[child] = id;
      dfs(list, comp, child, id);
    }
  }
}

void solve()
{
  int n, m;

  cin >> n >> m;

  // std::cout << "test \n";

  vector<vector<int>> list(n); // remember to define size of vector

  for (int i = 0; i < m; i++)
  {
    int a, b;
    cin >> a >> b;
    a--;
    b--;

    list[a].push_back(b);
    list[b].push_back(a);
  }

  // perform dfs and build a component array
  vector<int> comp(n, -1);

  for (int i = 0; i < n; i++)
  {
    if (comp[i] == -1)
    {
      comp[i] = i;
      dfs(list, comp, i, i); // pass dfs params
    }
  }

  // if already in the same component, break!
  if (comp[0] == comp[n - 1])
  {
    cout << 0 << "\n";
    return;
  }

  vector<long long> src(n, 1e9);
  vector<long long> dst(n, 1e9);
  vector<vector<int>> compGraph(n);

  for (int i = 0; i < n; i++)
  {
    compGraph[comp[i]].push_back(i);
  }

  int srcid = 0;
  int dstid = 0;

  for (int i = 0; i < n; i++)
  {
    // each node in the barn component is a possible pairing node
    while (srcid < compGraph[0].size())
    {
      src[comp[i]] = min(src[comp[i]], (long long)abs(i - compGraph[comp[0]][srcid]));
      if (compGraph[comp[0]][srcid] < i)
        srcid++;
      else
        break;
    }

    if (srcid) srcid--;

    while (dstid < compGraph[comp[n-1]].size())
    {
      dst[comp[i]] = min(dst[comp[i]], (long long)abs(i - compGraph[comp[n-1]][dstid]));
      if (compGraph[comp[n-1]][dstid] < i)
        dstid++;
      else
        break;
    }

    if (dstid) dstid--;
  }

  long long ans = 1e18;
  // loop through the nodes to find the cheapest intermediate pair
  for (int i = 0; i < n; i++)
    ans = min(ans, src[i] * src[i] + dst[i] * dst[i]);

  cout << ans << "\n";
}

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int t;

  cin >> t;

  // here we will practice our solve function because that is always good to do right

  for (int i = 0; i < t; i++)
  {
    solve();
    // cout << "oof \n";
    // cout.flush();
  }

  return 0;
}
