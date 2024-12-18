#include <bits/stdc++.h>

using namespace std;

// perform BFS from each node to every other node.

#define pi pair<int, int>
#define f first
#define ll long long
#define s second

const int mod = 1000000000;
vector<vector<pi>> adj;
vector<pi> points;
bool grid[4002][4002];
int cx = 2001, cy = 2001;
int rx = 0, ry = 0;
int moves[4][2] = {{1, 0},{0, 1},{-1, 0},{0, -1}};

// FLOODFILLING IS JUST BFS -> WHY DID IT TAKE ME SO LONG TO CLOCK THIS...

struct edge
{
    int x, y, s;
};

int bfs(int pos)
{
    ll sum = 0;

    bool vis[4002][4002];

    for (int i = 0; i < 4002; i++)
    {
        for (int j = 0; j < 4002; j++)
        {
            vis[i][j] = 0;
        }
    }

    priority_queue<pair<int, pair<int, int>>> pq;

    pq.push({0, {points[pos].f, points[pos].s}});

    while (!pq.empty())
    {
        pi cur = pq.top();
        pq.pop();

        sum += cur.f;

        // convert the current cell position to a grid position
        int curx = cur.s.f;
        int cury = cur.s.s;

        vis[curx][cury] = 1;

        // loop over all 4 edges
        for (int[] move : moves)
        {
            int tx = curx + move[0];
            int ty = cury + move[1];

            if (grid[tx][ty] && !vis[tx][ty]) {
                // this means that we have found a valid block that we can move to
                pq.push({cur.f + 1, {tx, ty}});
            }
        }

    }
    
    return (int) sum;
}

int DistanceSum(int N, int X[], int Y[])
{
    ll ans = 0;

    // this function will return the outpu
    for (int i = 0; i < n; i++) ans += bfs(i);
    
    return (int) (ans / 2); // we know that the answer will be even hehe
}

void solve()
{
    // good luck big guy
    int n;

    cin >> n;

    int x[n], y[n];

    cin >> x[0] >> y[0];

    rx = x[0], ry = y[0];

    grid[cx][cy] = 1;

    points.push_back({cx, cy});

    for (int i = 1; i < n; i++)
    {
        cin >> x[i] >> y[i];

        int tx = x[i] - rx;
        int ty = y[i] - ry;

        points.push_back({tx + cx, ty + cy});
        grid[tx+cx][ty+cy] = 1;
    }

    DistanceSum(n, x, y);
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

