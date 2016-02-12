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

static final int LIMIT = 2000;
public static void main(String[] args) {
	is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
			INPUT.getBytes());
	out = new PrintWriter(System.out);

	char[] input = new char[LIMIT];
	int b = skip(), p = 0;
	while (p<LIMIT  && !(isSpaceChar(b))) {
		input[p++] = (char) b;
		b = readByte();
	}
	int tcs = 1;
	while(input[0]!='-')
	{
		int stackSimulator = 0, result = 0;
		for(int i=0;i<p;++i)
		{
			if(input[i]=='{')
			{
				stackSimulator++;
			}
			else
			{
				if(stackSimulator>0)
				{
					stackSimulator--;
				}
				else
				{
					result++;
					stackSimulator++;
				}
			}
		}
		out.println(tcs+"."+" "+(result+(stackSimulator/2)));
		b = skip(); p = 0;
		while (p<LIMIT  && !(isSpaceChar(b))) {
			input[p++] = (char) b;
			b = readByte();
		}
		tcs++;
	}

	out.flush();
}
}
