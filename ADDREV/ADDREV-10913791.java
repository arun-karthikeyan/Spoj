import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
	private static int reverseNum(int number)
	{
		int reversedNum = 0;
		
		while(number>0)
		{
			reversedNum = (reversedNum*10) + number%10;
			number/=10;
		}
		
		return reversedNum;
	}
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int testcases = Integer.parseInt(br.readLine());
	
	for(int t=0;t<testcases;++t)
	{
		StringTokenizer st = new StringTokenizer(br.readLine());
		pw.println(reverseNum(reverseNum(Integer.parseInt(st.nextToken()))+reverseNum(Integer.parseInt(st.nextToken()))));
		
	}

	pw.flush();
	pw.close();
}
}
