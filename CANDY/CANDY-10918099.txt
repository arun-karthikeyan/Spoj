import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int N = Integer.parseInt(br.readLine());
	
	while(N!=-1)
	{
		int[] values = new int[N];
		int total=0;
		for(int i=0;i<N;++i)
		{
			values[i]=Integer.parseInt(br.readLine());
			total+=values[i];
		}
		if(total%N==0)
		{
			int eachBox = total/N;
			int moves = 0;
			for(int i=0;i<N;++i)
			{
				moves+=Math.abs(values[i]-eachBox);
			}
			moves/=2;
			pw.println(moves);
		}
		else
		{
			pw.println("-1");
		}
	
		
		N = Integer.parseInt(br.readLine());
	}

	pw.flush();
	pw.close();
}
}
