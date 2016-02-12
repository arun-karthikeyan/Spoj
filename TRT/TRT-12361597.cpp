#include <iostream>
#include <iomanip>
#include <math.h>
using namespace std;
int *treats;
bool **visitedList;
int **memoi;
int n;
int findOptimalSolution(int i,int j,int day)
{
	if(day>n)
	{
		return 0;
	}
	if(!visitedList[i][j])
	{
		int firstElement = treats[i];
		int leftSol = (day * firstElement) + findOptimalSolution(i+1, j, day+1);
		int lastElement = treats[j];
		int rightSol = (day * lastElement) + findOptimalSolution(i, j-1, day+1);
		visitedList[i][j] = true;
		return (memoi[i][j] = max(leftSol, rightSol));
	}
	else
	{
		return memoi[i][j];
	}
}
int main()
{
    
    	cin>>n;
	treats = new int[n];
	
	visitedList = new bool*[n];
	memoi = new int*[n];
	for(int i=0;i<n;++i)
	{
		visitedList[i] = new bool[n];
		memoi[i] = new int[n]; 
		cin>>treats[i];
	}
	findOptimalSolution(0,n-1,1);
	cout<<memoi[0][n-1];

 
    return 0;
}
