import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;


public class Main {
static InputStream is;
static PrintWriter out;
static String INPUT = "";

private static byte[] inbuf = new byte[1024];
static int lenbuf = 0, ptrbuf = 0;

private static int readByte() {
	if (lenbuf == -1)
		throw new InputMismatchException();
	if (ptrbuf >= lenbuf) {
		ptrbuf = 0;
		try {
			lenbuf = is.read(inbuf);
		} catch (IOException e) {
			throw new InputMismatchException();
		}
		if (lenbuf <= 0)
			return -1;
	}
	return inbuf[ptrbuf++];
}

private static int ni() {
	int num = 0, b;
	boolean minus = false;
	while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
		;
	if (b == '-') {
		minus = true;
		b = readByte();
	}

	while (true) {
		if (b >= '0' && b <= '9') {
			num = num * 10 + (b - '0');
		} else {
			return minus ? -num : num;
		}
		b = readByte();
	}
}

private static final int MAX = 10000;
private static final String NOPATH = "Impossible";

@SuppressWarnings("unchecked")
public static void main(String[] args) {
	is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
			INPUT.getBytes());
	out = new PrintWriter(System.out);

	boolean[] sieve = new boolean[MAX];
	
	for(int i=2;(i*i)<=MAX;++i)
	{
		if(!sieve[i])
		{
			for(int j=2*i;j<MAX;j+=i)
			{
				sieve[j] = true;
			}
		}
	}
	
	ArrayList<Integer> primes = new ArrayList<Integer>(1070);
//	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	int[] map = new int[MAX];
	
	for(int i=1000,j=0;i<MAX;++i)
	{
		if(!sieve[i])
		{
				primes.add(i);
				map[i]=j++;
		}
	}
	int primeSize = primes.size();
	ArrayList<Integer>[] adjList = new ArrayList[primeSize];
	
	for(int i=0;i<primeSize;++i)
	{
		adjList[i] = new ArrayList<Integer>();
	}
	
	for(int i=0;i<primeSize;++i)
	{
		for(int j=i+1;j<primeSize;++j)
		{
			int v1 = primes.get(i), v2 = primes.get(j);
			if(pathPossible(v1,v2))
			{
				adjList[map[v1]].add(map[v2]);
				adjList[map[v2]].add(map[v1]);
			}
		}
	}
	
	int tcs = ni();
	
	for(int i=0;i<tcs;++i)
	{
		int num1 = ni(), num2 = ni();
		int shortestPath = 0;
		if(num1==num2)
		{
			out.println(shortestPath);
		}
		else
			if((shortestPath = shortestPath(adjList,map[num1],map[num2])) != -1)
			{
				out.println(shortestPath);
			}
			else
			{
				out.println(NOPATH);
			}
	}
	
	out.flush();
}
private static final int VERTEX = 0, DIST = 1;
private static int shortestPath(ArrayList<Integer>[] adjList, int from, int to)
{
	LinkedList<int[]> bfs = new LinkedList<int[]>();
	boolean[] visited = new boolean[adjList.length];
	bfs.add(new int[]{from,0});
	
	while(!bfs.isEmpty())
	{
		int[] vertex = bfs.remove();
		if(!visited[vertex[VERTEX]])
		{
			if(vertex[VERTEX]==to)
			{
				return vertex[DIST];
			}
			visited[vertex[VERTEX]] = true;
			
			for(int i=0,j=adjList[vertex[VERTEX]].size();i<j;++i)
			{
				bfs.add(new int[]{adjList[vertex[VERTEX]].get(i),vertex[DIST]+1});
			}
		}
		
	}
	
	return -1;
}
private static boolean pathPossible(int v1, int v2)
{
	int diffCount = 0;
	while(v1>0)
	{
		if((v1%10)!=(v2%10))
		{
			diffCount++;
		}
		v1/=10;v2/=10;
	}
	
	return diffCount==1;
}
}
