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
	
	int A = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());
	
	while(A!=0 || D!=0)
	{
		int dMin1,dMin2,aMin;
		
		st = new StringTokenizer(br.readLine());
		
		aMin = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<A;++i)
		{
			int val = Integer.parseInt(st.nextToken());
			
			if(val<aMin)
			{
				aMin = val;
			}
		}
		st = new StringTokenizer(br.readLine());
		dMin2 = Integer.parseInt(st.nextToken());
		dMin1 = Integer.MAX_VALUE;
		for(int i=1;i<D;++i)
		{
			int val = Integer.parseInt(st.nextToken());
			
			if(val <= dMin1)
			{
				if(val <= dMin2)
				{
					dMin1 = dMin2;
					dMin2 = val;
					
				}
				else
				{
					dMin1 = val;
				}
			}
		}
		
		if(aMin>=dMin1)
		{
			pw.println("N");
		}
		else
		{
			pw.println("Y");
		}
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
	}

	pw.flush();
	pw.close();
}
}
