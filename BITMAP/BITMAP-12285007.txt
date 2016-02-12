import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	private static final Character WHITE = '1';
	private static final int X=0,Y=1,COST=2;
	private static boolean checkBounds(int[] index, int xLimit, int yLimit)
	{
		return ((index[X]>=0) && (index[X]<xLimit) && (index[Y]>=0) && (index[Y]<yLimit));
	}
public static void main(String[] args) throws Exception {
//	long startTime = System.currentTimeMillis();
//	BufferedReader br = new BufferedReader(new FileReader("bitmapTCS.txt"));
//	PrintWriter pw = new PrintWriter("bitmapTCSOUT.txt");

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int testcases = Integer.parseInt(br.readLine());
	
	for(int t=0;t<testcases;++t)
	{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		
		LinkedList<int[]> whitePixels = new LinkedList<int[]>(); 
		char[][] pixels = new char[n][m];
		
		for(int i=0;i<n;++i)
		{
			String pixelRow = br.readLine();
			
			for(int j=0;j<m;++j)
			{
				pixels[i][j] = pixelRow.charAt(j);
				if(pixels[i][j]==WHITE)
				{
					whitePixels.add(new int[]{i,j});
				}
			}
		}
		
		Iterator<int[]> whitePixelPos = whitePixels.iterator();
		int[][] bitMap = new int[n][m];
		
		for(int i=0;i<n;++i)
		{
			Arrays.fill(bitMap[i],Integer.MAX_VALUE);
		}
		
		LinkedList<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[n][m];
		while(whitePixelPos.hasNext())
		{
			int[] currentWhitePixelPos = whitePixelPos.next();
			
			visited[currentWhitePixelPos[X]][currentWhitePixelPos[Y]] = true; //Marking initial white Pixel Pos as visited
			int distance = 1; //Distance for adjacent vertices
			queue.add(new int[]{currentWhitePixelPos[X]+1,currentWhitePixelPos[Y],distance});
			queue.add(new int[]{currentWhitePixelPos[X],currentWhitePixelPos[Y]+1,distance});
			queue.add(new int[]{currentWhitePixelPos[X]-1,currentWhitePixelPos[Y],distance});
			queue.add(new int[]{currentWhitePixelPos[X],currentWhitePixelPos[Y]-1,distance});
		}
			while(!queue.isEmpty())
			{
				int[] currentAdjacent = queue.removeFirst();
				
				if(checkBounds(currentAdjacent,n,m) && !visited[currentAdjacent[X]][currentAdjacent[Y]])
				{
					visited[currentAdjacent[X]][currentAdjacent[Y]] = true;
				if(pixels[currentAdjacent[X]][currentAdjacent[Y]] != WHITE)
				{
					int prevCost = bitMap[currentAdjacent[X]][currentAdjacent[Y]];
					int curCost = currentAdjacent[COST];
					if(curCost < prevCost)
					{
						bitMap[currentAdjacent[X]][currentAdjacent[Y]] = curCost;
						//Adding adjacent vertices of current adjacent vertex to the queue
						queue.add(new int[]{currentAdjacent[X]+1,currentAdjacent[Y],curCost+1});
						queue.add(new int[]{currentAdjacent[X],currentAdjacent[Y]+1,curCost+1});
						queue.add(new int[]{currentAdjacent[X]-1,currentAdjacent[Y],curCost+1});
						queue.add(new int[]{currentAdjacent[X],currentAdjacent[Y]-1,curCost+1});
					}
				}
				}
				
			}
//		}
		
		whitePixelPos = whitePixels.iterator();
		
		while(whitePixelPos.hasNext())
		{
			int[] currentWhitePixelPos = whitePixelPos.next();
			bitMap[currentWhitePixelPos[X]][currentWhitePixelPos[Y]] = 0;
		}
		for(int i=0;i<n;++i)
		{
			pw.print(bitMap[i][0]);
			for(int j=1;j<m;++j)
			{
				pw.print(" "+bitMap[i][j]);
			}
			pw.println();
		}
		if(t!=(testcases-1))
		{
			br.readLine();
		}
	}
//	long endTime = System.currentTimeMillis();
//	System.out.println("Time Taken : "+(endTime-startTime));
//	br.close();
	pw.flush();
	pw.close();
}
}
