import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	int columns = Integer.parseInt(br.readLine());
	
	while(columns!=0)
	{
		String encryptedValues = br.readLine();
		int len = encryptedValues.length();
		int rows = len/columns;
		
		char[][] decryptedMessage = new char[rows][columns];
		StringBuilder temp = new StringBuilder();
		
		for(int i=0,j=0;i<len;++i)
		{
			temp.append(encryptedValues.charAt(i));
			if((i+1)%columns==0)
			{
				if(j%2==0)
				{
					for(int start=0;start<columns;++start)
					{
						decryptedMessage[j][start]=temp.charAt(start);
					}
				}
				else
				{
					for(int start=0;start<columns;++start)
					{
						decryptedMessage[j][columns-start-1]=temp.charAt(start);
					}
				}
				j++;
				temp = new StringBuilder();
			}
		}
		for(int i=0;i<columns;++i)
		{
			for(int j=0;j<rows;++j)
			{
				pw.print(decryptedMessage[j][i]);
			}
		}
		pw.println();
		columns = Integer.parseInt(br.readLine());
	}

	pw.flush();
	pw.close();
}
}
