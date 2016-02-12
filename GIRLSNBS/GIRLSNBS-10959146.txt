import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	StringTokenizer st = new StringTokenizer(br.readLine());
	int G = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
	
	while(G!=-1 || B!=-1)
	{
		pw.println((int)Math.ceil((Math.max(G,B))/(Math.min(G, B)+1d)));
		st = new StringTokenizer(br.readLine());
		G = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken());
	}
	
	pw.flush();
	pw.close();
}
}
