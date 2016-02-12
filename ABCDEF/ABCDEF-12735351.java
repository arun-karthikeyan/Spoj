import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

//Optimized by exploiting the commutative property of Addition and Multiplication
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

	public static void main(String[] args) {
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
				INPUT.getBytes());
		out = new PrintWriter(System.out);

		int n = ni();

		int[] originalSet = new int[n];

		for (int i = 0; i < n; ++i) {
			originalSet[i] = ni();
		}
		int setBLimit = n * n;
		int setALimit = (setBLimit * (n - 1)) / 2;
		int[] setA1 = new int[setALimit];
		int[] setA2 = new int[setALimit];
		int[] setB1 = new int[setBLimit];
		int[] setB2 = new int[setBLimit];

		for (int i = 0, x = 0, y = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j, ++y) {
				setB1[y] = originalSet[i] + (originalSet[j] * originalSet[j]);
				for (int k = j + 1; k < n; ++k, ++x) {
					setA1[x] = originalSet[i]
							+ (originalSet[j] * originalSet[k]);
				}
			}
		}
		int setB2Count = 0, setA2Count = 0;
		for (int i = 0; i < n; ++i) {
			if (originalSet[i] != 0) {
				for (int j = 0; j < n; ++j) {
					setB2[setB2Count++] = originalSet[i]
							* (originalSet[j] + originalSet[j]);
					for (int k = j + 1; k < n; ++k) {
						setA2[setA2Count++] = originalSet[i]
								* (originalSet[j] + originalSet[k]);
					}
				}
			}
		}

		Arrays.sort(setA1);
		Arrays.sort(setA2, 0, setA2Count);
		Arrays.sort(setB1);
		Arrays.sort(setB2, 0, setB2Count);

		int result = setIntersection(setA1, setALimit, setA2, setA2Count) * 4
				+ setIntersection(setB1, setBLimit, setB2, setB2Count)
				+ setIntersection(setA1, setALimit, setB2, setB2Count) * 2
				+ setIntersection(setB1, setBLimit, setA2, setA2Count) * 2;

		out.println(result);

		out.flush();
	}

	private static int setIntersection(int[] setA, int aLen, int[] setB,
			int bLen) {
		int i = 0, j = 0;
		int result = 0;

		while (i < aLen && j < bLen) {
			if (setA[i] < setB[j]) {
				i++;
			} else if (setA[i] > setB[j]) {
				j++;
			} else {
				int iCount = 1, jCount = 1;
				i++;
				j++;

				while (i < aLen && (setA[i] == setA[i - 1])) {
					iCount++;
					i++;
				}
				while (j < bLen && (setB[j] == setB[j - 1])) {
					jCount++;
					j++;
				}

				result = result + (iCount * jCount);
			}

		}
		return result;
	}

}
