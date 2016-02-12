import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	final int max = (int) (5*1e5+1);
	long[] divisors = new long[max];
	int testcases = Integer.parseInt(br.readLine());
	
	for(int i=1;i<max;++i)
	{
		for(int j=2*i;j<max;j+=i)
		{
			divisors[j]+=i;
		}
	}
	
	for(int t=0;t<testcases;++t)
	{
		pw.println(divisors[Integer.parseInt(br.readLine())]);
	}

	pw.flush();
	pw.close();
}
}
 