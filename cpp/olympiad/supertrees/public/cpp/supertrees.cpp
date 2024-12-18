#include "supertrees.h"
#include <bits/stdc++.h>

using namespace std;

/* 
    Sub 1 + 2: Construct numerous connected components
    Sub 3: Add cycle to the numerous components (break if component size == 2)
    Sub 4: Build many trees and loop around their roots
    Sub 5: Verify that Law Of Tree works
    Sub 6: We can't allow 3 since we would need 4
*/

typedef long long int64;
#define FOR(i, x, y) for (int i = x; i < y; i++)
#define pb push_back
#define f first
#define s second
#define vi vector<int>

const int MAXN = 1010;
bool vis[MAXN];
int par[MAXN];

int getParent(int a)
{
    return a == par[a] ? a : par[a] = getParent(par[a]);
}
void combine(int a, int b)
{
    par[getParent(a)] = getParent(b);
}

int construct(vector<vector<int>> p)
{
	int n = p.size();
	vector<vi> answer;

	for (int i = 0; i < n; i++) {
		vector<int> row;
		row.resize(n);
		answer.push_back(row);
	}
    
    // check for validity
    FOR(i, 0, n) FOR(j, 0, n) if (p[i][j] == 3) return 0;

    // init parents
    FOR(i, 0, n) par[i] = i;

    FOR(id, 0, n)
    {
        if (!vis[id])
        {
            // build a new component
            bool inSet[n] = {};
            vi trees;

            FOR(j, 0, n) if (p[id][j]) inSet[j] = 1, trees.pb(j);

            // build trees
            for (int i : trees)
                for (int j : trees)
                    if (p[i][j] == 1) combine(i, j);

           // cout << "Trees built\n";

            // validate tree
            for (int i : trees)
            {
                // check that it is unique to this component
                if (vis[i]) return 0;
                
                FOR(j, 0, n) if (p[i][j] && !inSet[j]) return 0;

               // cout << i << " : component check\n"; 

                // ensure the law of trees with all other nodes that we are know are in the set
                for (int j : trees)
                { 
                   // cout << j << " " << (getParent(i) != getParent(j) && p[i][j] == 2) << "\n";
                   // cout << j << " " << (getParent(i) == getParent(j) && p[i][j] == 1) << "\n";  
                    if (!((getParent(i) != getParent(j) && p[i][j] == 2) or (getParent(i) == getParent(j) && p[i][j] == 1))) return 0;
                } 

              //  cout << i << " : num ways check\n";
            }
            
            for (int i : trees) vis[i] = 1;

          // cout << "Tree integrity check\n";

            // connect the trees
            bool added[n] = {};
            vi origin;

            for (int j : trees)
            {
                int leader = getParent(j);
                if (!added[leader]) origin.pb(leader), added[leader] = 1;
                // build edge between nodes in the same tree
                if (j != leader) answer[j][leader] = answer[leader][j] = 1;
            }

            for (int i = 0; i < origin.size(); i++)
            {
                // let us do a loopty loop
                int x = origin[i], y = origin[(i+1) % origin.size()];

                // it won't create a cycle if there is only a single tree
                if (x != y) answer[x][y] = answer[y][x] = 1;
            }

            // we can't create cycles if we only have 2 nodes
            if (origin.size() == 2) return 0;  
        }
    }

    build(answer);
	return 1;
}
