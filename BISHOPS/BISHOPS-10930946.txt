import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		String N = br.readLine();
		while (N != null) {
			if (N.equals("1")) {
				pw.println(N);
			} else {
				pw.println((new BigInteger(N).subtract(BigInteger.ONE))
						.multiply(new BigInteger("2")));
			}
			N = br.readLine();
		}
		pw.flush();
		pw.close();
	}
}
