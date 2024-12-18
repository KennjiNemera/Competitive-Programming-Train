#include <bits/stdc++.h>

using namespace std;

const int maxn = 50002, maxs = 2001;

long long dp[maxn][maxs][2];

int main() {
	int s, n;

	struct item
	{
		int v, w, k;
	};

	cin >> s >> n;

	struct item arr[n+1];

	// v -> value
	// w -> weight
	// k -> copies

	for (int i = 1; i <= n; i++) {
		int a, b, c;
		cin >> a >> b >> c;

		arr[i] = {a,b,c};
	}

	// we find that our dp array will have 3 dimensions of [n][w]

	// at dp[i][j] -> we find the number of item i used to have a total value of j

	long long ans = 0;
	
	// practice with a 0-1 knapsack
	for (int i = 1; i <= n; i++)
	{
		for (int j = 0; j <= s; j++)  
		{
			/* 
			 	we must keep weight in mind
			       	we must keep the number of uses of the current item in mind	
				
				a cell can either be reached from an earlier state in the same row or through the row above j
			*/		
            dp[i][j][0] = dp[i-1][j][0];            

			if (j - arr[i].w >= 0) {
				long long trans = dp[i-1][j-arr[i].w][0] + (long long)arr[i].v;
				if (trans > dp[i][j][0]) 
				{
					dp[i][j][0] = trans; 
					dp[i][j][1] = 1;
				} else if (trans == dp[i][j][0])
                {
                    dp[i][j][1] = min(dp[i][j][0], 1ll);
                }
            }


			if (j - arr[i].w >= 0 && dp[i][j-arr[i].w][1] < arr[i].k) {
				long long trans = dp[i][j-arr[i].w][0] + (long long)arr[i].v;
				if (trans > dp[i][j][0]) 
				{
					dp[i][j][0] = trans; 
					dp[i][j][1] = dp[i][j - arr[i].w][1] + 1;
				} else if (trans == dp[i][j][0]) {
					dp[i][j][1] = min(dp[i][j-arr[i].w][1] + 1, dp[i][j][1]); 
				}
			}

			ans = max(ans, dp[i][j][0]);
		}
	}

	cout << ans << "\n";
	
	return 0;
}


