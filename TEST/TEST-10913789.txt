import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int val = Integer.parseInt(br.readLine());
	
	while(val!=42)
	{
		pw.println(val);
		val = Integer.parseInt(br.readLine());
	}

	pw.flush();
	pw.close();
}
}
