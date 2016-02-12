import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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

private static boolean isSpaceChar(int c) {
	return !(c >= 33 && c <= 126);
}

private static int skip() {
	int b;
	while ((b = readByte()) != -1 && isSpaceChar(b))
		;
	return b;
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
private static int maxLen = 6100;
public static void main(String[] args) throws Exception {
	is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
			INPUT.getBytes());
	out = new PrintWriter(System.out);
	int tcs = ni();
	
	while(tcs-->0)
	{
		char[] minPal = new char[maxLen];
		int b = skip(), p = 0;
		while (p < maxLen && !(isSpaceChar(b))) {
			minPal[p++] = (char) b;
			b = readByte();
		}
		
		int[] values = new int[p+1];
		for(int i=1;i<=p;++i)
		{
			int prevDiagonal = 0;
			for(int j=1;j<=p;++j)
			{
				int index1 = i-1, index2 = p-j, result = 0;
				result = max(values[j],values[j-1]);
				if(minPal[index1]==minPal[index2])
				{
					result = max(result,prevDiagonal+1);
				}
				prevDiagonal = values[j];
				values[j] = result;
			}
		}
		
		out.println(p-values[p]);
	}
	out.flush();
}

private static int max(int a,int b)
{
	return a>b?a:b;
}
}

