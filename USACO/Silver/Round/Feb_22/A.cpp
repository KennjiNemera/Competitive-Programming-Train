#include <bits/stdc++.h>
#include <cmath>

using namespace std;

bool arr[501];

int main()
{

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n;
  
  cin >> n;

  vector<vector<int>> rows(n);
  vector<pair<int, int>> len;

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      int cur;
      cin >> cur;

      if (cur == i + 1) {
        len.push_back(make_pair(j+1, i));
      }

      rows[i].push_back(cur);
    }
  }

  // sort by selectivity
  sort(len.begin(), len.end());

  int ansArr[n] = {0};

  for (int i = 0 ; i < n; i++) {
    int pos = len[i].second;
    for (int j = 0; j < n; j++) {
      int cur = rows[pos][j];
      if (!arr[cur]) {
        ansArr[pos] = cur;
        arr[cur] = 1;
        break;
      }
    }
  }

  for (int i = 0; i < n; i++) {
    cout << ansArr[i] << "\n";
  }

  return 0;
}
