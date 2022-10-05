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

bool isPrime(int a) {
    for (int i = 2; i <= sqrt(a); i++) if (!(a % i)) return false;
    return true;
}

bool isCircular(int a)
{
    string s = to_string(a);

    for (int i = 1; i <= s.length(); i++)
    {
        s = s.substr(1, s.length()) + "" + s.substr(0,1);
        int temp = stoi(s);
        if (!isPrime(temp)) return false;        
    }

    return true;
}

void solve()
{
    // understand the problem
    // work thorugh the test cases
    // see if you can find some problem group or fixed algo
    // psuedo
    // implement

    int n, cur;

    cin >> n;

    cur = 2;

    while (n) {
        if (isCircular(cur)) n--;
        cur++;
    }

    cout << cur - 1 << "\n";
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

