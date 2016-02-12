import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int testcases = Integer.parseInt(br.readLine());
	for(int t=0;t<testcases;++t)
	{
		int N = Integer.parseInt(br.readLine());
		int[] menHotness = new int[N];
		int[] womenHotness = new int[N];
		
		StringTokenizer men = new StringTokenizer(br.readLine());
		StringTokenizer women = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;++i)
		{
			menHotness[i] = Integer.parseInt(men.nextToken());
			womenHotness[i] = Integer.parseInt(women.nextToken());
		}
		Arrays.sort(menHotness);Arrays.sort(womenHotness);
		int totalHotness = 0;
		for(int i=0;i<N;++i)
		{
			totalHotness+=(menHotness[i]*womenHotness[i]);
		}
		pw.println(totalHotness);
		
	}
	pw.flush();
	pw.close();
}
}
