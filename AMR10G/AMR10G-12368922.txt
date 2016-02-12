import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {
	private static int totalchars = 0, offset = 0;
	private static InputStream stream;
	private static byte[] buffer = new byte[65536];

	private static int readByte() {
		if (totalchars < 0)
			return 0;
		if (offset >= totalchars) {
			offset = 0;
			try {
				totalchars = stream.read(buffer);
			} catch (IOException e) {
				return 0;
			}
			if (totalchars <= 0)
				return -1;
		}
		return buffer[offset++];
	}

	private static int readInt() {
		int number = readByte();

		while (eolchar(number))
			number = readByte();

		int sign = 1;
		int val = 0;

		if (number == '-') {
			sign = -1;
			number = readByte();
		}

		do {
			if ((number < '0') || (number > '9'))
				return 0;
			val *= 10;
			val += (number - '0');
			number = readByte();
		} while (!eolchar(number));

		return sign * val;
	}

	private static long readLong() {
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

	private static boolean eolchar(int c) {
		return c == ' ' || c == '\n' || c == -1 || c == '\r' || c == '\t';
	}

	public static void main(String[] args) {
		stream = System.in;
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		int testcases = readInt();

		for (int t = 0; t < testcases; ++t) {
			int n = readInt(), k = readInt();

			Long[] values = new Long[n],temp = new Long[n];
			for (int i = 0; i < n; ++i) {
				temp[i] = values[i] = readLong();
			}
			if (k == 1) {
				pw.println("0");
			} else {
				
				mergeSort(0, n-1, values, temp);
				long minDiff = Long.MAX_VALUE;

				for (int i = k - 1; i < n; ++i) {
					minDiff = min(minDiff, values[i] - values[i - k + 1]);
				}
				pw.println(minDiff);
			}
		}

		pw.flush();
		pw.close();
	}

	private static long min(long a, long b) {
		return a < b ? a : b;
	}

	private static void mergeSort(int low, int high,
			Long[] values, Long[] temp) {
		int mid;

		if (high > low) {
			mid = low + (high - low) / 2;

			mergeSort(low, mid, values, temp);
			mergeSort(mid + 1, high, values, temp);
			mergeSortedValues(low, mid + 1, high, values, temp);
		}
	}

	private static void mergeSortedValues(int low, int mid, int high,
			Long[] values, Long[] temp) {
		int i = low, j = mid, k = low;

		while ((i <= (mid - 1)) && (j <= high)) {
			if (temp[j] < temp[i]) {
				values[k++] = temp[j++];
			} else {
				values[k++] = temp[i++];
			}

		}

		while (i <= (mid - 1)) {
			values[k++] = temp[i++];
		}

		while (j <= high) {
			values[k++] = temp[j++];
		}

		for (int off = low; off <= high; ++off) {
			temp[off] = values[off];
		}
	}
}
