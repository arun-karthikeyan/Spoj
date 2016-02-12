import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
private static final String ink = "machula";
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
	int testcases = Integer.parseInt(br.readLine());
	
	for(int t=0;t<testcases;++t)
	{
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine(),"=");
		String firstPart = st.nextToken();
		String result = st.nextToken().trim();
		st = new StringTokenizer(firstPart,"+");
		String number1 = st.nextToken().trim(),number2 = st.nextToken().trim();
		if(number1.contains(ink))
		{
			number1 = (Integer.parseInt(result)-Integer.parseInt(number2))+"";
		}
		else
			if(number2.contains(ink))
			{
				number2 = (Integer.parseInt(result)-Integer.parseInt(number1))+"";
			}
			else
				if(result.contains(ink))
			{
				result = (Integer.parseInt(number2)+Integer.parseInt(number1))+"";
			}
		pw.println(number1+" + "+number2+" = "+result);
		
	}

	pw.flush();
	pw.close();
}
}
