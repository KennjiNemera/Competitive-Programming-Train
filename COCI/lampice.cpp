#include <bits/stdc++.h>
#include <cmath>

using namespace std;

int main() {

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n, k;

  cin >> n >> k;

  int arr[n];

  for (int i = 0; i < n; i++) cin >> arr[i];

  for (int l = 1; l <= (n / k); l++) {
    // l controls the length of the current search
    for (int i = 0; i + (l * k) - 1 < n; i++) {
      // i controls the start of the current pattern
      // cout << "i: " << i << "\n";
      bool valid = true;
      for (int j = 1; j < k && valid; j++) {
        // j controls the index sequence that we are currently checking
        for (int p = 0; p < l; p++) {
          valid &= (arr[i + j*l + p] == arr[i + p]);
          // cout << valid << "\n";
        }
      }

      if (valid) {
        cout << l << "\n";
        for (int m = 0; m < l; m++) {
          cout << arr[i+m] << " ";
        }
        return 0; 
      }
    }
  }

  cout << "-1 \n";
  return 0;
}
