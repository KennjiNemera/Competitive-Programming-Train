#include <bits/stdc++.h>
#include <cmath>
#include <iostream>

using namespace std;

// implement the range query functions

#define fr(i, a, b) for (int i = a; i < b; i++)

int len;
int INF = 1e9;

int gcd(int a, int b)
{
  if (b == 0)
    return a;
  return gcd(b, a % b);
}

// MINIMUM SEGMENT TREE

void updateGCD(int a, int k, int arr[])
{
  a += len;
  arr[a] = k;
  for (a /= 2; a >= 1; a /= 2)
  {
    arr[a] = gcd(arr[2 * a], arr[2 * a + 1]);
  }
}

int minGCD(int a, int b, int arr[])
{
  a += len;
  b += len;
  int ans = arr[a];

  while (a <= b)
  {
    if (a % 2 != 0)
      ans = gcd(ans, arr[a++]);
    if (b % 2 == 0)
      ans = gcd(ans, arr[b--]);
    a /= 2;
    b /= 2;
  }

  return ans;
}

int main()
{

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n;

  cin >> n;

  len = 1;

  while (len < n)
  {
    len <<= 1;
  }

  // preprocess the array

  int seg[2 * len] = {0};
  map<int, vector<int>> m;

  fr(i, 0, n)
  {
    int in;
    cin >> in;

    updateGCD(i, in, seg);
    m[in].push_back(i);
  }

  int t;

  cin >> t;

  while (t-- > 0)
  {
    int a, b;

    cin >> a >> b;

    a--;
    b--;

    int den = minGCD(a, b, seg);

    int ans = b - a + 1;

    vector<int>::iterator lower, upper;

    // for (int i = 0; i < m[den].size(); i++) {
    //   cout << m[den][i] << " ";
    // }

    // cout << "\n";

    lower = lower_bound(m[den].begin(), m[den].end(), a);
    upper = upper_bound(m[den].begin(), m[den].end(), b);

    int x = lower - m[den].begin() + 1;
    int y = upper - m[den].begin() + 1;

    // cout << ans << " " << den << " " << x << " " << y << "\n";

    int nrValues = y - x;

    cout << (b - a + 1 - nrValues) << "\n";
  }
}