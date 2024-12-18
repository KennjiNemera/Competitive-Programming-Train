#include <bits/stdc++.h>

using namespace std;

void solve() {
    int n;
    cin >> n;
    if (n % 2) {
        // odd case
        if (n >= 27) {
            // int ones[] = {1,9,26}
            // int twos[] = {10,27}    
            int pos = 1;
            int point = 3;
            for (int pos = 1; pos <= 27; ) {
                if (pos == 1 || pos == 10 || pos == 26) {
                    cout << "1 ";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while (t--) solve();    
 }
