#include <iostream>
#include <iomanip>
#include <stdio.h>
using namespace std;

int main()
{
    int testcases;
	scanf("%d",&testcases);

for(int t=0;t<testcases;++t){
long long int aThree,aNMinusTwo,sN;
scanf("%lld%lld%lld",&aThree,&aNMinusTwo,&sN);
long long int temp1=aThree+aNMinusTwo;
long long int n=((2*(sN-2*(temp1)))/temp1)+4;
long long int d=(aNMinusTwo-aThree)/(n-5);
long long int a=aThree-2*d;
printf("%lld\n",n);
printf("%lld",a);
for(int i=1;i<n;++i){
a+=d;
printf(" %lld",a);
}
printf("\n");

}
 
    return 0;
}
