// we are essentially building a MST
  // for (edge e : edges)
  // {
  //   // nodes aren't in the same component
  //   cout << e.i << " " << e.j << " " << e.w << "\n";
  //   if (find(e.i) != find(e.j))
  //   {
  //     unite(e.i, e.j);
  //     curAns = e.w;
  //     numComp--;
  //     cout << "connected: " << e.i << " to " << e.j << " with : " << e.w << "\n";
  //     for (int i = 0; i < n; i++)
  //     {
  //       cout << i << " : " << par[i] << "\n";
  //     }

  //     if (numComp == 1)
  //     {
  //       break;
  //     }
  //   }
  // }

  // cout << curAns << "\n";