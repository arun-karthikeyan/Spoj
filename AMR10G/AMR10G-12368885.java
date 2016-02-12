import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;


public class Main {
private static int totalchars = 0, offset = 0;
private static InputStream stream;
private static byte[] buffer = new byte[65536];

private static int readByte() {
	if (totalchars < 0)
		return 0;
	if (offset >= totalchars) {
		offset = 0;
		try {
			totalchars = stream.read(buffer);
		} catch (IOException e) {
			return 0;
		}
		if (totalchars <= 0)
			return -1;
	}
	return buffer[offset++];
}

private static int readInt() {
	int number = readByte();
	
	while (eolchar(number))
		number = readByte();
	
	int sign = 1;
	int val = 0;
	
	if (number == '-') {
		sign = -1;
		number = readByte();
	}
	
	do {
		if ((number < '0') || (number > '9'))
			return 0;
		val *= 10;
		val += (number - '0');
		number = readByte();
	} while (!eolchar(number));
	
	return sign * val;
}
private static long readLong()
{
	long num = 0;
	int b;
	boolean minus = false;
	while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
	if(b == '-'){
		minus = true;
		b = readByte();
	}
	
	while(true){
		if(b >= '0' && b <= '9'){
			num = num * 10 + (b - '0');
		}else{
			return minus ? -num : num;
		}
		b = readByte();
	}
}
private static boolean eolchar(int c) {
	return c == ' ' || c == '\n' || c == -1 || c == '\r' || c == '\t';
}
public static void main(String[] args)
{
	stream = System.in;
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
	int testcases = readInt();
	
	for(int t=0;t<testcases;++t)
	{
		int n = readInt(), k = readInt();
		
		long[] values = new long[n];
		for(int i=0;i<n;++i)
		{
			values[i] = readLong();
		}
		if(k==1)
		{
			pw.println("0");
		}
		else
		{
			Arrays.sort(values);
			long minDiff = Long.MAX_VALUE;
			
			for(int i=k-1;i<n;++i)
			{
				minDiff = min(minDiff,values[i]-values[i-k+1]);
			}
			pw.println(minDiff);
		}
	}
	
	pw.flush();
	pw.close();
}
private static long min(long a,long b)
{
	return a<b?a:b;
}
}
