#include <bits/stdc++.h>
#include <cmath>

using namespace std;

struct edge {
  int a, b;
  int w;
};

int main()
{

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n, m;

  cin >> n >> m;

  int dist[n][n];

  vector<edge> edges;

  for (int i = 0; i < m; i++) {
    int a, b, w;

    struct edge cur;

    cin >> a >> b >> w;

    cur.a = a;
    cur.b = b;
    cur.w = w;

    edges.push_back(cur); 
  }

  // run bellman ford for each node
  int k, q;
  cin >> k >> q;

  for (int i = 1; i < n; i++) {
    
  }


  return 0;
}
