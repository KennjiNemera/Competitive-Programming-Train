#include <bits/stdc++.h>
#include <cmath>

using namespace std;

int main()
{
  int t;

  cin >> t;

  while (t-- > 0)
  {
    int n;
    long long k;

    cin >> n >> k;

    long long arr[n + 1];

    long long sum = 0;

    for (int i = 0; i < n; i++)
    {
      long long a;
      cin >> a;
      arr[i] = a;
      sum += a;
    }

    arr[n] = 0;

    sort(arr, arr + n);

    long long minv = arr[0];

    long long ans = INT_MAX; // hopefully this is legal
    sum -= k;

    // cout << "last val : " << arr[n] << "\n";

    if (sum <= 0) {
      cout << "0" << "\n";
      continue; 
    }

    if (n == 1) {
      cout << (arr[0] - k) << "\n";
      continue;
    }

    // build the reverse prefix on the sorted array
    for (int i = n - 1; i >= 1; i--)
    {
      arr[i] = arr[i] - minv + arr[i+1];

      // cout << to_string(i) << " : " << to_string(arr[i]) << "\n";

      // process the current array element
      long long temp = ceil((double)(sum - arr[i]) / (double)(n - i + 1));

      // cout << i << " " << temp << "\n";
      long long val = max(0LL,temp);

      val += (n - i); // adds the processes made for each position

      // check the possibility of not changing min
      ans = min(ans, val);
    }

    // check if we can't just reduce the first value
    ans = min(ans, sum);
    cout << ans << "\n";
  }

  return 0;
}
