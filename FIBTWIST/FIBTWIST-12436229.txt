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


public static long[][] squareMatrixMul(long[][] a,long[][] b, long mod)
{
	long[][] c = new long[a.length][a.length];
	for(int i=0;i<a.length;++i)
	{
		for(int j=0;j<a[i].length;++j)
		{
			for(int k=0;k<a.length;++k)
			{
				c[i][j] = (c[i][j] + (a[i][k]*b[k][j])%mod)%mod;
			}
		}
	}
	return c;
}

public static long[][] matrixExpo(long[][] a,int n,int mod)
{
	if(n==1)
		return a;
	long[][] expMatrix = matrixExpo(a,n>>1,mod);
	expMatrix = squareMatrixMul(expMatrix, expMatrix, mod);
	if((n&1)==1)
		expMatrix = squareMatrixMul(expMatrix, a, mod);
	return expMatrix;
}
public static void main(String[] args) {
	is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
			INPUT.getBytes());
	out = new PrintWriter(System.out);

	long[][] matrixForm = {{1,1,1,0},{1,0,0,0},{0,0,1,1},{0,0,0,1}};
	int tcs = ni();
	for(int t=0;t<tcs;++t)
	{
		int n = ni(), mod = ni();
		if(n!=0)
		{
		long[][] resultMatrix = matrixExpo(matrixForm,n,mod);
		long result = ((resultMatrix[1][0]+resultMatrix[1][2])%mod+resultMatrix[1][3])%mod;
		out.println(result);
		}
		else
		{
			out.println(0);
		}
	}

	out.flush();
}
}
