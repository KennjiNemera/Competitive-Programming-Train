#include <bits/stdc++.h>

using namespace std;


void solve() 
{
	int n;

	cin >> n;

	int a, b;

	a = 0;
	b = n;

	string str;

	cin >> str;

	int cur = 0;

	while (cur < n - 1)
	{
		if (str[cur] == ')')
		{
			// run search for the next )

			int run = cur + 1;

			while (run < n && str[run] == '(') run++;

			if (run >= n)
			{
				// we are finished
				break;
			} else {
				// we perform the operation as it is a symmetrical prefix
				a++;
				b -= (run - cur + 1);
				cur = run + 1;
			}
		} else 
		{
			a++;
			b-=2;
			cur += 2;
		}
	}

	cout << a << " " << b << "\n";

	return;
}


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int t;
	
	cin >> t;

	while (t-- > 0)
	{
		solve();
	}
	
	return 0;	
}
