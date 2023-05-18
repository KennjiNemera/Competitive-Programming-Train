#include <bits/stdc++.h>

using namespace std;

bool secSort(const pair<pair<int, int>, int> &a, const pair<pair<int, int>, int> &b)
{
  return a.first.second < b.first.second;
}

bool forwardSort(const pair<pair<int, int>, int> &a, const pair<pair<int, int>, int> &b)
{
  return a.first.first < b.first.first;
}

void solve()
{
  int n, m;

  cin >> n >> m;

  pair<pair<int, int>, int> arr[m];

  for (int i = 0; i < m; i++)
  {
    int a, b;
    cin >> a >> b;

    arr[i] = make_pair(make_pair(a,b), i+1);
  }

  sort(arr, arr + m, secSort);
  sort(arr, arr + 2 * n, forwardSort);

  // find the sum
  long long ans = 0;

  for (int i = 0; i < 2 * n; i++)
  {
    ans += arr[i].first.second;
  }

  cout << ans << "\n";

  for (int i = 0; i < n; i++)
  {
    cout << arr[i].second << " " << arr[2 * n - 1 - i].second << "\n";
  }

  cout << "\n";
}

int main()
{

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  
  int t;
  cin >> t;
  while (t-- > 0)
  {
    solve();
  }
}
