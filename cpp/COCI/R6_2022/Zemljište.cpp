#include <bits/stdc++.h>

using namespace std;

#define ll long long

const int MAXN = 501;

long long arr[MAXN][MAXN];


int func() {
    
}

int main()
{
    int r, s;
    ll a, b;

    cin >> r >> s >> a >> b;

    ll ans = INT_MAX;

    for (int i = 1; i <= r; i++) {
        for (int j = 1; j <= s; j++) {

            cin >> arr[i][j];
            arr[i][j] = arr[i][j] + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];


            for (int k = 1; k <= i; k++) {
                for (int m = 1; m <= j; m++) {
                    ll temp = arr[i][j] - arr[k-1][j] - arr[i][m-1] + arr[k-1][m-1];
                    temp = abs(a - temp) + abs(b-temp);

                    ans = min(ans, temp); 
                }
            }
        }
    }



    cout << ans << endl;

}
