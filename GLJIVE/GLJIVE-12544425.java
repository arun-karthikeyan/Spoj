import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
private static int abs(int n)
{
	return n<0?(n*-1):n;
}
public static void main(String[] args) throws Exception
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
	int[] values = new int[10];
	
	int requiredPoints = values[0] = Integer.parseInt(br.readLine());
	
	for(int i=1;i<10;++i)
	{
		values[i] = values[i-1] + Integer.parseInt(br.readLine());
	}
	int minDifference = Math.abs(requiredPoints-100);
	for(int i=1;i<10;++i)
	{
		int tempDifference = abs(values[i] - 100);
		if(tempDifference<=minDifference)
		{
			minDifference = tempDifference;
			requiredPoints = values[i];
		}
	}
	pw.println(requiredPoints);
	pw.flush();
	pw.close();
}
}
