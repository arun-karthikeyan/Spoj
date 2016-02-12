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
		int number = Integer.parseInt(br.readLine());
		int val = 5;
		int zeroes = 0;
		while(val<=number)
		{
			zeroes+=(number/val);
			val*=5;
		}
		pw.println(zeroes);
	}

	pw.flush();
	pw.close();
}
}
