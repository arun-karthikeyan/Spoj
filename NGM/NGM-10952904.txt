import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int no = Integer.parseInt(br.readLine());
	
	if((no%10)==0)
	{
		pw.println("2");
	}
	else
	{
		pw.println("1");
		pw.println(no%10);
	}

	pw.flush();
	pw.close();
}
}
