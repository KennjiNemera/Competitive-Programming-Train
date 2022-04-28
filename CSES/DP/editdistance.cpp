#include <bits/stdc++.h>

using namespace std;

const int maxn = 5001;

int dp[maxn][maxn];

int main()
{
	string a;
	string b;

	cin >> a >> b;

	int alen = a.size();
	int blen = b.size();

	// fill 0 r,c with val
	for (int i = 1; i <= max(alen, blen); i++)
	{
		dp[0][i] = i;
		dp[i][0] = i;
	}

	for (int i = 1; i <= alen; i++) {
		for (int j = 1; j <= blen; j++) {

			int cost;

			if (a[i-1] == b[j-1]) 
			{
				cost = 0;
			} else cost = 1;

			dp[i][j] = min(min(dp[i][j-1], dp[i-1][j]) + 1, dp[i-1][j-1] + cost);
		}
	}

//	for (int i = 0; <F5>i < max(alen, blen) + 1; i++)
//	{
//		for (int j = 0; j < max(alen, blen) + 1; j++)
//		{	
//			cout << dp[i][j] << " ";
//		}
//		cout << "\n";
//	}


	cout << dp[alen][blen] << "\n";
}
