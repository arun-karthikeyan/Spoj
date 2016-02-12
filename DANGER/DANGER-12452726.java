import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
	private static final int[] zeroes = {1,10,100,1000,10000,100000,1000000};
	private static int getParsedNumber(String value)
	{
		int number = value.charAt(0)-'0';
		number=number*10+(value.charAt(1)-'0');
		number*=zeroes[value.charAt(3)-'0'];
		return number;
		
	}
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	int number = 0;
	while((number = getParsedNumber(br.readLine()))!=0)
	{
		int original = number;
		number>>=1;
		for(int i=1;i<number;i<<=1)
		{
			number|=i;
		}
		number++;
		pw.println(2*(original-number)+1);
	}
	pw.flush();
	pw.close();
}
}
