#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;

int main() {
	int n;
	cin >> n;

	int sum_elem = n * (n + 1) / 2;

	// can't split it up between two subsets evenly
	if (sum_elem & 1) {
		cout << 0 << endl;
		return 0;
	}

	// each subset's sum needs to be half of the total sum.
	sum_elem /= 2;
	
	// dp[i][j] = the number of ways to make sum j with the numbers from 1 to i
	vector<vector<int>> dp(n, vector<int>(sum_elem + 1));

	// base case: there is one way to make a sum of zero with zero elements.
	dp[0][0] = 1;
	for (int i = 1; i < n; i++) {
		for (int j = 0; j <= sum_elem; j++) {
			// there are dp[i - 1][j] possibilities if we don't include the ith element
			dp[i][j] += dp[i - 1][j];

			// previous sum by including the current element
			int prev = j - i;
			
			if (prev >= 0) {
				dp[i][j] += dp[i - 1][prev];
			}

			dp[i][j] %= MOD;
		}
	}

	cout << dp[n - 1][sum_elem] << '\n';
}
