import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;


public class Main {
	private static HashMap<Long,Long> memoi = new HashMap<Long,Long>();
	private static long maxValue(long value)
	{
		if(value == 0)
		{
			return 0;
		}
		if(memoi.containsKey(value))
		{
			return memoi.get(value);
		}
		else
		{
		long result = Math.max(value,maxValue(value/2)+maxValue(value/3)+maxValue(value/4));
		memoi.put(value, result);
		return result;
		}
	}
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	String initial="";
	while(((initial=br.readLine())!=null))
	{
		pw.println(maxValue(Long.parseLong(initial)));
	}

	pw.flush();
	pw.close();
}
}
