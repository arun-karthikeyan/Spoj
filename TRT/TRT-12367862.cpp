#include <iostream>
#include <iomanip>
#include <stdio.h>

using namespace std;
int *treats;
int **DP;
int n;
int max(int a,int b)
{
return a>b?a:b;
}
int main()
{
    
    	scanf("%d",&n);
	treats = new int[n];
	
	
	DP = new int*[n];
	
	for (int i = 0, j = n - 1; i < n; ++i, --j) {
			scanf("%d",&treats[i]);
			DP[i] = new int[n];
			DP[i][j] = n * treats[i];
		}

		for (int k = 2; k <= n; ++k) {
			for (int i = n - k, j = 0; i >= 0; --i, ++j) {
				DP[i][j] = max((DP[i + 1][j] + (i + j + 1) * treats[i]),
						(DP[i][j + 1] + (i + j + 1) * treats[n - j - 1]));
			}
		}
	printf("%d",DP[0][0]);

 
    return 0;
}