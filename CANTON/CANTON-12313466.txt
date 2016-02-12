import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
	int testcases = Integer.parseInt(br.readLine());
	
	for(int t=0;t<testcases;++t)
	{
		int value = Integer.parseInt(br.readLine());
		int getPosition = (int)Math.ceil((Math.sqrt((4*2*value)+1)-1)/2);
		
		int v1 = value-(getPosition*(getPosition-1))/2;
		int v2 = getPosition-v1+1;
		
		if(getPosition%2==0)
		{
			pw.println("TERM "+value+" IS "+v1+"/"+v2);
		}
		else
		{
			pw.println("TERM "+value+" IS "+v2+"/"+v1);
		}
		
	}

	pw.flush();
	pw.close();
}
}
