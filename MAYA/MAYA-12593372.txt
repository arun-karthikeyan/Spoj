import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
private static BufferedReader in;
private static PrintWriter out;

private static int charVal(char c) throws Exception
{
	switch(c)
	{
	case '-':
		return 5;
	case '.':
		return 1;
	case 'S':
		return 0;
	default :
		throw new Exception("Invalid Character Input");
	}
}

public static void main(String[] args) throws Exception {
	in = new BufferedReader(new InputStreamReader(System.in));
	out = new PrintWriter(new OutputStreamWriter(System.out));

	int  n = Integer.parseInt(in.readLine());
	int[] powers = {0,1,20,360,7200,144000,2880000,57600000};
	
	while(n!=0)
	{
		int totalValue = 0;
		for(int i=n;i>0;--i)
		{
			StringTokenizer currentNumber = new StringTokenizer(in.readLine());
			while(currentNumber.hasMoreElements())
			{
				String currentVal = currentNumber.nextToken();
				int tempValue = charVal(currentVal.charAt(0));
				if(tempValue==1)
				{
					tempValue = currentVal.length();
				}
				totalValue=totalValue + tempValue*powers[i];
			}
			
		}
		out.println(totalValue);
		in.readLine();
		n = Integer.parseInt(in.readLine());
	}

	out.flush();
	out.close();
}
}
