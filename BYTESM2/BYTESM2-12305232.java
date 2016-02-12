import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
	private static int totalchars=0,offset=0;
	private static InputStream stream;
	private static byte[] buffer=new byte[1024];
 
	
	private static int readByte() {
		if(totalchars < 0)
			return 0;
		if(offset >= totalchars) {
			offset = 0;
			try 
			{
				totalchars = stream.read(buffer);
			}
			catch(IOException e) 
			{
				return 0;
			}
			if(totalchars <= 0)
				return -1;
		}
		return buffer[offset++];
	}
	
		
	
	private static int readInt()
	{
		int number=readByte();
	
		while(eolchar(number))
			number=readByte();
		
		int sign=1;
		int val=0;
		
		if(number=='-')
			{
			sign=-1;
			number=readByte();
			}
					
		do
			{
				if((number<'0')||(number>'9'))
					return 0;
				val*=10;
				val+=(number-'0');
				number=readByte();
			}
		while(!eolchar(number));
		
		return sign*val;
	}
	private static boolean eolchar(int c)
	{
		return c==' '||c=='\n'||c==-1||c=='\r'||c=='\t';
	}
public static void main(String[] args) throws Exception {
//	long startTime = System.currentTimeMillis();
//	BufferedReader br = new BufferedReader(new FileReader("philosophers.txt"));
	stream = System.in;
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int testcases = readInt();
	
	for(int t=0;t<testcases;++t)
	{
		int rowMax = readInt(), colMax = readInt();
		
		int[][] chamber = new int[rowMax][colMax];
		
		for(int r=0;r<rowMax;++r)
		{
			for(int c=0;c<colMax;++c)
			{
				chamber[r][c] = readInt();
			}
		}
		
		for(int r=rowMax-2;r>=0;--r)
		{
			for(int c=0;c<colMax;++c)
			{
				int leftMax = 0, rightMax = 0;
				if(c!=0)
				{
					leftMax = chamber[r+1][c-1];
				}
				if(c!=colMax-1)
				{
					rightMax = chamber[r+1][c+1];
				}
				chamber[r][c] = chamber[r][c]+Math.max(leftMax,Math.max(chamber[r+1][c], rightMax));
			}
		}
		
		int maxStones = chamber[0][0];
		
		for(int c=1;c<colMax;++c)
		{
			maxStones = Math.max(maxStones,chamber[0][c]);
		}
		pw.println(maxStones);
	}
	pw.flush();
	pw.close();
}
}
