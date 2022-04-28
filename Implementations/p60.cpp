int result = int.MaxValue;
primes = ESieve(30000);
 
HashSet[] pairs = new HashSet[primes.Length];
 
for (int a = 1; a < primes.Length; a++) { if (primes[a] * 5 >= result) break;
    if (pairs[a] == null) pairs[a] = MakePairs(a);
    for (int b = a + 1; b < primes.Length; b++) {        if (!pairs[a].Contains(primes[b])) continue;
        if (pairs[b] == null) pairs[b] = MakePairs(b);
 
        for (int c = b + 1; c < primes.Length; c++) { 
            if (!pairs[a].Contains(primes) ||
            !pairs[b].Contains(primes)) continue;
            if (pairs == null) pairs = MakePairs(c);
 
            for (int d = c + 1; d < primes.Length; d++) { 
                if (!pairs[a].Contains(primes[d]) ||
                !pairs[b].Contains(primes[d]) ||
                !pairs.Contains(primes[d])) continue;
                if (pairs[d] == null) pairs[d] = MakePairs(d);
 
                for (int e = d + 1; e < primes.Length; e++) { 
                    if (!pairs[a].Contains(primes[e]) ||
                    !pairs[b].Contains(primes[e]) ||
                    !pairs.Contains(primes[e]) ||
                    !pairs[d].Contains(primes[e])) continue;
 
                    if (result > primes[a] + primes[b] + primes + primes[d] + primes[e])
                        result = primes[a] + primes[b] + primes + primes[d] + primes[e];
 
                    Console.WriteLine("{0} + {1} + {2} + {3} + {4} = {5}", primes[a], primes[b], primes, primes[d], primes[e], result);
                    break;
                }
            }
        }
    }
}
