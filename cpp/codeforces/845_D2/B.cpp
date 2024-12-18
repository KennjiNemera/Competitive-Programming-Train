#include <bits/stdc++.h>

using namespace std;

#define ll long long

const int MOD = 1e9+7;

ll getFact(ll n) {
    ll ans = 1;
    while (n >= 1) ans = (ans * n--) % MOD;
    return ans % MOD;
}

void solve() {
    ll n;
    cin >> n;
    ll fact = getFact(n);
    ll ans = fact * (n * (n - 1) % MOD) % MOD;
    cout << ans << "\n";
}

int main() {
    
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int t;
    cin >> t;

    while (t--) 
        solve();

}
