import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
	int perimeter = Integer.parseInt(br.readLine());
	DecimalFormat df = new DecimalFormat("0.00");
	while(perimeter!=0)
	{
		double radius = (perimeter/Math.PI);
		pw.println(df.format((Math.PI*radius*radius)/2));
		perimeter = Integer.parseInt(br.readLine());
	}
	
	pw.flush();
	pw.close();
}
}
