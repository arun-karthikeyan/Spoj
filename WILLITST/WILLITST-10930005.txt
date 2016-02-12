import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	long value = Long.parseLong(br.readLine());
	if(((value)&(value-1))==0)
	{
		pw.println("TAK");
	}
	else
	{
		pw.println("NIE");
	}

	pw.flush();
	pw.close();
}
}
