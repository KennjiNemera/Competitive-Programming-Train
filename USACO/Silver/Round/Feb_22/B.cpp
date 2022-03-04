#include <bits/stdc++.h>
#include <cmath>
#include <iostream>
#include <string>
#include <list>

using namespace std;

int countVal;
long long xg, yg;

void sum(vector<pair<long long, long long>> l)
{
  long long x = 0;
  long long y = 0;

  for (int i = 0; i < l.size(); i++) {
    x += l[i].first;
    y += l[i].second;
  }

  // cout << x << " " << y << "\n";

  if (x == xg && y == yg)
  {
    countVal++;
  }
}

void subset(vector<pair<long long, long long>> arr, int size, int left, int index, vector<pair<long long, long long>> &l)
{
  if (left == 0)
  {
    sum(l);
    return;
  }
  for (int i = index; i < size; i++)
  {
    l.push_back(arr[i]);
    subset(arr, size, left - 1, i + 1, l);
    l.pop_back();
  }
}

int main()
{

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  // we love the brute force

  int n;
  vector<pair<long long, long long>> moves;

  cin >> n >> xg >> yg;

  for (int i = 0; i < n; i++)
  {
    long long a, b;
    cin >> a >> b;
    moves.push_back(make_pair(a, b));
  }

  for (int k = 1; k <= n; k++)
  {
    // generate all subsets
    countVal = 0;
    vector<pair<long long, long long>> lt;
    subset(moves, n, k, 0, lt);
    cout << countVal << "\n";
  }

  return 0;
}
