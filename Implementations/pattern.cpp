#include <bits/stdc++.h>

using namespace std;

int main()
{
    string s = "1";
    int alen, blen;

    alen = 1;

    while (s.size() < 10000)
    {
        string stemp = "";

        int i = 0;

        while (i < s.size())
        {
            char cur = s[i];
            int count = 0;
            
            while (i < s.size())
            {
                if (i > s.size()) break;
                if (s[i] != s[i + count]) break;
                count += s[i+count] == s[i]; 
            }

            i += count;

            stemp = stemp + to_string(count) + cur;
        }

        alen = s.size();
        blen = stemp.size();

        s = stemp;

        cout << (blen / alen) << "\n";
        cout << stemp << "\n\n";
    }   
    
    return 0;
}
