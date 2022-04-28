#include <bits/stdc++.h>

using namespace std;

const int MX = 4;
long long total = 0;

void generate(string cur, bitset<MX> bs, int val)
{
    if (val) bs[val-1] = 1;

    int count = cur.size();

    if (count == MX)
    {
        cout << cur << endl;
        total++;
        return;
    }

    for (int i = 0; i < MX; i++)
    {
        if (!bs[i])
        {
            generate(cur + to_string(i + 1), bs, i + 1);
        }
    }
    return;
}

int main()
{
     bitset<MX> bs;

     generate("", bs, 0);

     cout << "count: " << total << "\n";

     return 0;
}
