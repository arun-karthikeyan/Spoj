import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {

private static BufferedReader in;
private static PrintWriter out;
private static int[][] smokeMemoi, colorMemoi;
private static boolean[][] visited;

public static void main(String[] args) throws Exception {
//	in = new BufferedReader(new FileReader("Mixtures_tcs.txt"));
	in = new BufferedReader(new InputStreamReader(System.in));
	out = new PrintWriter(System.out);
	String input = null;
	while((input=in.readLine())!=null)
	{
		int n = Integer.parseInt(input);
		smokeMemoi = new int[n][n];
		colorMemoi = new int[n][n];
		visited = new boolean[n][n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;++i)
		{
			colorMemoi[i][i] = Integer.parseInt(st.nextToken());
			visited[i][i] = true;
		}
		
		findMin(0,n-1);
		out.println(smokeMemoi[0][n-1]);
	}

	out.flush();
}
private static int findMin(int start,int end)
{
	if(!visited[start][end])
	{
	int minSmoke = Integer.MAX_VALUE,minColor = 0;
	visited[start][end] = true;
	for(int i=start;i<end;++i)
	{
		int v1 = findMin(start,i);
		int v2 = findMin(i+1,end);
		int smoke = (smokeMemoi[start][i]+smokeMemoi[i+1][end]+(v1*v2)),color = (v1+v2)%100;
		if(smoke<minSmoke)
		{
			minSmoke = smoke;
			minColor = color;
		}
	}
	smokeMemoi[start][end] = minSmoke;
	colorMemoi[start][end] = minColor;
	return minColor;
	}
	else
	{
		return colorMemoi[start][end];
	}
}

}
