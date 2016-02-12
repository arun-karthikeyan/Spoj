import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//Next Nearest Palidrome
public class Main {
	private static String prepend;
	private static boolean makeObviousPalin(char[] val,int len)
	{
		boolean isGreater = false,checked = false;
		
		for(int i=(len/2)-1;i>=0;--i)
		{
			char c1 = val[len-i-1],c2 = val[i];
			if(!checked)
			{
				if(c1>c2)
					{
						isGreater = false;
						checked = true;
					}
					else
						if(c2>c1)
						{
							isGreater = true;
							checked = true;
						}
			}
			val[len-i-1]=c2;
		}
		return isGreater;
	}
	
	private static void makeCenterPalin(char[] val,int len)
	{
		int pos = len/2;
		char posChar = val[pos];
		boolean requiresReconstruction = posChar=='9';
		if(len%2==1)
		{
			for(int i=pos;i>=0;--i)
			{
				char c = val[i];
				if(c!='9')
				{
					c++;
					val[i]=val[len-i-1]=c;
					break;
				}
				else
				{
					val[i]=val[len-i-1]='0';
				}
			}
		}
		else
		{
			if(requiresReconstruction)
			{
				val[pos-1]=val[pos]='0';
				for(int i=pos-2;i>=0;--i)
				{
					char temp = val[i];
					if(temp!='9')
					{
						temp++;
						val[i]=val[len-i-1]=temp;
						break;
					}
					else
					{
						val[i]=val[len-i-1]='0';
					}
				}
			}
			else
			{
				posChar++;
				val[pos-1]=val[pos]=posChar;
				
			}
		}
		if(val[0]=='0')
		{
			prepend="1";
			val[len-1]='1';
		}
	}
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	int testcases = Integer.parseInt(br.readLine());
	for(int t=0;t<testcases;++t)
	{
		char[] currentNo = br.readLine().toCharArray();
		prepend="";
		int length = currentNo.length;
		if(makeObviousPalin(currentNo, length))
		{
			pw.println(currentNo);
		}
		else
		{
			makeCenterPalin(currentNo, length);
			pw.print(prepend);
			pw.println(currentNo);
		}
	}

	pw.flush();
	pw.close();
}
}
