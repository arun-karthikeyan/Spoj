import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
	private static final String wrongCoordinates = "No Number";
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int testcases = Integer.parseInt(br.readLine());
	
	for(int t=0;t<testcases;++t)
	{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
		
		if(x>=y)
		{
			int diff = x-y;
			
			if(diff==0)
			{
				int n = x;
				int constant = n/2;
				int val = 3*constant+constant + n%2;
				pw.println(val);
			}
			else
				if(diff==2)
				{
					int initial = 2;
					int n = x-initial;
					int constant = n/2;
					int val =initial+(3*constant+constant)+n%2;
					pw.println(val);
				}
				else
				{
					pw.println(wrongCoordinates);
				}
		}
		else
		{
			pw.println(wrongCoordinates);
		}
	}

	pw.flush();
	pw.close();
}
}
