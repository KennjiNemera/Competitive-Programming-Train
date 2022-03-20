#include <bits/stdc++.h>

using namespace std;

int main() {
	int w, n;

	struct item
	{
		int v, w, k;
	};

	cin >> w >> n;

	struct item arr[n];

	for (int i = 0; i < n; i++) {
		int a, b, c;
		cin >> a >> b >> c;

		arr[i] = {a,b,c};
	}

	// we find that our dp array will have 3 dimensions of [n][w]

	// at dp[i][j] -> we find the number of item i used to have a total value of j

	int[][

	return 0;
}
