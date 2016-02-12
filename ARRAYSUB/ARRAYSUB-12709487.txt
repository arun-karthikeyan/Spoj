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

private static int log2(int val)
{
	int count = 1;
	while(val>0)
	{
		val>>=1;
		count++;
	}
	return count;
}

private static int init(int node,int begin, int end,int[] tree, int[] array)
{
	if(begin == end)
	{
		return tree[node] = array[begin];
	}
	else
	{
		int v1 = init(node<<1,begin,(begin+end)>>1,tree,array);
		int v2 = init((node<<1)+1,((begin+end)>>1)+1,end,tree,array);
		
		if(v1>v2)
		{
			return tree[node] = v1; 
		}
		else
		{
			return tree[node] = v2;
		}
	}
}

private static int query(int node, int begin, int end,int i, int j, int[] tree)
{
	if(begin>j || end <i)
	{
		return -1;
	}
	if(begin>=i && end<=j)
	{
		return tree[node];
	}
	
	int v1 = query(node<<1,begin,(begin+end)>>1,i,j,tree);
	int v2 = query((node<<1)+1,((begin+end)>>1)+1,end,i,j,tree);
	
	if(v1==-1)
	{
		return v2;
	}
	if(v2 == -1)
	{
		return v1;
	}
	if(v1>v2)
	{
		return v1;
	}
		return v2;
}

private static int modPower(int base,int power)
{
	if(power==0)
	{
		return 1;
	}
	int val = modPower(base, power/2);
	val*=val;
	if(power%2==1)
	{
		val*=2;
	}
	return val;
}

public static void main(String[] args) {
	is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
			INPUT.getBytes());
	out = new PrintWriter(System.out);
	int n = ni();
	int[] tree = new int[modPower(2,log2(n))+1];
	int[] array = new int[n];
	for(int i=0;i<n;++i)
	{
		array[i] = ni();
	}
	int k = ni();
	init(1, 0, n-1, tree, array);
	
	out.print(query(1,0,n-1,0,k-1, tree));
	
	for(int i=1,j=n-k;i<=j;++i)
	{
		out.print(" "+query(1,0,n-1, i, i+k-1, tree));
	}
	out.println();
	out.flush();
}
}
