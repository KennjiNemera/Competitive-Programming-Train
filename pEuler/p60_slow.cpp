#include <bits/stdc++.h>

using namespace std;

#define ts to_string

const int MAXN = 10001;
bool sieve[MAXN] = {0};
vector<int> primes;

// TODO: ISPRIME FUNC
bool isPrime(int a)
{
    for (int i = 2; i <= sqrt(a); i++)
    {
        if (!(a % i)) return false;
    }

    return true;
}       

// TODO: CONCAT FUNCTION
bool concat(int a, int b)
{
    string sa, sb;

    sa = ts(a);
    sb = ts(b);
    
    int ta = stoi(sa + sb);
    int tb = stoi(sb + sa);

    return isPrime(ta) && isPrime(tb);
}


int main()
{
    auto start = std::chrono::steady_clock::now();

    for (int i = 2; i < MAXN; i++)
    {
        if (!sieve[i])
        {
            primes.push_back(i);

            for (int j = 2; i * j < MAXN; j++) 
            {
                sieve[i*j] = 1;
            }
        }
    }

    int sz = primes.size();

    for (int i = 0; i < sz; i++)
    {
        for (int j = i + 1; j < sz; j++)
        {
            if (!concat(primes[i], primes[j]))
            {
                continue;
            }
            
            for (int k = j + 1; k < sz; k++)
            {
                if (!concat(primes[i], primes[k]) || !concat(primes[j], primes[k])) continue;

                for (int m = k + 1; m < sz; m++)
                {
                    if (!concat(primes[i], primes[m]) || !concat(primes[j], primes[m]) || !concat(primes[k], primes[m])) continue;

                    for (int p = m + 1; p < sz; p++)
                    {
                        
                        if (!concat(primes[i], primes[p]) || !concat(primes[j], primes[p]) || !concat(primes[k], primes[p]) || !concat(primes[m], primes[p])) continue;

                        int ans = primes[i] + primes[j] + primes[k] + primes[m] + primes[p];

                        cout << primes[i] << " " << primes[j] << " " << primes[k] << " " << primes[m] << " " << primes[p] << endl;

                        cout << ans << endl;

                        auto stop = std::chrono::steady_clock::now();
                        auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>((stop - start) / 1000);
    
                        cout << "Time taken by function: " << duration.count() << " nanoseconds" << endl;

                        return 0;
                    }
                }
            }
        }
    }

    return 0;


}
