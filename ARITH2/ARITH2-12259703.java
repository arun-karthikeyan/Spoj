import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int testcases = Integer.parseInt(br.readLine());
	
	for(int t=0;t<testcases;++t)
	{
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Long> results = new Stack<Long>();
		
		while(st.hasMoreTokens())
		{
			String currentToken = st.nextToken();
			if(currentToken.equals("="))
			{
				pw.println(results.pop());
			}
			else
			if(!isOperator(currentToken))
			{
				results.push(Long.parseLong(currentToken));
			}
			else
				{
					long v1 = results.pop();
					long v2 = Long.parseLong(st.nextToken());
				
					long intermediateResult = getResult(currentToken.charAt(0),v1,v2);
					results.push(intermediateResult);
				}
		}
	}

	pw.flush();
	pw.close();
}
private static long getResult(Character operator, long v1, long v2) throws Exception
{
	switch(operator)
	{
	case '+' : 
		return v1+v2;
	case '-' :
		return v1-v2;
	case '*' :
		return v1*v2;
	case '/' :
		return v1/v2;
	default :
		throw new Exception("Invalid Operator");
	}
}
private static boolean isOperator(String value)
{
	return (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/"));
}

}
