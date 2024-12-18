#include <bits/stdc++.h>
#include <cmath>
#include <set>

using namespace std;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int k, m, n;

  cin >> k >> m >> n;

  vector<pair<int, int>> points;

  for (int i = 0; i < k; i++)
  {
    int pos, val;
    cin >> pos >> val;
    points.push_back(make_pair(pos, val));
  }

  for (int i = k; i < k + m; i++)
  {
    int pos;
    cin >> pos;
    points.push_back(make_pair(pos, -1));
  }

  // sort the points by their position
  sort(points.begin(), points.end());

  int prevI = -1;
  long long rangesum = 0;

  vector<long long> scores;

  for (int i = 0; i < points.size(); i++)
  {

    // we are currently at Nhoj cow
    if (points[i].second == -1)
    {

      if (prevI == -1)
      {
        scores.push_back(rangesum);
      }
      else
      {
        // here we will simulate a sliding window that must contain a particular point
        long long bestSum = 0;
        long long curSum = 0;

        for (int j = prevI + 1, r = prevI; j < i; j++)
        {

          // cout << "i: " << i << " j: " << j << "\n";

          while (r + 1 < i && (abs(points[r + 1].first - points[j].first) * 2 < (points[i].first - points[prevI].first)))
          {
            // cout << "woah " << points[r+1].second << "\n"; 
            curSum += points[r+1].second;
            r++;
          }

          // cout << "cursum: " << curSum << "\n";

          bestSum = max(bestSum, curSum);
          curSum -= points[j].second;
        }

        // cout << bestSum << " " << (rangesum - bestSum) << "\n";

        // push the one cow
        scores.push_back(bestSum);
        // push the two cow
        scores.push_back(rangesum - bestSum);
      }
      prevI = i;
      rangesum = 0;
    } else {
      rangesum += points[i].second;
    }
  }

  scores.push_back(rangesum); // add the final range

  sort(rbegin(scores), rend(scores));

  long long total = 0;

  for (int i = 0; i < n; i++) {
    total += scores[i];
  }

  cout << total << "\n";

  return 0;
}
