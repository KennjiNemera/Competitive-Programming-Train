#include <bits/stdc++.h>

using namespace std;

void solve() {
    // we want to find the most common value in the array
    int n;
    cin >> n;
    int cur, next, count, max_count;
    cin >> cur;
    count = 1;
    max_count = count;
    for (int i = 1; i < n; i++) {
        cin >> next;
        if (next == cur) count++;
        else {
            max_count = max(max_count, count);
            count = 1;
        }
        cur = next;
    }
    max_count = max(count, max_count);
    cout << (n - max_count) << "\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while(t--) solve();
}
