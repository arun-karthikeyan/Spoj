import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		String currentLine = br.readLine();
		
		while(currentLine.charAt(0)!='*')
		{
			boolean isTautogram = true;
			StringTokenizer st = new StringTokenizer(currentLine);
			char firstLetter = 32;
			if(st.hasMoreTokens())
			{
				firstLetter = Character.toLowerCase(st.nextToken().charAt(0));
			}
			while(st.hasMoreTokens())
			{
				if(firstLetter!=Character.toLowerCase(st.nextToken().charAt(0)))
				{
					isTautogram = false;
					break;
				}
			}
			if(isTautogram)
			{
				pw.println("Y");
			}
			else
			{
				pw.println("N");
			}
			currentLine = br.readLine();
		}
		
		pw.flush();
		pw.close();
	}
}
