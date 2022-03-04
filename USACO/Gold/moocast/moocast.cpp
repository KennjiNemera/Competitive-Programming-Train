#include <bits/stdc++.h>
#include <cmath>
#include <cstdio>
#include <iostream>

using namespace std;

vector<int> size;
vector<int> par;
const int INF = 1e9;

struct edge
{
  int i, j, w;
};

// CREATE DSU FUNCTIONS

int find(int a)
{
  while (par[a] != a)
    a = par[a];
  return a;
}

void unite(int a, int b)
{
  int apar = find(a);
  int bpar = find(b);

  if (size[apar] < size[bpar])
  {
    swap(apar, bpar);
  }

  par[bpar] = apar;
  size[apar] += size[bpar];
}

bool edgeSort(edge a, edge b)
{
  return a.w < b.w;
}

int main()
{

  freopen("moocast.in", "r", stdin);
  freopen("moocast.out", "w", stdout);

  int n;

  // Don't forget that we need file input

  cin >> n;

  // SETUP THE DSU
  for (int i = 0; i < n; i++)
  {
    size.push_back(1);
    par.push_back(i);
  }

  vector<pair<int, int>> vect;

  for (int i = 0; i < n; i++)
  {
    int x, y;
    cin >> x >> y;

    x--;
    y--;

    vect.push_back(make_pair(x, y));
  }

  vector<edge> edges;

  for (int i = 0; i < n - 1; i++)
  {
    pair<int, int> cur = vect[i];
    int ax = cur.first;
    int ay = cur.second;
    for (int j = i + 1; j < n; j++)
    {
      pair<int, int> next = vect[j];
      int bx = next.first;
      int by = next.second;

      int w = (ax - bx) * (ax - bx) + (ay - by) * (ay - by);
      edges.push_back({i, j, w});
    }
  }
  // sort the edges in ascending order or weight
  sort(edges.begin(), edges.end(), edgeSort);

  int curAns = INF;

  int numComp = n;
  
  // we are essentially building a MST
  for (edge e : edges)
  {
    if (find(e.i) != find(e.j))
    {
      unite(e.i, e.j);
      curAns = e.w;
      numComp--;
      if (numComp == 1)
      {
        break;
      }
    }
  }

  cout << curAns << "\n";
}