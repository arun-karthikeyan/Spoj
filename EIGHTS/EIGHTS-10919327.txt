import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
	String[] val = {"942","192","442","692"};
	
	int testcases = Integer.parseInt(br.readLine());
	for(int t=0;t<testcases;++t)
	{
		long value = Long.parseLong(br.readLine());
		long div = (long) Math.ceil(value/4d) - 1;
		long mod = value%4;
		if(div!=0)
		{
			pw.println(new StringBuilder(div+"").append(val[(int) mod]));
		}
		else
		{
			pw.println(val[(int)mod]);
		}
		
	}
	pw.flush();
	pw.close();
}
}
