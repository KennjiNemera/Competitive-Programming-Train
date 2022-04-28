#include <bits/stdc++.h>

using namespace std;

struct edge {
	int x,y,w;
};

bool comp(edge a, edge b)
{
	return a.w < b.w;
}

const int maxn = 501;
int link[maxn * maxn];
int sz[maxn * maxn];

int par(int x)
{
	while (link[x] != x) x = link[x];
	return x;
}

bool same(int a, int b) {
	return par(a) == par(b);
}

void unite(int a, int b)
{
	int apar, bpar;

	apar = par(a);
	bpar = par(b);

	if (sz[apar] < sz[bpar]) {
		swap(apar, bpar);
	}

	sz[apar] += sz[bpar];
	link[bpar] = apar;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	freopen("tractor.in", "r", stdin);
	freopen("tractor.out", "w", stdout);

	int n;

	cin >> n;

	int arr[n][n];

	vector<edge> edges;

	for (int i = 0; i < n; i++) 
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];

			if (j % n != 0)
			{
				struct edge temp;

				temp.x = (i * n + j);
				temp.y = (i * n + (j - 1));
				temp.w = abs(arr[i][j] - arr[i][j-1]);

				edges.push_back(temp);
			}

			if (i != 0)
			{
				struct edge temp;

				temp.x = (i * n + j);
				temp.y = ((i - 1) * n + j);
				temp.w = abs(arr[i][j] - arr[i-1][j]);

				edges.push_back(temp);	
			}	
		}

	sort(edges.begin(), edges.end(), comp);

	// init the DSU

	for (int i = 0 ; i < n * n; i++)
	{
		link[i] = i;
		sz[i] = 1;
	}	

	// TIME FOR KRUSKAL
	int len = 0, ans = 0;
	
	for (edge e : edges)
	{
		if (!same(e.x, e.y)) {
			unite(e.x, e.y);

		//	cout << e.x << " : " << e.y << " : " << e.w << "\n";
		//	cout << sz[par(e.x)] << "\n";

			int temp = sz[par(e.x)];

			len = max(len, temp);

			if (len >= ceil((n * n) / 2)) {
				ans = e.w;
 				break;				
			}	
		}
	}

	cout << ans << "\n";

	return 0;
}
