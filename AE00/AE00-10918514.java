import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int N = Integer.parseInt(br.readLine());
	int div = 1;
	int val = N;
	int count = 0;
	while(val>0)
	{
		count+=val;
		div++;
		val = (N/div) - (div-1);
	}
	pw.println(count);
	pw.flush();
	pw.close();
}
}
