#include <bits/stdc++.h>

using namespace std;

int getIndex(vector<int> v, int target)
{
    auto it = find(v.begin(), v.end(), target);

    if (it != v.end()) {
        return (int) (it - v.begin());
    } else {
        return -1;
    }
}

void solve() {
    int n;

    cin >> n;

    vector<int> arr;

    for (int i = 0; i < n; i++) {
        int val;
        cin >> val;
        arr.push_back(val);
    }

    // for (int i = 0; i < arr.size(); i++) {
    //     cout << arr[i] << "\n";
    // }

    int prev = getIndex(arr, n);

    // cout << prev << "\n";

    int ans[n];

    // cout << "prev: " << (prev + 1) % n << "\n";

    ans[n-1] = (prev + 1) % n;

        //     for (int i = 0; i < n; i++) {
        //     cout << ans[i] << "\n";
        // }

    for (int i = n - 1; i >= 1; i--) {
        int cur = getIndex(arr, i);

        int dist;
        if (cur > prev) {
            dist = (cur - prev) % i;
        } else {
            dist = (arr.size() - prev + cur) % i; 
        }

        ans[i-1] = dist;
        // cout << "check 1";
        // cout << "\n" << prev << "\n";
        arr.erase(arr.begin() + prev);
        // cout << "check 2 \n";
        prev = getIndex(arr, i);
        // cout << "-------\n";
        // for (int i = 0; i < n; i++) {
        //     cout << ans[i] << "\n";
        // }
    }

    for (int i = 0; i < n; i++) {
        cout << ans[i] << " ";
    }
    cout << "\n";
    return;
}

int main() {
    int t;

    cin >> t;

    while (t-- > 0) {
       solve();
    }

    return 0;
}