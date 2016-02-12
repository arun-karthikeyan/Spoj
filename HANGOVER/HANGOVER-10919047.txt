import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	double value = Double.parseDouble(br.readLine());
	while(value!=0d)
	{
		double ans = 0d;
		double cards = 1;
		while(ans<value)
		{
			cards++;
			ans+=(1/cards);
		}
		pw.println((int)(cards-1)+" card(s)");
		value = Double.parseDouble(br.readLine());
	}

	pw.flush();
	pw.close();
}
}
