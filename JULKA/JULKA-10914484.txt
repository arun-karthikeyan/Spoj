import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	for(int i=0;i<10;++i)
	{
		BigInteger together = new BigInteger(br.readLine());
		BigInteger excess = new BigInteger(br.readLine());
		BigInteger natalia = (together.subtract(excess)).divide(new BigInteger("2"));
		BigInteger klaudia = natalia.add(excess);
		pw.println(klaudia+"\n"+natalia);
	}

	pw.flush();
	pw.close();
}
}
