import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int testcases = Integer.parseInt(br.readLine());
	for(int t=0;t<testcases;++t)
	{	long value = Integer.parseInt(br.readLine());
		System.out.println((value*(2*value+1)*(value+2))/8);
	}}}
