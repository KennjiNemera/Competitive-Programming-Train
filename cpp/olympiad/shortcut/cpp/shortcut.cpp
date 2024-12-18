#include "shortcut.h"
#include <bits/stdc++.h>

using namespace std;

typedef long long int64
#define vi vector<int>
#define pb push_back
#define FOR(i, x, y) for (int i = x; i < y; i++)

int64 find_shortcut(int n, vi l, vi d, int c)
{
    for (int i = 1; i < n; i++) l[i] += l[i-1];

    int64 ans = MAX_INT;

    // iterate over all pairs of the nodes and use the prefix sum to find the distance between 2 nodes in O(1) where there are N^2.

    for ()
    return 0;
}
