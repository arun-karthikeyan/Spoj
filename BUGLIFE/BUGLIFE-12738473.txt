import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
//Constants
private static final String SCENARIO = "Scenario #";
private static final String COLON = ":";
private static final String SUCCESS = "No suspicious bugs found!";
private static final String FAILURE = "Suspicious bugs found!";
private static final int ID = 0, SET = 1;

public static void main(String[] args) {
	is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
			INPUT.getBytes());
	out = new PrintWriter(System.out);

	int tcs = ni();
	
	for(int t=1;t<=tcs;++t)
	{
		int totalBugs = ni(), totalInteractions = ni();
		
		int[][] adjList = new int[totalBugs+1][totalBugs+1];
		int[] edgeCount = new int[totalBugs+1];
		for(int i=0;i<totalInteractions;++i)
		{
			int from = ni(), to = ni();
			adjList[from][edgeCount[from]++] = to;
			adjList[to][edgeCount[to]++] = from;
		}
		int temp = (totalBugs/2);
		int maxPossibleInteractions = ((temp*temp) + ((totalBugs%2)*temp));
		out.println(SCENARIO+t+COLON);
		if(totalInteractions>maxPossibleInteractions)
		{
			out.println(FAILURE);
			continue;
		}
		int[] setNumbers = new int[totalBugs+1];
		
		Arrays.fill(setNumbers,-1);
		
		boolean[] visitedList = new boolean[totalBugs+1];
//		Stack<int[]> dfs = new Stack<int[]>();
		LinkedList<int[]> bfs = new LinkedList<int[]>();
		boolean noInteraction = true;
		for(int i=1;i<=totalBugs;++i)
		{
			if(!visitedList[i])
			{
				setNumbers[i] = 0;
				bfs.addFirst(new int[]{i,setNumbers[i]});
				if(!checkCurrentList(visitedList, adjList, edgeCount, bfs, setNumbers))
				{
					noInteraction = false;
					break;
				}
				
			}
		}
		if(noInteraction)
		{
			out.println(SUCCESS);
		}
		else
		{
			out.println(FAILURE);
		}
	}
	out.flush();
}

private static boolean checkCurrentList(boolean[] visitedList, int[][] adjList, int[] edgeCount, LinkedList<int[]> dfs, int[] setNumbers)
{
	while(!dfs.isEmpty())
	{
		int[] currentBugInfo = dfs.removeLast();
		
		if(!visitedList[currentBugInfo[ID]])
		{
			visitedList[currentBugInfo[ID]] = true;
			
			int[] adjVertices = adjList[currentBugInfo[ID]];
			
			int verticesSetNumber = (currentBugInfo[SET]+1)%2;
			
			for(int i=0,j=edgeCount[currentBugInfo[ID]];i<j;++i)
			{
				int currentVertex = adjVertices[i];
				if(setNumbers[currentVertex]==-1)
				{
					setNumbers[currentVertex] = verticesSetNumber;
				}
				if(setNumbers[currentVertex]!=verticesSetNumber)
				{
					return false;
				}
				dfs.addFirst(new int[]{adjVertices[i],verticesSetNumber});
				
			}
		}
	}
	
	return true;
}
}
