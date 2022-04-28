#include <bits/stdc++.h>

using namespace std;

const int INF = 1e9;

vector<int> a, b;

int getBest(vector<int> &a, int cur)
{
    long long ans = INF + 10;
    int cd = -1;

    for (int i = 0; i < a.size(); i++)
    {
        long long val = abs(a[i] - cur);

        if (val < ans)
        {
            cd = i;
            ans = val;
        }
    }

    return cd;
}

void solve()
{
    int n;

    cin >> n;
    
    a.resize(n);
    b.resize(n);

    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < n; i++) cin >> b[i];

    vector<int> cd1 = {0, getBest(b, a[0]), n - 1};
    vector<int> cd2 = {0, getBest(b, a[n-1]), n - 1};

//    cout << cd1[1] << " : " << cd2[1] << endl; 
    
    long long best = INT_MAX;

    for (int v1 : cd1) {
        for (int v2 : cd2) {
               
            long long temp = (long long) abs(a[0] - b[v1]) + abs(a[n-1] - b[v2]);
            
            // check if we have included the corner elements of ROW B
            if (v1 > 0 && v2 > 0)
            {
                temp += abs(b[0] - a[getBest(a, b[0])]);
            }

            if (v1 < n - 1 && v2 < n - 1)
            {
                temp += abs(b[n-1] - a[getBest(a, b[n-1])]);
            }

//            cout << "! : " << temp << endl;
            best = min(best, temp);
        }
    }

    cout << best << "\n";
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
}
