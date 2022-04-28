#include <bits/stdc++.h>
#include <chrono>

using namespace std;

#define ts to_string

const int MAXN = 10001;
vector<vector<int>> arr;
vector<int> primes;
bool sieve[MAXN];

bool isPrime(long long a)
{

    if (a <= 10000) return sieve[a] == 0;

    for (int i = 2; i <= sqrt(a); i++)
    {
        if (!(a % i)) return 0;
    }

    return 1;
}

bool concat(int a, int b)
{
    string x, y;

    x = ts(a) + ts(b);
    y = ts(b) + ts(a);

    long long av = stoll(x);
    long long bv = stoll(y);

    return isPrime(av) && isPrime(bv);
}

int main()
{

    arr.resize(MAXN);

    auto start = std::chrono::steady_clock::now();

    for (int i = 2; i < MAXN; i++)
    {
        if (!sieve[i])
        {
            primes.push_back(i);

            for (int j = 2; j * i < MAXN; j++)
             {
                sieve[i * j] = 1;
            }
        }
    }

    // GENERATE THE PRIME SET MATRIX

    int sz = primes.size();

    for (int i = 0; i < sz; i++)
    {
        for (int j = i + 1; j < sz; j++)
        {
            if (concat(primes[i], primes[j]))
            {
                arr[i].push_back(primes[j]);
                arr[j].push_back(primes[i]);
            }
        }
    }
    
    auto stop = std::chrono::steady_clock::now();
    auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>((stop - start) / 1000);
    
    cout << "Time taken by function: " << duration.count() << " nanoseconds" << endl;

   return 0;
}
