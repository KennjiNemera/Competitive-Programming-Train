#include <bits/stdc++.h>

using namespace std;

vector<pair<int, pair<string, int>>> arr;
int n;

int upper(int target)
{
    int lo = 0;
    int hi = arr.size() - 1;
    int ans = -1;
    while (lo <= hi)
    {
        int mid  = (lo + hi) / 2;
        if (arr[mid].first <= target) {
            lo = mid + 1;
            ans = mid;
        } else {
            hi = mid - 1;
        }
    }

    return ans;
}

int lower(int target)
{
    int lo = 0;
    int hi = arr.size() - 1;
    int ans = -1;
    while (lo <= hi)
    {
        int mid  = (lo + hi) / 2;
        if (arr[mid].first >= target) {
            hi = mid - 1;
            ans = mid;
        } else {
            lo = mid + 1;
        }
    }

    return ans;
}

int main()
{

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;

    arr.resize(n);

    int ans[n][2];

    for (int i = 0; i < n; i++)
    {
        int sum = 0;

        string name;

        cin >> name;

        for (int j = 0; j < 5; j++) {
            
            int temp;

            cin >> temp;

            sum += temp;

        }

        arr[i] = make_pair(sum, make_pair(name, i));
    }

    sort(arr.begin(), arr.end());

    for (int i = 0; i < n; i++) {
        int low = lower(arr[i].first - 500);
        int hi = upper(arr[i].first + 500);
        
        int ac = 0;
        for (int j = hi; j > i && arr[i].first + 500 == arr[j].first; j--) {
            ac += (arr[i].second.first > arr[j].second.first);
        }

        int bc = 0;
        for (int j = low; j < i && arr[i].first - 500 == arr[j].first; j++) {
            bc += (arr[i].second.first < arr[j].second.first);
        }

        ans[arr[i].second.second][0] = n - hi + ac;
        ans[arr[i].second.second][1] = n - low - bc;
    }

    for (int j = 0; j < n; j++)
    {
        cout << ans[j][0] << " " << ans[j][1] << endl;
    }

    return 0;
}
