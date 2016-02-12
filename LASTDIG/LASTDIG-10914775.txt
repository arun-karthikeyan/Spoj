import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		int[] mods = { 1, 1, 4, 4, 2, 1, 1, 4, 4, 2 };
		int testcases = in.nextInt();

		for (int t = 0; t < testcases; ++t) {
			
			int a = in.nextInt()%10;
			long b = in.nextLong();
			if(b==0)
			{
				System.out.println("1");
			}
			else
			{
			b%=mods[a];
			if(b==0)
			{
				b=mods[a];
			}
			System.out.println(((int)Math.pow(a,b))%10);
			}
		}
	}
}
