#include <bits/stdc++.h>

using namespace std;

const int GRID = 50001;
int arr[GRID];

// space for the defines
void construct_network(int H, int W, int K)
{

}

int add_not(int N)
{

}

int add_and(std::vector<int> Ns)
{

}

int add_or(std::vector<int> Ns)
{

}

int add_xor(std::vector<int> Ns)
{

}

// MAIN ONLY FOR TESTING
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

