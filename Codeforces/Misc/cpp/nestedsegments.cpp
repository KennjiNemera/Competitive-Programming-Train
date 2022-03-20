#include <bits/stdc++.h>

using namespace std;

void solve() {
	int n;

	pair<int, int> arr[n];

	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;

		arr[i] = make_pair(a, b);
	}

	sort(arr, arr + n);

	
}


int main() {
	int t;

	cin >> t;

	while (t-- > 0) {
		solve();
	}	
}
