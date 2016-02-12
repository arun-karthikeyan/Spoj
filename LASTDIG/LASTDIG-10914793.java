import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int[] mods = { 1, 1, 4, 4, 2, 1, 1, 4, 4, 2 };
		int[][] lastDig = { { 0 }, { 1 }, { 6, 2, 4, 8 }, { 1, 3, 9, 7 },
				{ 6, 4 }, { 5 }, { 6 }, { 1, 7, 9, 3 }, { 6, 8, 4, 2 },
				{ 1, 9 } };
		int testcases = in.nextInt();

		for (int t = 0; t < testcases; ++t) {
			int a = in.nextInt()%10, b = in.nextInt();
			if(b==0)
			{
				System.out.println("1");
			}
			else
			{
				System.out.println(lastDig[a][b%mods[a]]);
			}
		}
	}
}
