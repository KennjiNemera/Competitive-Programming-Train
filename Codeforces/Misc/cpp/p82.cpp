#include <bits/stdc++.h>
#include <cmath>

using namespace std;

int main() {

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

    FILE* file = fopen("p082_matrix.txt","r");
    if (!file)
    {
        cout << "Error: matrix file not found!\n";
        return 1;
    }

    int matrix[80][80];

    for (int j=0;j<80;j++)
    {
        for (int i=0;i<80;i++)
        {
            fscanf(file, "%i", &matrix[j][i]);
            fgetc(file);
        }
    }

    fclose(file);

    int ans[80];

    for (int i = 0; i < 80; i++) {
        ans[i] = matrix[i][79];
    }

    

  
  return 0;
}
