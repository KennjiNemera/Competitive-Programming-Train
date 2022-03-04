#include <bits/stdc++.h>
#include <math.h>

using namespace std;

int main() {

    int t;

    cin >> t;

    while (t-- > 0) {
        long long n, k, x;

        cin >> n >> k;

        if (n == 1) {
            cout << 0 << "\n";
            continue;
        }

        long long total = 1;
        x = 0;

        while (total < k) {
            total *= 2;
            x++;
        }

        long long temp;

        temp = (n - total + k - 1) / k; 

        x += temp;

        cout << x << '\n';
    }
}