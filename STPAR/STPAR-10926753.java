import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int trucks = Integer.parseInt(br.readLine());
	
	while(trucks!=0)
	{
		int[] alltrucks = new int[trucks];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> sideStreet = new Stack<Integer>();
		boolean possible = true;
		
		for(int i=0;i<trucks;++i)
		{
			alltrucks[i] = Integer.parseInt(st.nextToken());
		}
		int j=0,nextTruck=1;
		
		while(j<trucks)
		{
			if(alltrucks[j]!=nextTruck)
			{
				while(!sideStreet.isEmpty())
				{
				int firstTruck = sideStreet.peek();
				if(firstTruck==nextTruck)
				{
					sideStreet.pop();
					nextTruck++;
				}
				else
				{
					break;
				}
				}
					sideStreet.push(alltrucks[j]);
			}
			else
			{
				nextTruck++;
			}
			++j;
		}
		if(possible)
		{
		while(!sideStreet.isEmpty())
		{
			int nextAvailableTruck = sideStreet.pop();
			if(nextAvailableTruck!=nextTruck)
			{
				possible = false;
				break;
			}
			else
			{
				nextTruck++;
			}
		}
		}
		if(!possible || (nextTruck)!=(trucks+1) || !sideStreet.isEmpty())
		{
			pw.println("no");
		}
		else
		{
			pw.println("yes");
		}
		
		
		trucks = Integer.parseInt(br.readLine());
	}

	pw.flush();
	pw.close();
}
}
