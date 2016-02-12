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

private static boolean eof() {
	if (lenbuf == -1)
		return true;
	int lptr = ptrbuf;
	while (lptr < lenbuf)
		if (!isSpaceChar(inbuf[lptr++]))
			return false;

	try {
		is.mark(1000);
		while (true) {
			int b = is.read();
			if (b == -1) {
				is.reset();
				return true;
			} else if (!isSpaceChar(b)) {
				is.reset();
				return false;
			}
		}
	} catch (IOException e) {
		return true;
	}
}

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

private static double nd() {
	return Double.parseDouble(ns());
}

private static char nc() {
	return (char) skip();
}

private static String ns() {
	int b = skip();
	StringBuilder sb = new StringBuilder();
	while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
		sb.appendCodePoint(b);
		b = readByte();
	}
	return sb.toString();
}

private static char[] ns(int n) {
	char[] buf = new char[n];
	int b = skip(), p = 0;
	while (p < n && !(isSpaceChar(b))) {
		buf[p++] = (char) b;
		b = readByte();
	}
	return n == p ? buf : Arrays.copyOf(buf, p);
}

private static char[][] nm(int n, int m) {
	char[][] map = new char[n][];
	for (int i = 0; i < n; i++)
		map[i] = ns(m);
	return map;
}

private static int[] na(int n) {
	int[] a = new int[n];
	for (int i = 0; i < n; i++)
		a[i] = ni();
	return a;
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

private static long nl() {
	long num = 0;
	int b;
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

private static void tr(Object... o) {
	if (INPUT.length() != 0)
		System.out.println(Arrays.deepToString(o));
}
private static int min(int a,int b)
{
	return a<b?a:b;
}
public static void main(String[] args) {
	is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
			INPUT.getBytes());
	out = new PrintWriter(System.out);

	int n = ni(), m = ni();
	int[][] DP = new int[n][m];
	
	for(int i=0;i<n;++i)
	{
		for(int j=0;j<m;++j)
		{
			DP[i][j] = ni();
		}
	}
	
	for(int i=n-2;i>=0;--i)
	{
		for(int j=0;j<m;++j)
		{
			int v1 =Integer.MAX_VALUE, v2 = Integer.MAX_VALUE, v3 = Integer.MAX_VALUE;
			
			if(j!=0)
			{
				v1 = DP[i+1][j-1];
			}
			
			v2 = DP[i+1][j];
			
			if(j!=m-1)
			{
				v3 = DP[i+1][j+1];
			}
			
			DP[i][j] = DP[i][j]+min(v1,min(v2,v3));
		}
	}
	
	int overAllMin = DP[0][0];
	
	for(int j=1;j<m;++j)
	{
		overAllMin = min(overAllMin,DP[0][j]);
	}
	out.println(overAllMin);
	out.flush();
}
}
