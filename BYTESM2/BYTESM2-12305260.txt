import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
	private static int totalchars=0,offset=0;
	private static InputStream stream;
	private static byte[] buffer=new byte[1024];
 
	
	private static int readByte() {
		if(totalchars < 0)
			return 0;
		if(offset >= totalchars) {
			offset = 0;
			try 
			{
				totalchars = stream.read(buffer);
			}
			catch(IOException e) 
			{
				return 0;
			}
			if(totalchars <= 0)
				return -1;
		}
		return buffer[offset++];
	}
	
		
	
	private static int readInt()
	{
		int number=readByte();
	
		while(eolchar(number))
			number=readByte();
		
		int sign=1;
		int val=0;
		
		if(number=='-')
			{
			sign=-1;
			number=readByte();
			}
					
		do
			{
				if((number<'0')||(number>'9'))
					return 0;
				val*=10;
				val+=(number-'0');
				number=readByte();
			}
		while(!eolchar(number));
		
		return sign*val;
	}
	private static boolean eolchar(int c)
	{
		return c==' '||c=='\n'||c==-1||c=='\r'||c=='\t';
	}
	private static int[][] memoi;
	private static int[][] chamber;
	private static boolean[][] visited;
	private static int rowMax,colMax;
public static void main(String[] args) throws Exception {
	stream = System.in;
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int testcases = readInt();
	for(int t=0;t<testcases;++t)
	{
		rowMax = readInt();
		colMax = readInt();
		chamber = new int[rowMax][colMax];
		memoi = new int[rowMax][colMax];
		visited = new boolean[rowMax][colMax];
		for(int n=0;n<rowMax;++n)
		{
			for(int m=0;m<colMax;++m)
			{
				chamber[n][m] = readInt();
			}
		}
		pw.println(findMaximum());
	}
	pw.flush();
	pw.close();
}
private static int findMaximum()
{
	int maxStones = Integer.MIN_VALUE;
	
	for(int i=0;i<colMax;++i)
	{
		maxStones = Math.max(maxStones, DFS(0,i));
	}
	return maxStones;
}

private static int DFS(int x, int y)
{
	if(y<0 || y>=colMax)
	{
		return Integer.MIN_VALUE;
	}
	if(!visited[x][y])
	{
		visited[x][y] = true;
		if(x==rowMax-1)
		{
			return (memoi[x][y]=chamber[x][y]);
		}
		return (memoi[x][y]=(chamber[x][y]+Math.max(DFS(x+1,y-1),Math.max(DFS(x+1,y),DFS(x+1,y+1)))));
	}
	else
	{
		return memoi[x][y];
	}
}
}
