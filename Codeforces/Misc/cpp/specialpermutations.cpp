#include <bits/stdc++.h>

using namespace std;

int main()
{
  int t;

  cin >> t;

  while (t-- > 0)
  {
    int n, a, b;

    cin >> n >> a >> b;

    // test if it is possible to generate a permutation
    int min = n - a;
    if (b > a)
      min--;

    int max = b - 1;
    if (a < b)
      max--;

    int append = (n - 2) / 2;

    if (max < append || min < append)
    {
      cout << "-1"
           << "\n";
      continue;
    }

    string out = to_string(a) + " ";

    bool arr[n+1];

    arr[a] = true;
    arr[b] = true;

    int t = n;
    int count = 0;
    while (count < append)
    {
      if (t != b && !arr[t])
      {
        out += to_string(t) + " ";
        arr[t] = true;
        count++;
      }
      t--;
    }

    out += to_string(b) + " ";

    t = 1;
    count = 0;
    while (count < append)
    {
      if (t != b && !arr[t])
      {
        out += to_string(t) + " ";
        arr[t] = true;
        count++;
      }
      t++;
    }

    cout << out << "\n";
  }
}