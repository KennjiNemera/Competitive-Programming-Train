#include <bits/stdc++.h>

using namespace std;

const int N = 1e5 + 5;
vector<int> factors[N];

void runFacts() {
    for (int i = 1; i < N; i++) {
        for (int j = i; j < N; j += i) {
            factors[j].push_back(i);
        }
    }
}

void solve() {
    int n, m;
    cin >> n >> m;
    int a[n];
    for (int i = 0; i < n; i++) cin >> a[i];
    sort(a, a + n);

    int freq[m + 1];
    for (int i = 0; i <= m; i++) freq[i] = 0;

    int count = 0;
    int ans = INT_MAX;
    for (int l = 0, r = 0; r < n; r++) {
        
        // add student
        for (int x : factors[a[r]]) {
            if (x > m) break;
            if (!freq[x]) count++;
            freq[x]++;
        }

        while (count == m) {
            ans = min(ans, abs(a[r] - a[l]));
            for (int x : factors[a[l]]) {
                if (x > m) break;
                if (freq[x] == 1) count--;
                freq[x]--;
            }
            l++;
        }
    }
    if (ans == INT_MAX) cout << "-1\n";
    else cout << ans << endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    int t = 1;
    runFacts();
    cin >> t;
    for (int i = 0; i < t; i++) {
        solve();
    }
}

