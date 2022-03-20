#include <bits/stdc++.h>

using namespace std;

void solve() {
  int n;

  cin >> n;

  pair<int, int> arr[n];

  for (int i = 0; i < n; i++) {
    int val;
    cin >> val;
    arr[i] = make_pair(val, i + 1);
  }

  sort(arr, arr + n);

  int ans[n] = {0};

  int init = arr[n-1].second % n;

  ans[n - 1] = init;

  for (int j = n - 2; j >= 1; j--) {
    int prev = arr[j + 1].second;
    int cur = arr[j].second;

    int dist;

    if (prev < cur) {
      dist = (n - cur) + prev - 1;
    } else {
      dist = prev - cur - 1;
    }

    ans[j] = dist;
  }

  for (int i = 0; i < n; i++) {
    cout << ans[i] << " ";
  }
  cout << "\n";
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int t;

  cin >> t;

  while (t-- > 0) {
    solve();
  }
}