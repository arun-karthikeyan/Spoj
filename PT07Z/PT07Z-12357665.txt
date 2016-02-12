import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	private static int totalchars = 0, offset = 0;
	private static InputStream stream;
	private static byte[] buffer = new byte[1024];

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

	private static boolean eolchar(int c) {
		return c == ' ' || c == '\n' || c == -1 || c == '\r' || c == '\t';
	}

	private static LinkedList<Integer>[] adjList;
	private static boolean[] visitedList;
	private static int nodes, maxPathLen;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		stream = System.in;
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		nodes = readInt();

		adjList = new LinkedList[nodes + 1];
		visitedList = new boolean[nodes + 1];
		maxPathLen = 1;
		for (int i = 1; i <= nodes; ++i) {
			adjList[i] = new LinkedList<Integer>();
		}

		for (int i = 1; i < nodes; ++i) {
			int from = readInt(), to = readInt();
			adjList[from].add(to);
			adjList[to].add(from);
		}
		findMaxPath(1);
		pw.println(maxPathLen - 1);
		pw.flush();
		pw.close();
	}

	private static int findMaxPath(int currentNode) {
		visitedList[currentNode] = true;
		Iterator<Integer> adjVertices = adjList[currentNode].iterator();
		int maxPath1 = Integer.MIN_VALUE, maxPath2 = Integer.MIN_VALUE;
		while (adjVertices.hasNext()) {
			int currentAdj = adjVertices.next();
			if (!visitedList[currentAdj]) {
				int currentPathLen = 1 + findMaxPath(currentAdj);
				if (currentPathLen > maxPath1) {
					maxPath2 = maxPath1;
					maxPath1 = currentPathLen;
				} else if (currentPathLen > maxPath2) {
					maxPath2 = currentPathLen;
				}
			}

		}
		if (maxPath2 != Integer.MIN_VALUE) {
			int currentPathLen = maxPath1 + maxPath2 - 1;
			if (maxPathLen < currentPathLen) {
				maxPathLen = currentPathLen;
			}
		} else if (maxPath1 != Integer.MIN_VALUE) {
			if (maxPathLen < maxPath1) {
				maxPathLen = maxPath1;
			}
		}
		return ((maxPath1 != Integer.MIN_VALUE) ? maxPath1 : 1);

	}
}
