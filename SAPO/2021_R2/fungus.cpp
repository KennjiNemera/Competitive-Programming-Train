// state the problem source, problem name / contest, date solved 
// [...state the problem tags/topics...]
#include <bits/stdc++.h>

using namespace std;

#define vi vector<int>
#define pi pair<int, int>
#define f first
#define s second
#define pb push_back
#define vll vector<long long>
#define FOR(i, x, y) for(int i = x; i < y; i++)
#define set(vect, val) fill(begin(vect), end(vect), val)
typedef long long int64;
const int64 mod = 1000000007;
const int MAXN = 110;
int64 arr[MAXN][MAXN][2];
int moves[4][2] = {
                    {1,0}, {0,1}, {-1,0}, {0,-1}
                  };

void solve()
{
    // understand the problem
    // work thorugh the test cases
    // see if you can find some problem group or fixed algo
    // psuedo
    // implement
    int k, n, m;

    cin >> k >> n >> m;

    arr[1][1][0] = 1;
    arr[1][1][1] = 1;

    int64 ans;
    while (k--)
    {
        ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int64 total = 0;
                for (auto& move : moves) {
                    int cx = i + move[0];
                    int cy = j + move[1];
                    if (cx < 1 || cx > n) continue;
                    if (cy < 1 || cy > m) continue;

                    if (move[0] == 1 || move[1] == 1) {
                        // take the new move
                        total += (arr[cx][cy][1] % mod);
                    } else {
                        // take the the previous value
                        total += (arr[cx][cy][0] % mod);
                    }
                }

                arr[i][j][0] = arr[i][j][1];
                arr[i][j][1] += (total % mod);
                ans += arr[i][j][1];
                //cout << i << " : " << j << " -> " << arr[i][j][0] << ", " << arr[i][j][1] << "\n";
            }
        }
        //cout << k << ": " << ans << "\n";
    }  

    cout << (ans % mod) << "\n";  
}

int main()
{
    auto start = chrono::high_resolution_clock::now();
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t = 1;
    // cin >> t;
    for(int i = 0; i < t; i++){
        // cout << "Case #" << i + 1 << ": ";
        solve();
    }
    auto stop = chrono::high_resolution_clock::now(); 
    auto duration = chrono::duration_cast<chrono::milliseconds>(stop - start); 
    // cout <<"Time taken : "<<duration.count() <<" milliseconds\n";
}

