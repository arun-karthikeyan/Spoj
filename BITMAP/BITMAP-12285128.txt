import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	private static final Character WHITE = '1';
	private static final int X=0,Y=1,COST=2;
	private static boolean checkBoundary(int xIndex, int yIndex, int xLimit, int yLimit)
	{
		return ((xIndex>=0) && (xIndex<xLimit) && (yIndex>=0) && (yIndex<yLimit));
	}
public static void main(String[] args) throws Exception {

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
		
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[n][m];
		while(whitePixelPos.hasNext())
		{
			int[] currentWhitePixelPos = whitePixelPos.next();
			
			visited[currentWhitePixelPos[X]][currentWhitePixelPos[Y]] = true; //Marking initial white Pixel Pos as visited
			int distance = 1; //Distance for adjacent vertices
			if(checkBoundary(currentWhitePixelPos[X]+1,currentWhitePixelPos[Y], n, m) && !visited[currentWhitePixelPos[X]+1][currentWhitePixelPos[Y]])
			{
				queue.add(new int[]{currentWhitePixelPos[X]+1,currentWhitePixelPos[Y],distance});
			}
			
			if(checkBoundary(currentWhitePixelPos[X],currentWhitePixelPos[Y]+1, n, m) && !visited[currentWhitePixelPos[X]][currentWhitePixelPos[Y]+1])
			{
				queue.add(new int[]{currentWhitePixelPos[X],currentWhitePixelPos[Y]+1,distance});
			}
			
			if(checkBoundary(currentWhitePixelPos[X]-1,currentWhitePixelPos[Y], n, m) && !visited[currentWhitePixelPos[X]-1][currentWhitePixelPos[Y]])
			{
				queue.add(new int[]{currentWhitePixelPos[X]-1,currentWhitePixelPos[Y],distance});
			}
			
			if(checkBoundary(currentWhitePixelPos[X],currentWhitePixelPos[Y]-1, n, m) && !visited[currentWhitePixelPos[X]][currentWhitePixelPos[Y]-1])
			{
				queue.add(new int[]{currentWhitePixelPos[X],currentWhitePixelPos[Y]-1,distance});
			}
		}
			while(!queue.isEmpty())
			{
				int[] currentAdjacent = queue.remove();
				
					visited[currentAdjacent[X]][currentAdjacent[Y]] = true;
					int prevCost = bitMap[currentAdjacent[X]][currentAdjacent[Y]];
					int curCost = currentAdjacent[COST];
					if(prevCost==0 || curCost < prevCost)
					{
						bitMap[currentAdjacent[X]][currentAdjacent[Y]] = curCost;
						//Adding adjacent vertices of current adjacent vertex to the queue
						if(checkBoundary(currentAdjacent[X]+1,currentAdjacent[Y], n, m) && !visited[currentAdjacent[X]+1][currentAdjacent[Y]])
						{
							queue.add(new int[]{currentAdjacent[X]+1,currentAdjacent[Y],curCost+1});
						}
						
						if(checkBoundary(currentAdjacent[X],currentAdjacent[Y]+1, n, m) && !visited[currentAdjacent[X]][currentAdjacent[Y]+1])
						{
							queue.add(new int[]{currentAdjacent[X],currentAdjacent[Y]+1,curCost+1});
						}
						
						if(checkBoundary(currentAdjacent[X]-1,currentAdjacent[Y], n, m) && !visited[currentAdjacent[X]-1][currentAdjacent[Y]])
						{
							queue.add(new int[]{currentAdjacent[X]-1,currentAdjacent[Y],curCost+1});
						}
						
						if(checkBoundary(currentAdjacent[X],currentAdjacent[Y]-1, n, m) && !visited[currentAdjacent[X]][currentAdjacent[Y]-1])
						{
							queue.add(new int[]{currentAdjacent[X],currentAdjacent[Y]-1,curCost+1});
						}
					}
				
			}
		
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
			br.readLine();
	}
	pw.flush();
	pw.close();
}
}
