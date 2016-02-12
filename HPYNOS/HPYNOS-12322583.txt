import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int no = Integer.parseInt(br.readLine());
	
	HashSet<Integer> value = new HashSet<Integer>();
	boolean possible = true;
	int count = 0;
	while(no!=1)
	{
		count++;
		no = getSquareSum(no);
		if(!value.add(no))
		{
			possible = false;
			break;
		}
	}
	if(!possible)
	{
		pw.println("-1");
	}
	else
	{
		pw.println(count);
	}
	
	pw.flush();
	pw.close();
}

private static int getSquareSum(int val)
{
	int squareSum = 0;
	while(val>0)
	{
		int lastDig = val%10;
		squareSum = squareSum + (lastDig*lastDig);
		val/=10;
	}
	return squareSum;
}
}
