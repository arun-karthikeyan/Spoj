import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	int[] val = new int[3];
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	val[0] = Integer.parseInt(st.nextToken());
	val[1] = Integer.parseInt(st.nextToken());
	val[2] = Integer.parseInt(st.nextToken());
	
	while(!(val[0]==0 && val[1]==0 && val[2]==0))
	{
		//Arrays.sort(val);
		int diff1 = val[1]-val[0];
		int diff2 = val[2] - val[1];
		if(diff1==diff2)
		{
			pw.println("AP "+(val[2]+diff1));
		}
		else
		{
			pw.println("GP "+((val[2]*val[2])/val[1]));
		}
		st = new StringTokenizer(br.readLine());
		val[0] = Integer.parseInt(st.nextToken());
		val[1] = Integer.parseInt(st.nextToken());
		val[2] = Integer.parseInt(st.nextToken());
	}
	

	pw.flush();
	pw.close();
}
}
