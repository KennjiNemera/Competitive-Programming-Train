#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n, val;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> val;
        if (abs(val - i) > 1) {
            cout << "NO\n";
            return;
        }
    }
    cout << "YES\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while (t--) solve(); 
}