#include <bits/stdc++.h>

using namespace std;

string solve()
{
    int n;

    cin >> n;

    priority_queue<long long> a, b;

    long long running = 0;

    for (int i = 0; i < n; i++)
    {
        long long val;

        cin >> val;

        running += val;

        a.push(val);
    }

    b.push(running);

    while (!a.empty() && !b.empty())
    { 
        long long aval = a.top();
        long long bval = b.top();

       // cout << aval << " " << bval << " " << b.size() << "\n";

        if (aval > bval) return "NO";

        if (bval > aval)
        {
            b.pop();
            
            long long x, y;

            if (bval % 2 == 0) {
                x = bval / 2;
                y = x;            
            } else {
                x = (bval + 1) / 2;
                y = x - 1;
            } 

            b.push(x);
            b.push(y);
            
        } else {
            a.pop();
            b.pop();
        }
    }
    
    if (a.empty() && b.empty()) return "YES";

   // cout << a.size() << " : " << b.size() << "\n";

    return "NO";
}

int main()
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;

    cin >> t;

    while (t-- > 0)
    {
        cout << solve() << "\n";
    }

    return 0;
}
