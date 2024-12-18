#include "shoes.h"
#include <bits/stdc++.h>

using namespace std;

// DO WHAT NEED TO BE DONE

#define vi vector<int>
#define pb push_back
#define sz size()

// NEED TO IMPLEMENT FENWICK TREE TO TRACK POSTIONAL CHANGES
const int MAXN = 100010;
int fen[MAXN];
int n;
bool vis[MAXN];

void add(int a, int pos)
{
    while (pos <= n)
    {
        fen[pos] += a;
        pos += pos & -pos;
    }
}

int get(int pos)
{
    int sum = 0;

    while (pos >= 1)
    {
        sum += fen[pos];
        pos -= pos & -pos;
    }

    return sum;
}

long long count_swaps(vi s) {

    long long ans = 0;
    map<int, priority_queue<int, vi, greater<int>>> mp;
    n = s.sz;

    for (int i = 0; i < n; i++) mp[s[i]].push(i+1);

    // we want to greedily take the leftmost shoe and pair it with it's match

    // this means that we will loop over the given vector and use the map to find the relative positions of the shoe and it's pair
    int matched = 0;
    int curPos = 0;

    while (matched < n/2)
    {

        // ignore all the matched shoes that haven't directly been moved yet
        if (!mp[s[curPos]].empty()) {
            if (mp[s[curPos]].top() != curPos + 1)
            {
                curPos++;
                continue;
            }
        } else {
            curPos++;
            continue;
        }

        // get the position of the relevant shoes after their range shifts
        int a = mp[s[curPos]].top() + get(curPos+1);
        int pairPos = mp[-s[curPos]].top();
        int b = pairPos + get(pairPos+1);

        // cout << a << " " << b << "\n";

        // figure out which the left and right shoe

        int dist = abs(b - a) - 1;

        // cout << "D: " << dist << "\n";

        if (s[curPos] < 0)
        {
            // cout << "left first\n"; 
            ans += dist;
            // perform the range updates -> do not shift the left shoe since it is already in the correct position
            add(1, mp[s[curPos]].top() + 1);
            add(-1, mp[-s[curPos]].top());

        } else {
            ans += dist + 1;
            // cout << "right first\n";
            // perform the range updates -> bring the left shoe in front of the right shoe so we must shift the range [a,b)
            add(1, mp[s[curPos]].top());
            add(-1, mp[-s[curPos]].top());
        }
        
        mp[s[curPos]].pop();
        mp[-s[curPos]].pop();
        matched++;
        curPos++;
    }



	return ans;
}

