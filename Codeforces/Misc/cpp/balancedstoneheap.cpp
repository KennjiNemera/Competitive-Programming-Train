#include <bits/stdc++.h>
#include <cmath>

using namespace std;

vector<int> arr;

bool validate(int x) {

  // the idea is to check if we move stones to the right while keeping atleast x stones at the current heap.
  // if we have arr[i] < x, that means x is too large to ensure that all heaps have a height greater than it.

  vector<int> temp(arr.size());
  
  copy(arr.begin(), arr.end(), temp.begin());

  for (int i = arr.size() - 1; i >= 2; i--) {

    if (temp[i] < x) return false;

    int d = floor(min(arr[i], temp[i] - x) / 3);

    temp[i-1] += d;
    temp[i-2] += 2 * d;
  }

  return temp[0] >= x && temp[1] >= x;
}

int main() {
  
  // io settings
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int t;

  cin >> t;

  while (t-- > 0) {
    int n, maxval;
    cin >> n;

    arr.clear();

    maxval = 0;

    for (int i = 0; i < n; i++) {
      int a;
      cin >> a;
      maxval = max(maxval, a);
      arr.push_back(a);
    }

    // perform binary search for max x
    int lo = 0;
    int hi = maxval;
    int ans = -1;

    while (lo <= hi) {
      int x = (lo + hi) / 2;

      if (validate(x)) {
        ans = x;
        lo = x + 1;
      } else {
        hi = x - 1;
      }
    }

    cout << ans << "\n";
  }

  return 0;
}