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
private static final int COST = 0, FUN = 1;
public static void main(String[] args) {
	is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
			INPUT.getBytes());
	out = new PrintWriter(System.out);
	
	int budget = ni(), n = ni();
	
	while(budget!=0 || n!=0)
	{
		int[][] partySchedule = new int[n][2];
		
		for(int i=0;i<n;++i)
		{
			partySchedule[i][COST] = ni();
			partySchedule[i][FUN] = ni();
		}
		
		Arrays.sort(partySchedule, new java.util.Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				return o1[COST]-o2[COST];
			}
		});
		
		int[][][] knapSack = new int[n][budget+1][2];
		
		if(partySchedule[0][COST]<=budget)
		{
			
			for(int i=partySchedule[0][COST];i<=budget;++i)
			{
				knapSack[0][i][FUN] = partySchedule[0][FUN];
				knapSack[0][i][COST] = partySchedule[0][COST];
			}
			
			for(int i=1;i<n;++i)
			{
				if(partySchedule[i][COST]<=budget)
				{
				for(int j=0;j<partySchedule[i][COST];++j)
				{
					knapSack[i][j] = knapSack[i-1][j];
				}
				for(int j=partySchedule[i][COST];j<=budget;++j)
				{
					int fun1 = knapSack[i-1][j][FUN], fun2  = knapSack[i-1][j-partySchedule[i][COST]][FUN]+partySchedule[i][FUN];
					int cost1 = knapSack[i-1][j][COST], cost2 =knapSack[i-1][j-partySchedule[i][COST]][COST] + partySchedule[i][COST]; 
					if(fun1>fun2)
					{
						knapSack[i][j][FUN] = fun1;
						knapSack[i][j][COST] = cost1;
					}
					else
						if(fun2>fun1)
						{
							knapSack[i][j][FUN] = fun2;
							knapSack[i][j][COST] = cost2;
						}
						else
						{
							knapSack[i][j][FUN] = fun1;
							knapSack[i][j][COST] = min(cost1,cost2);
						}
				}
				}
				else
				{
					for(int j=0;j<=budget;++j)
					{
						knapSack[i][j] = knapSack[i-1][j];
					}
				}
			}
			out.println(knapSack[n-1][budget][COST]+" "+knapSack[n-1][budget][FUN]);
		}
		else
		{
			out.println(0+" "+0);
		}
		budget = ni(); n = ni();
	}
	

	out.flush();
}
private static int min(int a, int b)
{
	return a<b?a:b;
}
}
