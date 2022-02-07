#include <bits/stdc++.h>
#include <cmath>

using namespace std;

int const maxn = 100005;

vector<pair<int, int>> adj[maxn];
vector<pair<int, int>> vect;
bool vis[maxn] = {0};
int comp[maxn] = {0};
int level = 0;
int clvl = 1;

bool sortbesec(const pair<int, int> &a, const pair<int, int> &b)
{
  return (b.second < a.second);
}

void dfs(int a, int type, int cid)
{
  // track entry
  if (vis[a])
    return;
  level++;
  vis[a] = true;
  if (type == 1) {
    comp[a] = cid;
  }

  int cur = level;

  // push to children
  for (pair<int, int> child : adj[a])
  {
    if (child.second != type) continue;
    dfs(child.first, type, cid);
  }

  // track exit and push to exit list
  
  if (type == 0) {
    level++;
    int exitlvl = level;
    pair<int, int> test = make_pair(a, exitlvl);

    // cout << a << " " << test.first << " " << test.second << "\n";
    vect.push_back(test);    
  }
}

int main()
{

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n, m;

  cin >> n >> m;

  // build the adjacency list
  for (int i = 0; i < m; i++)
  {
    int a, b;
    cin >> a >> b;

    a--;
    b--;

    adj[a].push_back(make_pair(b, 0));
    adj[b].push_back(make_pair(a, 1));
  }

  // run the first dfs and keep track of entry and exit;
  for (int i = 0; i < n; i++)
  {
    if (!vis[i])
    {
      dfs(i, 0, -1);
    }
  }

  sort(vect.begin(), vect.end(), sortbesec);

  // run the second dfs now building components
  std::fill_n(vis, maxn, false);

  for (int i = 0; i < vect.size(); i++)
  {
    if (!vis[vect[i].first])
    {
      dfs(vect[i].first, 1, clvl);
      clvl++;
    }
  }

  cout << (clvl-1) << "\n";

  for (int i = 0; i < n; i++) {
    cout << comp[i] << " ";
  }

  return 0;
}
