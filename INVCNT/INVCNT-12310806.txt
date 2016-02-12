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
//	long start = System.currentTimeMillis();
	stream = System.in;
//	stream = new FileInputStream("testcase.txt");
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
	int testcases = readInt();
	
	for(int t=0;t<testcases;++t)
	{
		int n = readInt();
		
		Integer[] values = new Integer[n];
		Integer[] temp = new Integer[n];
		
		for(int i=0;i<n;++i)
		{
			temp[i] = values[i] = readInt();
			
		}
		
		pw.println(getInversionCount(values,temp));
	}
//	long end = System.currentTimeMillis();
//	System.out.println("Time Taken : "+(end-start));
	pw.flush();
	pw.close();
}

private static long getInversionCount(Integer[] values,Integer[] temp)
{
	return mergeAndGetInversionCount(0,values.length-1,values,temp);
}

private static long mergeAndGetInversionCount(int low, int high, Integer[] values,Integer[] temp)
{
	int mid;
	long invCount=0;
	
	if(high>low)
	{
		invCount = 0;
		mid = low + (high-low)/2;
		
		invCount = mergeAndGetInversionCount(low,mid,values,temp);
		invCount+= mergeAndGetInversionCount(mid+1,high,values,temp);
		
		invCount += mergeSortedValues(low,mid+1,high,values,temp);
	}
	return invCount;
}

private static long mergeSortedValues(int low,int mid,int high,Integer[] values,Integer[] temp)
{
	int i=low,j=mid,k=low;
	long invCount = 0;
	
	while((i<=(mid-1)) && (j<=high))
	{
		if(temp[j]<temp[i])
		{
			values[k++] = temp[j++];
			invCount+=(mid-i);
		}
		else
		{
			values[k++] = temp[i++];
		}
		
	}
	
	while(i<=(mid-1))
	{
		values[k++] = temp[i++];
	}
	
	while(j<=high)
	{
		values[k++] = temp[j++];
	}
	
	for(int off=low;off<=high;++off)
	{
		temp[off] = values[off];
	}
	
	return invCount;
}

}
