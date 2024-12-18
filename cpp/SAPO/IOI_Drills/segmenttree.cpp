#include <bits/stdc++.h>
#include <cmath>

using namespace std;

int const maxn = 100005;
int len;

void add(int seg[],int pos, int val) {
  pos += len;

  seg[pos] = val;

  // cout << pos << " " << val << "\n";
  
  for (pos /= 2; pos >= 1; pos /= 2) {
    seg[pos] = max(seg[2*pos], seg[2*pos+1]);
  }
}

int query(int segtree[], int a, int b) {
  a += len;
  b += len;

  int maxv = 0;

  while (a <= b) {
    if (a % 2 == 1) maxv = max(maxv, segtree[a++]);
    if (b % 2 == 0) maxv = max(maxv, segtree[b--]);

    a/=2;
    b/=2;
  }

  return maxv;
}

int main() {

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n, m;

  cin >> n >> m;

  // find the first power of 2 >= n
  len = 1;

  while (len < n) {
    len <<= 1;
  }

  int segtree[len*2] = {0};

  for (int i = 1; i <= m; i++) {

    char c;
    int a, b;

    cin >> c >> a >> b;

    if (c == 'Q') {
      cout << to_string(query(segtree,a,b)) << "\n";
    } else {
      add(segtree, a, b);
    }
  }


  return 0;
}
