#include <bits/stdc++.h>
#include <cmath>

using namespace std;

vector<int> link;
vector<int> size;

int find(int x) {
  while (x != link[x]) x = link[x];
  cout << x << "\n";
  return x;
}

void Union(int a, int b) {
  int ap = find(a);
  int bp = find(b);

  if (size[ap] < size[bp]) swap(ap, bp);

  size[ap] += size[bp];
  link[bp] = ap;
}

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n, q;

  cin >> n >> q;

  for (int i = 1; i <= n; i++) {
    link.push_back(i);
    size.push_back(1);
  }

  while (q-- > 0) {
    string c;

    int a, b;

    cin >> c >> a >> b;

    // cout << (c.compare("F") == 0) << "\n";

    if (c.compare("F") == 0) {
      int x = find(a);
      int y = find(b);

      cout << x << " " << y << "\n";
      // if (x ) {
      //   cout << "True" << "\n";
      // } else {
      //   cout << "False" << "\n";
      // }
    } 
  }

  return 0;
}