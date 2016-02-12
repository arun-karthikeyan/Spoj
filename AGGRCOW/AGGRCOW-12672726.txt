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

	static int[] barnLocations;
	static int barns, cows;

	public static void main(String[] args) {
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
				INPUT.getBytes());
		out = new PrintWriter(System.out);

		int tcs = ni();

		while (tcs-- > 0) {
			barns = ni();
			cows = ni();
			barnLocations = new int[barns];

			for (int i = 0; i < barns; ++i) {
				barnLocations[i] = ni();
			}

			Arrays.sort(barnLocations);

			out.println(search(barnLocations[barns - 1] - barnLocations[0], 1));

		}

		out.flush();
	}

	private static int search(int high, int low) {
		while (high > low) {
			int mid = low + (high - low + 1) / 2; // upper bound required &
													// hence the +1

			if (predicate(mid)) {
				high = mid - 1;
			} else {
				low = mid;
			}
		}

		return high;
	}

	private static boolean predicate(int minDistance) {
		int total = cows;
		for (int i = 0, j = barnLocations.length, prevIndex = 0; i < j
				&& total > 0; ++i) {
			if ((barnLocations[i] - barnLocations[prevIndex]) >= minDistance) {
				total--;
				prevIndex = i;
			}
		}
		return total > 1;
	}
}
