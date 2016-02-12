import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
	private static int totalchars=0,offset=0;
	private static InputStream stream;
	private static byte[] buffer=new byte[1024];
public static void main(String[] args) throws Exception {
	stream = System.in;
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	int testcases = readInt();
	
	for(int t=0;t<testcases;++t)
	{
		int val = readInt();
		int ans = 0;
		for(int i=1;(i*i<=val);++i)
		{
			if(val%i==0)
			{
				ans+=i+val/i;
			}
		}
		int sqrt = (int) Math.sqrt(val);
		ans-=val;
		if(sqrt*sqrt == val)
		{
			ans-=sqrt;
		}
		
		
		pw.println(ans);
	}
	

	pw.flush();
	pw.close();
}

private static int readByte() {
	if(totalchars < 0)
		return 0;
	if(offset >= totalchars) {
		offset = 0;
		try 
		{
			totalchars = stream.read(buffer);
		}
		catch(IOException e) 
		{
			return 0;
		}
		if(totalchars <= 0)
			return -1;
	}
	return buffer[offset++];
}

	

private static int readInt()
{
	int number=readByte();

	while(eolchar(number))
		number=readByte();
	
	int sign=1;
	int val=0;
	
	if(number=='-')
		{
		sign=-1;
		number=readByte();
		}
				
	do
		{
			if((number<'0')||(number>'9'))
				return 0;
			val*=10;
			val+=(number-'0');
			number=readByte();
		}
	while(!eolchar(number));
	
	return sign*val;
}

private static boolean eolchar(int c)
{
	return c==' '||c=='\n'||c==-1||c=='\r'||c=='\t';
}
}
 