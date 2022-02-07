  // for (int k = 1; k <= n; k++)
  // {
  //   for (int w = 0; w <= total; w++)
  //   {
  //     if (w - vals[k] >= 0)
  //     {
  //       arr[k][w] |= arr[k - 1][w - vals[k]];
  //     }
  //     arr[k][w] |= arr[k - 1][w];
  //     if (k == n && arr[k][w]) {
  //       if (w == 0) continue;
  //       count++;
  //       out = out + to_string(w) + " ";
  //     }
  //   }
  // }