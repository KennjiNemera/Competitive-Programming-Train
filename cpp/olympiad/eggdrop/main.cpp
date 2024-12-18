#include <bits/stdc++.h>

using namespace std;

const int MX = 10000, MK = 100;
int arr[MX][MK];

int drop(int n, int k)
{
   
    if (!n || n == 1) return n;
    if (k == 1) return n;
    
    if (arr[n][k]) return arr[n][k] + 1;

    int ans = INT_MAX;

    for (int i = 1; i <= n; i++)
    {
        ans = min(ans, max(drop(i - 1, k - 1), drop(n - i, k)));
    }

    arr[n][k] = ans;

    return ans + 1;
}

int main()
{
    int n, k;

    cin >> n >> k;

    cout << drop(n, k) << endl;

    return 0;
}
