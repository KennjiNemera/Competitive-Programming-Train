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

    for (int i = 2; i <= n; i++)
    {
        for (int j = 2; j <= k; j++)
        {
            int ans = INT_MAX;

            cout << "------------------\n";

            cout << "round: " << i << " " << j << endl;

            int first;

            for (int f = 1; f <= i; f++)
            {
                int temp = max(arr[f-1][j-1], arr[i-f][j]);
                ans = min(temp, ans);
                if (f == 1) first = temp;
                cout << "floor: " << f << " : " << temp << endl;
                if (temp > ans) break;
            }

            if (ans == first) refs.push_back(i);

            arr[i][j] = 1 + ans;
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

    cout << "ans: " << arr[n][k] << "\n";

    for (int i = 0; i < refs.size(); i++) cout << refs[i] << "\n";
}
