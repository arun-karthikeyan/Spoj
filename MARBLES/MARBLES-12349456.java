import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int testcases = Integer.parseInt(br.readLine());
		
		for(int t=0;t<testcases;++t)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken())-1, k = Integer.parseInt(st.nextToken())-1;
			
			if(k>(n-k))
			{
				k = n-k;
			}
			
			long num = 1;
			long den = 1;
			
			for(int i=n,j=1;j<=k;++j,--i)
			{
				num*=i;
				if(num%j==0)
				{
					num/=j;
				}
				else
				{
					den*=j;
				}
			}
			
			pw.println(num/den);
		}
		pw.flush();
		pw.close();
		
	}

}
