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

public static void main(String[] args) {
	is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
			INPUT.getBytes());
	out = new PrintWriter(System.out);

	int tcs  = ni();
	
	while(tcs-->0)
	{
		String one = ns(), two = ns();
		int len1 = one.length(), len2 = two.length();
		
		int[][] stringEdit = new int[len1+1][len2+1];
		
		for(int i=1;i<=len1;++i)
		{
			stringEdit[i][0] = i;
		}
		for(int i=1;i<=len2;++i)
		{
			stringEdit[0][i] = i;
		}
		for(int i=1;i<=len1;++i)
		{
			for(int j=1;j<=len2;++j)
			{
				stringEdit[i][j] = 1+min(stringEdit[i-1][j],stringEdit[i][j-1]);
				if(one.charAt(i-1)==two.charAt(j-1))
				{
					stringEdit[i][j] = min(stringEdit[i][j],stringEdit[i-1][j-1]);
				}
				else
				{
					stringEdit[i][j] = min(stringEdit[i][j],stringEdit[i-1][j-1]+1);
				}
			}
		}
		out.println(stringEdit[len1][len2]);
		
	}

	out.flush();
}
private static int min(int a,int b)
{
	return a<b?a:b;
}
}
