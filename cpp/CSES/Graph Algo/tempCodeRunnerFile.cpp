  run the first dfs and keep track of entry and exit;
  for (int i = 0; i < n; i++) {
    if (!vis[i]) {
      dfs(i);
    }
  }