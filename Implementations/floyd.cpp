#include <bits/stdc++.h>

using namespace std;

const int INF = 1e9;

int main()
{
    //auto start = chrono::high_resolution_clock::now();
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    // good luck big guy
    int n, m;
    
    cin >> n >> m;

    int arr[n][n];

    for (int i = 0; i < n; i++)
    {
        arr[i][i] = 0;
        for (int j = i + 1; j < n; j++)
        {
            arr[i][j] = arr[j][i] = INF; 
        }
    }

    for (int i = 0; i < m; i++)
    {
        int a, b, w;

        cin >> a >> b >> w;

        a--; b--;

        arr[a][b] = arr[b][a] = min(arr[a][b], w);
    }

    // triple loop 
    for (int z = 0; z < n; z++)
    {
        for (int i = 0; i < n - 1 ; i++)
        {
            if (i == z) continue;
            for (int j = i + 1; j < n; j++)
            {
                arr[i][j] = arr[j][i] = min(arr[i][j], arr[i][z] + arr[z][j]);
            }
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            cout << arr[i][j] << " ";
        }
        cout << "\n";
    }

}

