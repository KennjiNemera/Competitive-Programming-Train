// state the problem source, problem name / contest, date solved 
// [...state the problem tags/topics...]
#include <bits/stdc++.h>

using namespace std;

#define vi vector<int>
#define pi pair<int, int>
#define f first
#define s second
#define pb push_back
#define vll vector<long long>
#define FOR(i, x, y) for(int i = x; i < y; i++)
#define set(vect, val) fill(begin(vect), end(vect), val)

typedef long long int64;

vector<ll> p[N];
void solve(){
    ll n,m;
    cin>>n>>m;
    for(ll i=0;i<m;i++){
        ll a,b;
        cin>>a>>b;
        --a,--b;
        p[a].pb(b);
    }
    vector<int> dist(n,0);
    ll last[n];
    for(ll i=0;i<n;i++) last[i]=i;
    stack<ll> q;
    q.push(0);
    while(!q.empty()){
        int x=q.top();
        q.pop();
        for(auto i:p[x]){
            if((dist[x]+1)>dist[i]){
                dist[i]=dist[x]+1;
                last[i]=x;
                q.push(i);
            }
        }
    }
    if(dist[n-1]==0){
        cout<<"IMPOSSIBLE"<<endl;
        return;
    }
    ll i=n-1;
    vector<ll> ans;
    // for(ll i=0;i<n;i++){
    //     cout<<last[i]<<" ";
    // }
    // cout<<endl;
    ans.pb(i);
    while(i!=0){
        i=last[i];
        ans.pb(i);
    }
    reverse(all(ans));
    cout<<(ll)ans.size()<<endl;
    for(auto i:ans){
        cout<<(i+1)<<" ";
    }
    cout<<endl;
}
signed main(){
    fastio();
    solve();
    return 0;
}


