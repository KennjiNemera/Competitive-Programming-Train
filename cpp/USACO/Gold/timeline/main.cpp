#include <bits/stdc++.h>

using namespace std;

const int MAXN = 1001;
int s[MAXN];

int main()
{

    struct triple {
        int a, b, c;
    };

    int n, m, c;

    cin >> n >> m >> c;

    for (int i = 0; i < m; i++) cin >> s[i];
    
    struct triple mem[n];

    for (int i = 0; i < c; i++) {
        cin >> mem[i].a >> mem[i].b >> mem[i].c;
    }

        



}
