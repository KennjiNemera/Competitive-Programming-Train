#include "testlib.h"
#include <bits/stdc++.h>

using namespace std;

int main(int argc, char* argv[])
{
    registerGen(argc, argv, 1);

    int min_n = atoi(argv[1]);
    int max_n = atoi(argv[2]);
    int min_t = atoi(argv[3]);
    int max_t = atoi(argv[4]);
    int min_s = atoi(argv[5]);
    int max_s = atoi(argv[6]);

    int n = min(100000, rnd.next(min_n, max_n));
    int t = min(min(n * n,100000), rnd.next(min_t, max_t));

    cout << n << endl;

    for (int i = 0; i < n - 1; i++) {
        cout << rnd.next(min_s, max_s) << " ";
    }

    cout << rnd.next(min_s, max_s) << "\n";

    cout << t << "\n";

    for (int i = 0; i < t; i++) {
        int a = rnd.next(1, n);
        int b = rnd.next(a, n);

        cout << a << " " << b;
        if (i + 1 < t) cout << "\n";
    }

    cout << endl;

    return 0;
}