#include<iostream>
using namespace std;
#define f(i,n) for(i=0;i<n;++i)
int main(){int t,r,c,n,k;cin>>k;f(t,k){cin>>n;int d[n][n];f(r,n){f(c,r+1){cin>>d[r][c];}}for(r=n-2;r>=0;--r){f(c,r+1){d[r][c]+=max(d[r+1][c],d[r+1][c+1]);}}cout<<d[0][0]<<"\n";}}