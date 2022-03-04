#include <bits/stdc++.h>
#include <cmath>
#include <iostream>
#include <chrono>

using namespace std;
using namespace std::chrono;

int main()
{

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  // STANDARD INPUT

  auto start = high_resolution_clock::now();

  FILE *txtfile = fopen("p082_matrix.txt", "r");

  int arr[80][80];

  for (int i = 0; i < 80; i++)
  {
    for (int j = 0; j < 80; j++)
    {
      fscanf(txtfile, "%d", &arr[i][j]);
      fgetc(txtfile);
    }
  }

  fclose(txtfile);

  // ANSWER

  // Get starting timepoint

  int dp[80];

  // INIT DP
  for (int i = 0; i < 80; i++)
  {
    dp[i] = arr[i][79];
  }

  for (int i = 78; i >= 0; i--)
  {
    dp[0] += arr[0][i]; // CREATE HORZ SUM FOR FIRST ROW BECAUSE THE FIRST ROW CANNOT MOVE UP

    for (int j = 1; j < 80; j++)
    {
      dp[j] = min(dp[j - 1] + arr[j][i], dp[j] + arr[j][i]);

      // PAR 1 = UPWARD MOVEMENT
      // PAR 2 = RIGHTWARD MOVEMENT
    }

    for (int j = 78; j >= 0; j--)
    {
      dp[j] = min(dp[j], dp[j + 1] + arr[j][i]); // CHECK IF DOWNWARD MOTION IS CHEAPER
    }
  }

  int ans = INT_MAX;

  for (int i = 0; i < 80; i++)
  {
    ans = min(ans, dp[i]); // THE ANS AT ROW I REPRESENTS THE MINIMUM PATH FROM THE LEFT TO RIGHT HAND SIDE STARTING AT ROW [I,0]
  }

  cout << ans << "\n";

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
