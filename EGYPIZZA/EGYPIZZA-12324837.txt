import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int n = Integer.parseInt(br.readLine());
	int threeFourths=0,oneFourths=0,halfs=0,totalCount=0;
	for(int i=0;i<n;++i)
	{
		String val = br.readLine();
		int v1 = val.charAt(0)-'0';
		int v2 = val.charAt(2)-'0';
		if(v1==3)
		{
			threeFourths++;
		}
		else
			if(v2==2)
		{
			halfs++;
		}
			else
			{
				oneFourths++;
			}
	}
	
	totalCount = halfs/2;
	halfs=halfs-(totalCount*2);
	totalCount+=halfs;
	if(threeFourths>oneFourths)
	{
		totalCount += oneFourths;
		threeFourths-=oneFourths;
		totalCount += threeFourths;
	}
	else
		if(oneFourths>threeFourths)
	{
		totalCount += threeFourths;
		oneFourths -= threeFourths;
		if(halfs>0)
		{
			if(oneFourths>1)
			{
				oneFourths-=2;
			}
			else
			{
				oneFourths = 0;
			}
		}
		totalCount = totalCount + oneFourths/4 + (((oneFourths%4)>0)?1:0);
	}
		else
		{
			totalCount += threeFourths;
		}
	totalCount++;
	pw.println(totalCount);
	
	pw.flush();
	pw.close();
}
}
