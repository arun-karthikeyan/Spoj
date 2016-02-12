import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	int[] squares = new int[101];
	
	for(int i=1;i<101;++i)
	{
		squares[i] = squares[i-1]+(i*i);
	}
	
	int val = Integer.parseInt(br.readLine());
	while(val!=0)
	{
		pw.println(squares[val]);
		val = Integer.parseInt(br.readLine());
	}
	
	pw.flush();
	pw.close();
}
}
