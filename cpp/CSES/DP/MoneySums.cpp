#include <bits/stdc++.h>
#include <cmath>

using namespace std;

int maxn = 1e5;

int main()
{

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n;

  cin >> n;

  int total = 0;

  int vals[n + 1];

  for (int i = 1; i <= n; i++)
  {
    int cur;
    cin >> cur;
    vals[i] = cur;
    total += cur;
  }

  // cout << total << "\n";
  bool arr[total + 1];
  int count = 0;

  for (int j = 0; j <= total; j++)
  {
    arr[j] = 0;
  }

  arr[0] = true;

  string out = "";

  for (int k = 1; k <= n; k++)
  {
    for (int w = total; w >= 0; w--)
    {
      if (arr[w]) {
        if (!arr[w+vals[k]]) count++;
        arr[w+vals[k]] = true;
      } 
    }
  }

  cout << count << "\n";
  for (int i = 1; i <= total; i++) {
    if (arr[i]) cout << i << " "; 
  }

  return 0;
}
