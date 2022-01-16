#include <bits/stdc++.h>
#include <cmath>

using namespace std;


bool is_prime(int val) {
  for (int i = 2; i <= sqrt(val); i++) {
    if (val % i == 0) return false;
  }
  return true;
}

int main() {

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  
  int t;
  cin >> t;

  bool sieve[30];

  // cout << sieve[2] << "\n";

  // generate the sieve to save time
  for (int i = 2; i <= 29; i++) {
    if (sieve[i]) continue;
    for (int j = 2; j * i <= 29; j++) {
      sieve[i*j] = true;
    }
  }

  while (t-- > 0) {
    int val;
    cin >> val;

      // search for the first value
    int a;

    for (int i = 2; i <= (int) pow(10,9); i++) {
      if (sieve[i]) {
        // cout << "not prime: " << i << "\n";
        continue;
      }
      if ((val - i - 1) % i != 0) {
        a = i;
        break;
      }
    }

    string out = to_string(a) + " " + to_string((val - a - 1)) + " 1";
    cout << out << "\n";      
  }

  return 0;
}
