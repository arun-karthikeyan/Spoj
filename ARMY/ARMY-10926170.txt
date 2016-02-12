import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int testcases = Integer.parseInt(br.readLine());
	
	for(int t = 0;t<testcases;++t)
	{
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int godzillaLen = Integer.parseInt(st.nextToken()), mechagodzillaLen = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int maxGodzilla=Integer.MIN_VALUE,maxMechagodZilla = Integer.MIN_VALUE;
		for(int i=0;i<godzillaLen;++i)
		{
			maxGodzilla=Math.max(Integer.parseInt(st.nextToken()),maxGodzilla);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<mechagodzillaLen;++i)
		{
			maxMechagodZilla=Math.max(Integer.parseInt(st.nextToken()),maxMechagodZilla);
		}
		if(maxGodzilla<maxMechagodZilla)
		{
			pw.println("MechaGodzilla");
		}
		else
		{
			pw.println("Godzilla");
		}
		
	}

	pw.flush();
	pw.close();
}
}
