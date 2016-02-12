import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	BufferedReader br = new BufferedReader(new FileReader("javac.txt"));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	String identifier = "";
	
	while((identifier=br.readLine())!=null)
	{
		LinkedList<Integer> capsOffset = new LinkedList<Integer>();
		
		LinkedList<Integer> underScoreOffset = new LinkedList<Integer>();
		
		boolean isError = false;
		
		for(int i=0,j=identifier.length();i<j;++i)
		{
			Character currentChar = identifier.charAt(i);
			
			if(Character.isUpperCase(currentChar))
			{
				capsOffset.add(i);
			}
			else
				if(currentChar == '_')
				{
					underScoreOffset.add(i);
				}
			
			if((capsOffset.size()>0 && underScoreOffset.size()>0) || (capsOffset.size() == identifier.length()) || (underScoreOffset.size() == identifier.length()) || (identifier.charAt(identifier.length()-1) == '_') || (identifier.charAt(0) == '_') || (Character.isUpperCase(identifier.charAt(0))))
			{
				isError = true;
				break;
			}
		}
		
		if(isError)
		{
			pw.println("Error!");
//			pw.println(identifier + " Error!");
		}
		else
			if(capsOffset.size()>0)
		{
			StringBuilder javaToC = new StringBuilder();
			Iterator<Integer> offsets = capsOffset.iterator();
			int previous = 0;
			while(offsets.hasNext())
			{
				int currentOffset = offsets.next();
				javaToC = javaToC.append(identifier.substring(previous, currentOffset)).append('_').append(Character.toLowerCase(identifier.charAt(currentOffset)));
				previous = currentOffset+1;
			}
			if(previous < identifier.length())
			{
				javaToC = javaToC.append(identifier.substring(previous,identifier.length()));
			}
			pw.println(javaToC.toString());
//			pw.println(identifier+" "+javaToC.toString());
		}
			else
				if(underScoreOffset.size()>0)
				{
					StringBuilder cToJava = new StringBuilder();
					Iterator<Integer> offsets = underScoreOffset.iterator();
					int previous = 0;
					while(offsets.hasNext())
					{
						int currentOffset = offsets.next();
						Character nextChar = identifier.charAt(currentOffset+1);
						if(!isAlphabet(nextChar))
						{
							cToJava = new StringBuilder("Error!");
							previous = identifier.length();
							break;
//							previous++;
//							continue;
						}
						cToJava = cToJava.append(identifier.substring(previous,currentOffset)).append(Character.toUpperCase(identifier.charAt(currentOffset+1)));
						previous = currentOffset + 2;
					}
					if(previous<identifier.length())
					{
						cToJava = cToJava.append(identifier.substring(previous, identifier.length()));
					}
					
					pw.println(cToJava.toString());
//					pw.println(identifier+" "+cToJava.toString());
				}
				else
				{
					pw.println(identifier);
//					pw.println(identifier+" "+identifier);
				}
		
	}

	pw.flush();
	pw.close();
//	br.close();
}
private static boolean isAlphabet(Character c)
{
	return ((c>='a' && c<='z') || (c>='A' && c<='Z'));
}
}
