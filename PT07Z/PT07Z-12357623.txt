import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
private static LinkedList<Integer>[] adjList;
private static boolean[] visitedList;
private static int nodes,maxPathLen;
@SuppressWarnings("unchecked")
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	nodes = Integer.parseInt(br.readLine());
	
	adjList = new LinkedList[nodes+1];
	visitedList = new boolean[nodes+1];
	maxPathLen = 1;
	for(int i=1;i<=nodes;++i)
	{
		adjList[i] = new LinkedList<Integer>();
	}
	
	for(int i=1;i<nodes;++i)
	{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
		adjList[from].add(to);
		adjList[to].add(from);
	}
	findMaxPath(1);
	pw.println(maxPathLen-1);
	pw.flush();
	pw.close();
}
	private static int findMaxPath(int currentNode)
	{
		visitedList[currentNode] = true;
			Iterator<Integer> adjVertices = adjList[currentNode].iterator();
			int maxPath1 = Integer.MIN_VALUE, maxPath2 = Integer.MIN_VALUE;
			while(adjVertices.hasNext())
			{
				int currentAdj = adjVertices.next();
				if(!visitedList[currentAdj])
				{
				int currentPathLen = 1+findMaxPath(currentAdj);
				if(currentPathLen>maxPath1)
				{
					maxPath2 = maxPath1;
					maxPath1 = currentPathLen;
				}
				else
					if(currentPathLen>maxPath2)
					{
						maxPath2 = currentPathLen;
					}
				}
				
			}
			if(maxPath2!=Integer.MIN_VALUE)
			{
				int currentPathLen = maxPath1 + maxPath2 - 1;
				if(maxPathLen<currentPathLen)
				{
					maxPathLen = currentPathLen;
				}
			}
			else
				if(maxPath1!=Integer.MIN_VALUE)
				{
					if(maxPathLen<maxPath1)
					{
						maxPathLen = maxPath1;
					}
				}
			return ((maxPath1!=Integer.MIN_VALUE)?maxPath1:1);
		
	}
}
