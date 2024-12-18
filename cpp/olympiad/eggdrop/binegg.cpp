#include <bits/stdc++.h>

using namespace std;

const int MX = 10001, MS = 101;
int arr[MX][MS];
vector<int> refs;

int main()
{
    int n, k;

    cin >> n >> k;

    for (int i = 1; i <= n; i++) arr[i][1] = i;
    for (int i = 1; i <= k; i++) arr[1][i] = 1;

    int i = 1;

    for (int j = 1; i <= n; j++)
    {
        i += j;
        refs.push_back(i);
    }

    int cur = 0;

    for (int i = 2; i <= n; i++)
    {

        if (refs[cur+1] <= i) cur++;
        cout << "Round: " << i << "\n";
        for (int j = 2; j <= k; j++)
        {
            int f = 1 + (i - refs[cur]);
            int ans = max(arr[f-1][j-1], arr[i-f][j]);
            arr[i][j] = 1 + ans;
            cout << "floor: " << f << " -> " << "(" << j << ") -> " << ans << endl;  
        }
    }

    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= k; j++)
        {
            cout << arr[i][j] << " ";
        }
        cout << "\n";
    }

    cout << "--------\n";
    
    for (int i = 0; i < refs.size(); i++)
    {
        cout << refs[i] << "\n";
    }

    cout << "ans: " << arr[n][k] << "\n";
 
}
