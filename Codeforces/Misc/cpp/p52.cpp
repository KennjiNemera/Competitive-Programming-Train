#include <bits/stdc++.h>
#include <cmath>
#include <chrono>

using namespace std;
using namespace std::chrono;

bool test(long long x)
{
  int arr[10] = {0};

  long long temp = x;

  string out = to_string(x);

  sort(out.begin(), out.end());

  for (int i = 2; i < 7; i++)
  {
    temp = x * i;

    string testing = to_string(temp);

    sort(testing.begin(), testing.end());
    // check equal
    if (out.compare(testing) != 0)
    {
      return false;
    }
  }

  return true;
}

int main()
{
  // Get starting timepoint
  auto start = high_resolution_clock::now();

  // PROGRAM PROCESSES FOUND HERE

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int i = 1;

  while (!test(i*9))
  {
    i++;
  }

  cout << (i*9) << "\n";

  // Get ending timepoint
  auto stop = high_resolution_clock::now();

  // Get duration. Substart timepoints to
  // get durarion. To cast it to proper unit
  // use duration cast method
  auto duration = duration_cast<microseconds>(stop - start);

  cout << "Time taken by function: "
       << duration.count() << " microseconds" << endl;

  return 0;
}