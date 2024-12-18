#include <bits/stdc++.h>

using namespace std;

const int INF = 1000000007;

#define MAXN 1001;

int matrix[MAXN][MAXN];

int main() {
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;

    cin >> n >> m;

    // int matrix[n][n];

    // init

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; i++) {
            if (i == j) matrix[i][j] = 0;
            matrix[i][j] = INF;
        }
    }

    for (int i = 0; i < m; i++) {
        int a, b, w;

        cin >> a >> b >> w;

        a--;
        b--;

        matrix[a][b] = w;
        matrix[b][a] = w;
    }

    // run floyd warshall.....

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int z = 0; z < n; z++) {
                int curDist = matrix[i][j];
                if (curDist > matrix[i][z] + matrix[z][j]) {
                    matrix[i][j] = matrix[i][z] + matrix[z][j];
                    matrix[j][i] = matrix[i][z] + matrix[z][j];
                }
            }
        }
    }

    // for (int i = 0; i < n; i++) {
    //     for (int j = i + 1; j < n; j++) {
    //         cout << matrix[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    return 0;
}