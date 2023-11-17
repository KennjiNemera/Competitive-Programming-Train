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

int moves[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

typedef long long int64;

vector<vi> arr;

int process_pos(int a, int b) {
    
}

bool isValid(int& x, int& y, int& R, int& C) {
    if (x < 0 || x >= R || y < 0 || y >= C) return false;
    return true;
}

void solve()
{
    int R, C;
    cin >> R >> C;
    
    arr.pb(vi);
    FOR (i, 0, R) arr.pb(vi);

    FOR(i, 0, R) {
        FOR (j, 0, C) {
            int val;
            cin >> val;
            arr[j].pb(val);        
        }
    }

    stack<pi> stk;
    stk.pb({0, 0});

    while (!stk.empty()) {
          pi a = stk.pop();
          for (int[] move : moves) {
            int nx = a.f + move[0];
            int ny = a.f + move[1];

            if (isValid(nx, ny, R, C)) {
                // check value
                if (arr[nx][ny] == arr[a.f][a.s]) {
                    // extend rectangle
                }
            }
          }
    }
    
}   

int main()
{
    auto start = chrono::high_resolution_clock::now();
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t = 1;
    cin >> t;
    for(int i = 0; i < t; i++){
        // cout << "Case #" << i + 1 << ": ";
        solve();
    }
    auto stop = chrono::high_resolution_clock::now(); 
    auto duration = chrono::duration_cast<chrono::milliseconds>(stop - start); 
    // cout <<"Time taken : "<<duration.count() <<" milliseconds\n";
}

