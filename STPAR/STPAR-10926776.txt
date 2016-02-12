import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;


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

public static void main(String[] args) throws Exception {
	stream = System.in;
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int trucks = readInt();
	
	while(trucks!=0)
	{
		int[] alltrucks = new int[trucks];
		
		Stack<Integer> sideStreet = new Stack<Integer>();
		boolean possible = true;
		
		for(int i=0;i<trucks;++i)
		{
			alltrucks[i] = readInt();
		}
		int j=0,nextTruck=1;
		
		while(j<trucks)
		{
			if(alltrucks[j]!=nextTruck)
			{
				while(!sideStreet.isEmpty())
				{
				int firstTruck = sideStreet.peek();
				if(firstTruck==nextTruck)
				{
					sideStreet.pop();
					nextTruck++;
				}
				else
				{
					break;
				}
				}
					sideStreet.push(alltrucks[j]);
			}
			else
			{
				nextTruck++;
			}
			++j;
		}
		if(possible)
		{
		while(!sideStreet.isEmpty())
		{
			int nextAvailableTruck = sideStreet.pop();
			if(nextAvailableTruck!=nextTruck)
			{
				possible = false;
				break;
			}
			else
			{
				nextTruck++;
			}
		}
		}
		if(!possible || (nextTruck)!=(trucks+1) || !sideStreet.isEmpty())
		{
			pw.println("no");
		}
		else
		{
			pw.println("yes");
		}
		
		
		trucks = readInt();
	}

	pw.flush();
	pw.close();
}
}
