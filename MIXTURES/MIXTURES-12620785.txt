import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {

private static BufferedReader in;
private static PrintWriter out;
private static int[][] smokeDP, colorDP;

public static void main(String[] args) throws Exception {
//	in = new BufferedReader(new FileReader("Mixtures_tcs.txt"));
	in = new BufferedReader(new InputStreamReader(System.in));
	out = new PrintWriter(System.out);
	String input = null;
	while((input=in.readLine())!=null)
	{
		int n = Integer.parseInt(input);
		smokeDP = new int[n][n];
		colorDP = new int[n][n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;++i)
		{
			colorDP[i][i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=n-1;i>=0;--i)
		{
			for(int start=0,end=n-i;start<i;++start,++end)
			{
				int minSmoke = Integer.MAX_VALUE,minColor = 0;
				
				for(int k=start;k<end;++k)
				{
					int smoke = smokeDP[start][k]+smokeDP[k+1][end]+(colorDP[start][k]*colorDP[k+1][end]);
					if(smoke<minSmoke)
					{
						minSmoke = smoke;
						minColor = (colorDP[start][k]+colorDP[k+1][end])%100;
					}
				}
				
				smokeDP[start][end] = minSmoke; colorDP[start][end] = minColor;
			}
		}
		
		out.println(smokeDP[0][n-1]);
	}

	out.flush();
}
}
