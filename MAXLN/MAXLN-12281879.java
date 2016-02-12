import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int testcases = Integer.parseInt(br.readLine());
	
	for(int t=1;t<=testcases;++t)
	{
		long val = Integer.parseInt(br.readLine())*2;
		val*=val;
		pw.println("Case "+t+": "+val+".25");
	}

	pw.flush();
	pw.close();
}
}
