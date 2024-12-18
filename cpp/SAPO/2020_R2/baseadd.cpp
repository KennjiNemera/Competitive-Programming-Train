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

int to_dec(string a, int b) {
    int sum = 0;

    for (int i = a.size() - 1; i >= 0; i--) {
        int exp = a.size() - i - 1;
        int dig;
        if (a[i] - '0' <= 9 && a[i] - '0' >= 0) {
            dig = a[i] - '0';
        } else {
            dig = a[i] - 'A' + 10;
        }
        sum += (dig * pow(b, exp));
    }

    return sum;
}

string to_base(int b, int dec) {
    string result = "";
    int quo;

    do {
       int rem = dec % b;
       dec = dec / b;

       if (rem >= 10) {
            result = (char)(((int)'A') + rem - 10) + result;
       } else result = to_string(rem) + result;
    } while (dec);  

    return result;
}

void solve()
{
    int b;
    string x, y;

    cin >> b >> x >> y;
    
    int total = to_dec(x, b) + to_dec(y, b);

    //cout << total << " : " << to_dec(x, b) << " : " << to_dec(y, b) << "\n";

    cout << to_base(b, total) << "\n";
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

