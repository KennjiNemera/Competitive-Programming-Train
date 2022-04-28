#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n;

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    
    int a = 0, b = 0, c = 0;

    while (n-- > 0)
    {
        string command, text;

        cin >> command >> text;

        if (command.length() == 7)
        {
            a++;
            b = 0;
            c = 0;

            cout << a << " " << text << "\n";   
        } else if (command.length() == 10) {
            b++;
            c = 0;

            cout << a << "." << b << " " << text << "\n";
        } else {
            c++;

            cout << a << "." << b << "." << c << " " << text << "\n";
        }

    }

    return 0;

}
