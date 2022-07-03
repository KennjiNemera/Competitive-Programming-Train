#include <bits/stdc++.h>
#include <cmath>

using namespace std;

const double pi = acos(-1);

void solve()
{
    int n;

    cin >> n;

    vector<double> degs;

    for (int i = 0; i < n; i++)
    {
        int a, b;

        cin >> a >> b;

        // edge case
        if (!a)
        {
            if (b > 0) degs.push_back(90);
            else degs.push_back(270);
        } else if (!b)
        {
            if (a < 0) degs.push_back(180);
            else degs.push_back(0); 
        } else {

            double temp = abs(atan((double)b/a) * 180 / pi);

            if (a < 0)
            {   
                if (b > 0)
                {
                    // top left
                    temp = 180 - temp;
                } else {
                    // bottom left
                    temp = 180 + temp;
                }
            } else {
                if (b < 0)
                {
                    // bottom right
                    temp = 360 - temp;
                }
            }

            degs.push_back(temp);
        }
    }

    sort(begin(degs), end(degs));

    double ans = 360 - (degs[n-1] - degs[0]);
    for (int i = 0; i < n - 1; i++)
    {
        ans = max(ans, degs[i+1] - degs[i]);
    }

    cout << setprecision(20) << 360 - ans << "\n";

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

