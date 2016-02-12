import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	BigInteger[] fact = new BigInteger[101];
	fact[0] = BigInteger.ONE;
	
	for(int i=1;i<=100;++i)
	{
		fact[i] = fact[i-1].multiply(new BigInteger(i+""));
	}
	
	int testcases = Integer.parseInt(br.readLine());
	for(int t=0;t<testcases;++t)
	{
		pw.println(fact[Integer.parseInt(br.readLine())]);
	}
	

	pw.flush();
	pw.close();
}
}
