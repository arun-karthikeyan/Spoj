import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;


public class Main {
	private static boolean isOperator(char c)
	{
		return ((c=='+') || (c=='-') || (c=='*') || (c=='/') || (c=='^'));
	}
	private static boolean isAlphabet(char c)
	{
		return ((c>='a') && (c<='z'));
	}
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int testcases = Integer.parseInt(br.readLine());
	
	for(int t=0;t<testcases;++t)
	{
		Stack<String> expression = new Stack<String>();
		Stack<Character> operators = new Stack<Character>();
		
		String algebraicExpression = br.readLine();
		
		for(int i=0,j=algebraicExpression.length();i<j;++i)
		{
			char c = algebraicExpression.charAt(i);
			if(isAlphabet(c))
			{
				expression.push(c+"");
			}
			else
				if(isOperator(c))
				{
					operators.add(c);
				}
				else
					if(c==')')
					{
						StringBuilder tempExpression = new StringBuilder();
						//if(!expression.isEmpty())
						//{
						tempExpression.insert(0,expression.pop());
						tempExpression.insert(0,expression.pop());
						tempExpression.append(operators.pop());
						expression.push(tempExpression.toString());
						//}
					}
		}
		//if(!expression.isEmpty())
		pw.println(expression.pop());
	}

	pw.flush();
	pw.close();
}
}
