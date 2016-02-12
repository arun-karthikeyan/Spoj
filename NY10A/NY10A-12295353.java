import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;


public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	HashMap<String,Integer> sequenceVsIndex = new HashMap<String,Integer>();
	sequenceVsIndex.put("TTT",0);
	sequenceVsIndex.put("TTH",1);
	sequenceVsIndex.put("THT",2);
	sequenceVsIndex.put("THH",3);
	sequenceVsIndex.put("HTT",4);
	sequenceVsIndex.put("HTH",5);
	sequenceVsIndex.put("HHT",6);
	sequenceVsIndex.put("HHH",7);
	
	int testcases = Integer.parseInt(br.readLine());
	
	for(int t=0;t<testcases;++t)
	{
		int testCaseNo = Integer.parseInt(br.readLine());
		String coinTosses = br.readLine();
		int[] count = new int[8];
		char[] currentSequence = new char[3];
		currentSequence[0] = coinTosses.charAt(0);
		currentSequence[1] = coinTosses.charAt(1);
		for(int i=2;i<40;++i)
		{
			currentSequence[2] = coinTosses.charAt(i);
			count[sequenceVsIndex.get(String.valueOf(currentSequence))]++;
			currentSequence[0] = currentSequence[1];
			currentSequence[1] = currentSequence[2];
		}
		
		pw.print(testCaseNo);
		for(int i=0;i<8;++i)
		{
			pw.print(" "+count[i]);
		}
		pw.println();
	}

	pw.flush();
	pw.close();
}
}
