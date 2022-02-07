#include <bits/stdc++.h>
#include <cmath>

using namespace std;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int t;

  cin >> t;

  while (t-- > 0) {
    int n, m;

    cin >> n >> m;

    string out = "";

    for (int i = (int)ceil(m / 2.0); i >= 1; i--) {
      for (int j = (int)ceil(n / 2.0); j >= 1; j--) {
        int fact = 4;
        if (m % 2 == 1 && i == m / 2) fact /= 2;
        if (n % 2 == 1 && j == n / 2) fact /= 2;

        if (m % 2 == 1 && i == 1) fact /= 2;
        if (n % 2 == 1 && j == 1) fact /= 2;

        int dist = abs(m - i) + abs(n - j);

        // cout << i << " " << j << "\n";


        for (int k = 0; k < fact; k++) {
          out = out + to_string(dist) + " "; 
        }
      }
    }

    cout << out << "\n";
  }

  return 0;
}