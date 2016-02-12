import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
	
private static final int NOOFPRIMES = 3401;
private static final int PRIMELIMIT = 31624;
private static int[] primes = new int[NOOFPRIMES];
private static int totalchars=0,offset=0;
private static InputStream stream;
private static byte[] buffer=new byte[1024];
private static void init()
{
	boolean[] notPrimes = new boolean[PRIMELIMIT];
	notPrimes[0]=notPrimes[1]=true;
	for(int i=2,k=0;i<PRIMELIMIT;++i)
	if(!notPrimes[i])
	{
		primes[k++]=i;
		for(int j=2*i;j<PRIMELIMIT;j+=i)
		notPrimes[j] = true;
	}
	
}
public static void main(String[] args) {
	init();
	stream = System.in;
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
	int testcases = readInt();
	
	for(int t = 0;t<testcases;++t)
	{
		int m = readInt();
		int n = readInt();
		m=m==1?m+1:m;
		int diff = (int)(n-m)+1;

		boolean[] identifyPrimes = new boolean[diff];
		
		for(int i=0;i<NOOFPRIMES && primes[i]<=n;++i)
		{
			int currentPrime = primes[i];
			int startIndex = (int) Math.ceil((double)m/(double)currentPrime) * currentPrime;
			startIndex=startIndex==currentPrime?2*startIndex:startIndex;
			
			for(int j=startIndex;j<=n;j+=currentPrime)
			identifyPrimes[(j-m)] = true;
		}
		for(int i = 0;i<diff;++i)
			if(!identifyPrimes[i])
			pw.println(m+i);
		pw.println();
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
