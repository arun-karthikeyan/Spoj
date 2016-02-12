import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	char[] encodedString = br.readLine().toCharArray();
	int length = 0;
	while(!((length=encodedString.length)==1 && encodedString[0]=='0'))
	{
		
		long total = 1;
		boolean previousPairJoined = false;
		long previousAddition = 0;
		for(int i=1;i<length;++i)
		{
			String pair = encodedString[i-1]+""+encodedString[i];
			if(pair.charAt(0)=='0')
			{
				continue;
			}
			if(pair.charAt(1)=='0')
			{
				if(previousPairJoined)
				{
					total-=previousAddition;
				}
				previousPairJoined = false;
				previousAddition = 0;
				continue;
			}
			int check = Integer.parseInt(pair);
			if(check>=1 && check<=26)
			{
				if(previousPairJoined)
				{
					long temp = total-previousAddition;
					total=total+temp;
					previousAddition = temp;
					previousPairJoined = true;
				}
				else
				{
					previousPairJoined = true;
					previousAddition = total;
					total*=2;
				}
			}
			else
			{
				previousPairJoined = false;
				previousAddition = 0;
			}
		}
		pw.println(total);
		encodedString = br.readLine().toCharArray();
	}

	pw.flush();
	pw.close();
}
}
