import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int n = Integer.parseInt(br.readLine());
	
	while(n!=0)
	{
		int[] values = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;++i)
		{
			values[i] = Integer.parseInt(st.nextToken());
		}
		boolean isAmbiguous = true;
		for(int i=1;i<=n;++i)
		{
			if(i!=values[values[i]])
			{
				isAmbiguous = false;
				break;
			}
		}
		if(isAmbiguous)
		{
			pw.println("ambiguous");
		}
		else
		{
			pw.println("not ambiguous");
		}
		n = Integer.parseInt(br.readLine());
	}

	pw.flush();
	pw.close();
}
}
