import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int testcases = Integer.parseInt(br.readLine());
	for(int t=0;t<testcases;++t)
	{
		br.readLine();
		long N = Long.parseLong(br.readLine());
		long total = 0;
		for(int i=0;i<N;++i)
		{
			total=(total+(Long.parseLong(br.readLine())%N))%N;
		}
		
		if(total==0)
		{
			pw.println("YES");
		}
		else
		{
			pw.println("NO");
		}
	}
//	br.readLine();
	pw.flush();
	pw.close();
}
}
