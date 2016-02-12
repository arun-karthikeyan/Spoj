import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
	private static final int MOD = (int)1e6+7;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		int testcases = Integer.parseInt(br.readLine());
		for(int t=0;t<testcases;++t)
		{
			long n = Integer.parseInt(br.readLine());
			pw.println((((3*n+1)*n)/2)%MOD);
		}

		pw.flush();
		pw.close();
	}

}
