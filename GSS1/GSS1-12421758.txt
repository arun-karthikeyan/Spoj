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

	private static int log2(int val) {
		int logVal = 0;
		while (val > 0) {
			logVal++;
			val >>= 1;
		}
		return logVal;
	}

	private static int expPower(int n) {
		if (n == 0)
			return 1;
		int m = expPower(n >> 1);
		m *= m;
		if ((n & 1) == 1)
			m *= 2;
		return m;
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
	}

	private static void initialize(int node, int begin, int end, Node[] tree,
			int[] prefixSum) {
		if (begin == end) {
			tree[node].max = prefixSum[end];
			tree[node].min = prefixSum[begin-1];
			tree[node].maxSum = prefixSum[end] - prefixSum[begin - 1];
		} else {
			initialize(node << 1, begin, (begin + end) >> 1, tree, prefixSum);
			initialize((node << 1) + 1, ((begin + end) >> 1) + 1, end, tree,
					prefixSum);

			tree[node].max = max(tree[node << 1].max, tree[(node << 1) + 1].max);
			tree[node].min = min(tree[node << 1].min, tree[(node << 1) + 1].min);
			tree[node].maxSum = max(tree[node << 1].maxSum,
									max(tree[(node << 1) + 1].maxSum,
											tree[(node << 1) + 1].max
												- tree[node << 1].min));
		}
	}

	private static Node query(int node, int begin, int end, int i, int j,
			Node[] tree) {
		if (i > end || j < begin)
			return null;

		if (begin >= i && end <= j) {
			return tree[node];
		}

		Node n1 = query(node << 1, begin, (begin + end) >> 1, i, j, tree);
		Node n2 = query((node << 1) + 1, ((begin + end) >> 1) + 1, end, i, j,
				tree);

		if (n1 == null) {
			return n2;
		}
		if (n2 == null) {
			return n1;
		}
		return new Node(min(n1.min, n2.min), max(n1.max, n2.max),max(n1.maxSum, max(n2.maxSum, (n2.max - n1.min))));
	}

	public static void main(String[] args) throws Exception {
//		long start = System.currentTimeMillis();
//		is = INPUT.isEmpty() ? new FileInputStream("testcase_CYATQ1.txt") : new ByteArrayInputStream(
//				INPUT.getBytes());
//		out = new PrintWriter("CYATQ_OP2.txt");
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
				INPUT.getBytes());
		out = new PrintWriter(System.out);
		int maxElements = ni();
		int totalNodes = expPower(log2(maxElements + 1) + 1) + 1;
		Node[] tree = new Node[totalNodes];

		for (int i = 0; i < totalNodes; ++i) {
			tree[i] = new Node();
		}

		int[] prefixSum = new int[maxElements + 1];
		for (int i = 1; i <= maxElements; ++i) {
			prefixSum[i] = prefixSum[i - 1] + ni();
		}
		initialize(1, 1, maxElements, tree, prefixSum);
		int queries = ni();

		for (int q = 0; q < queries; ++q) {
			int i = ni(), j = ni();
			out.println(query(1, 1, maxElements, i, j, tree).maxSum);
//			out.println(i+" "+j+" "+query(1, 1, maxElements, i, j, tree, prefixSum).maxSum);
		}
		out.flush();
//		long end = System.currentTimeMillis();
//		System.out.println("Time Taken : "+(end - start));
	}
}

class Node {
	int min, max, maxSum;

	public Node() {
		this.min = this.max = this.maxSum = 0;
	}

	public Node(int min, int max, int maxSum) {
		this.min = min;
		this.max = max;
		this.maxSum = maxSum;
	}
}

