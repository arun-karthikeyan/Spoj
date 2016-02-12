import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	int val = Integer.parseInt(br.readLine());
	while(val!=0)
	{
		pw.println((((val*(val+1))*((2*val)+1))/6));
		val = Integer.parseInt(br.readLine());
	}
	pw.flush();
	pw.close();
}
}
