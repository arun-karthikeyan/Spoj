import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
	ArrayList<Integer> values = new ArrayList<Integer>();
	values.add(0);
	int cumValue = 0;
	
	for(int i=1;cumValue<=(int)1e7;++i)
	{
		cumValue+=i;
		values.add(cumValue);
	}
		
	int testcases = Integer.parseInt(br.readLine());
	
	for(int t=0;t<testcases;++t)
	{
		int value = Integer.parseInt(br.readLine());
		int getPosition = Collections.binarySearch(values,value);
		if(getPosition<0)
		{
			getPosition*=-1;getPosition--;
		}
		int v1 = value-values.get(getPosition-1);
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
