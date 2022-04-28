#include <bits/stdc++.h>

using namespace std;

const int maxn = 1001;
const long long INF = pow(2, 60);

long long dp[maxn][maxn][2];
pair<int,int> chows[maxn], cgows[maxn];

long long getDist(pair<int, int> a, pair<int, int> b)
{
	long long pre = (a.first - b.first) * (a.first - b.first) + (a.second - b.second) *  (a.second - b.second);

	return pre;
}

int main() 
{

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	// setup the file
	freopen("checklist.in", "r", stdin);
	freopen("checklist.out", "w", stdout);	

	int h,g;

	cin >> h >> g;

	for (int i = 0; i < h; i++)
	{
		int a, b;

		cin >> a >> b;

		chows[i] = make_pair(a, b);
	}

	
	for (int i = 0; i < g; i++)
	{
		int a, b;

		cin >> a >> b;

		cgows[i] = make_pair(a, b);
	}

	// fill our array
	for (int i = 0; i <= h; i++)
	{
		for (int j = 0; j <= g; j++)
		{
			for (int k = 0; k < 2; k++)
			{
				dp[i][j][k] = INF;
			}
		}
	}

	dp[1][0][0] = 0;

	for (int i = 0; i <= h; i++)
	{	
		for (int j = 0; j <= g; j++)
		{
			for (int k = 0; k < 2; k++)
			{
				// verify
				if (i == 0 && !k) continue; // first row
				if (j == 0 && k) continue; // first col

				pair<int, int> source;

				if (k == 1)
				{
					source = cgows[j - 1]; // col shift
				} else {
					source = chows[i - 1]; // row shift
				}

				if (i < h)
				{
					dp[i+1][j][0] = min(dp[i+1][j][0], dp[i][j][k] + getDist(source, chows[i]));
				} 

				if (j < g)
				{
					dp[i][j+1][1] = min(dp[i][j+1][1], dp[i][j][k] + getDist(source, cgows[j]));
				}
			}
		}
	}

	cout << dp[h][g][0] << "\n";
}
