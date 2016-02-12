import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	private static final int PARENT = 0;
	private static final int VERTEX = 1;
	private static final String YES = "YES";
	private static final String NO = "NO";
public static void main(String[] args) throws Exception {
//	System.out.println(Math.E);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
	@SuppressWarnings("unchecked")
	LinkedList<Integer>[] list = new LinkedList[N+1];

	for(int i=1;i<=N;++i)
	{
		list[i] = new LinkedList<Integer>();
	}
	
	for(int i=0;i<M;++i)
	{
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
		list[from].add(to);list[to].add(from);
	}
	
	
		boolean[] visitedList = new boolean[N+1];
		int visitCount = 0;
		Stack<int[]> dfs = new Stack<int[]>();
		dfs.add(new int[]{0,1});
		boolean isTree = true;
		while(!dfs.isEmpty() && isTree)
		{
			int[] currentVertex = dfs.pop();
//			if(!visitedList[currentVertex[VERTEX]])
//			{
				visitCount++;
				Iterator<Integer> vertices = list[currentVertex[VERTEX]].iterator();
				visitedList[currentVertex[VERTEX]] = true;
				
				while(vertices.hasNext())
				{
					int adjVertex = vertices.next();
					if(visitedList[adjVertex])
					{
						if(currentVertex[PARENT]!=adjVertex)
						{
							isTree = false;
							break;
						}
					}
					else
					{
						dfs.add(new int[]{currentVertex[VERTEX],adjVertex});
					}
					
				}
//			}
			
		}
		if(visitCount == N && isTree)
		{
			pw.println(YES);
		}
		else
		{
			pw.println(NO);
		}
	
	pw.flush();
	pw.close();
}
}
