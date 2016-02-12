import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;


public class Main {
static InputStream is;
static PrintWriter out;
static String INPUT = "";

private static byte[] inbuf = new byte[1024];
static int lenbuf = 0, ptrbuf = 0;

private static int readByte() {
	if (lenbuf == -1)
		throw new InputMismatchException();
	if (ptrbuf >= lenbuf) {
		ptrbuf = 0;
		try {
			lenbuf = is.read(inbuf);
		} catch (IOException e) {
			throw new InputMismatchException();
		}
		if (lenbuf <= 0)
			return -1;
	}
	return inbuf[ptrbuf++];
}

private static int ni() {
	int num = 0, b;
	boolean minus = false;
	while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
		;
	if (b == '-') {
		minus = true;
		b = readByte();
	}

	while (true) {
		if (b >= '0' && b <= '9') {
			num = num * 10 + (b - '0');
		} else {
			return minus ? -num : num;
		}
		b = readByte();
	}
}
public static void main(String[] args) throws Exception {
	is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
			INPUT.getBytes());
	out = new PrintWriter(System.out);
	int n = ni();
	
	int[] s = new int[n];
	
	for(int i=0;i<n;++i)
	{
		s[i] = ni();
	}
	int LIMIT = n*n*n;
	int[] lhs = new int[LIMIT];
	int[] rhs = new int[LIMIT];
	int rhsCount = 0;
	
	for(int i=n-1,x=0;i>=0;--i)
	{
		for(int j=0;j<n;++j)
		{
			for(int k=n-1;k>=0;--k,++x)
			{
				lhs[x] = (s[i]*s[j])+s[k];
			}
		}
	}
	
	for(int i=0;i<n;++i)
	{
		if(s[i]!=0)
		{
			for(int j=n-1;j>=0;--j)
			{
				for(int k=0;k<n;++k)
				{
					rhs[rhsCount++] = s[i]*(s[j]+s[k]);
				}
			}
		}
	}
	
	Arrays.sort(lhs);
	Arrays.sort(rhs,0,rhsCount);
	
	int lhsIndex = 0, rhsIndex = 0;
	long result = 0;

	while(lhsIndex<LIMIT && rhsIndex<rhsCount)
	{
		if(lhs[lhsIndex]<rhs[rhsIndex])
		{
			lhsIndex++;
		}
		else
			if(lhs[lhsIndex]>rhs[rhsIndex])
			{
				rhsIndex++;
			}
			else
			{
				int iCount = 1, jCount = 1;
				lhsIndex++;rhsIndex++;
				while(lhsIndex<LIMIT && (lhs[lhsIndex]==(lhs[lhsIndex-1])))
				{
					iCount++;
					lhsIndex++;
				}
				while(rhsIndex<rhsCount && (rhs[rhsIndex]==(rhs[rhsIndex-1])))
				{
					jCount++;
					rhsIndex++;
				}
				
				result = result + (iCount*jCount);
			}
	}
	
	out.println(result);
	out.flush();
}
}
