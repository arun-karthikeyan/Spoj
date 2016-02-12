import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
	private static BufferedReader in;
	private static PrintWriter out;
	private static int max(int a,int b)
	{
		return a>b?a:b;
	}
	private static StringBuilder add(StringBuilder a,StringBuilder b)
	{
		int aLen = a.length(), bLen = b.length();
		StringBuilder result = new StringBuilder(max(aLen,bLen)+1);
		int aPointer = aLen-1,bPointer = bLen-1;
		int carry = 0;
		while(aPointer>=0 && bPointer>=0)
		{
			int curResult = carry + (a.charAt(aPointer)-'0') + (b.charAt(bPointer)-'0');
			carry = 0;
			if(curResult>9)
			{
				carry = 1; curResult%=10;
			}
			result.append(curResult);
			aPointer--;bPointer--;
		}
		while(aPointer>=0)
		{
			int curResult = carry + (a.charAt(aPointer)-'0');
			carry = 0;
			if(curResult>9)
			{
				carry = 1;curResult%=10;
			}
			result.append(curResult);
			aPointer--;
		}
		while(bPointer>=0)
		{
			int curResult = carry + (b.charAt(bPointer)-'0');
			carry = 0;
			if(curResult>9)
			{
				carry = 1;curResult%=10;
			}
			result.append(curResult);
			bPointer--;
		}
		if(carry>0)
		{
			result.append(carry);
		}
		return result.reverse();
	}
	private static StringBuilder sub(StringBuilder a, StringBuilder b)
	{
		int aLen = a.length(), bLen = b.length();
		StringBuilder result = new StringBuilder(max(aLen,bLen));
		
		int aPointer = aLen-1,bPointer = bLen-1;
		int carry = 0;
		
		while(aPointer>=0 && bPointer>=0)
		{
			int curResult = (a.charAt(aPointer)-'0') - (b.charAt(bPointer)-'0') - carry;
			carry = 0;
			if(curResult<0)
			{
				carry = 1;
				curResult+=10;
			}
			result.append(curResult);
			aPointer--;bPointer--;
		}
		
		while(aPointer>=0)
		{
			int curResult = (a.charAt(aPointer)-'0') - carry;
			carry = 0;
			if(curResult<0)
			{
				carry = 1;
				curResult+=10;
			}
			result.append(curResult);
			aPointer--;
		}
		return result.reverse();
	}
	private static StringBuilder removeLeadingZeroes(StringBuilder result)
	{
		int offset = result.length()-1; //Leaving out the last zero
		for(int i=0,j=result.length()-1;i<j;++i)
		{
			if(result.charAt(i)!='0')
			{
				offset = i;
				break;
			}
		}
		StringBuilder newResult = new StringBuilder();
		for(int i=offset,j=result.length();i<j;++i)
		{
			newResult.append(result.charAt(i));
		}
		return newResult;
	}
	private static StringBuilder genChars(char ch,int count)
	{
		StringBuilder result = new StringBuilder();
		for(int i=0;i<count;++i)
		{
			result.append(ch);
		}
		return result;
	}
	private static void formatSimpleResult(StringBuilder a,StringBuilder b,char op,StringBuilder result)
	{
		int aLen = a.length(), resultLen = result.length(), bLen = b.length() + 1;//+1 for operator
		int maxReqSpace = max(aLen,max(bLen,resultLen));

		StringBuilder spaceForA = genChars(' ',maxReqSpace-aLen);
		StringBuilder spaceForB = genChars(' ',maxReqSpace-bLen);
		
		out.print(spaceForA);out.println(a);
		out.print(spaceForB);out.print(op);out.println(b);
		
		int hyphenLen = max(bLen,resultLen);
		StringBuilder hyphens = genChars('-',hyphenLen);
		
		StringBuilder spaceForHyphen = genChars(' ',maxReqSpace-hyphenLen);
		out.print(spaceForHyphen);out.println(hyphens);
		
		StringBuilder spaceForResult = genChars(' ',maxReqSpace-resultLen);
		out.print(spaceForResult);out.println(result);
	}
	private static void mul(StringBuilder a,StringBuilder b)
	{
		int aLen = a.length(), bLen = b.length();
		StringBuilder finalResult = new StringBuilder(aLen+bLen+1);
		
		StringBuilder[] interResults = new StringBuilder[bLen];
		
		for(int i=bLen-1,j=0;i>=0;--i,++j)
		{
			int curDigit = b.charAt(i)-'0';
			int aPointer = aLen-1;
			int carry = 0;
			StringBuilder interResult = new StringBuilder(aLen+1);
			while(aPointer>=0)
			{
				int curResult = ((a.charAt(aPointer)-'0')*curDigit)+carry;
				carry = 0;
				if(curResult>9)
				{
					carry = curResult/10;
					curResult%=10;
				}
				interResult.append(curResult);
				aPointer--;
			}
			if(carry>0)
			{
				interResult.append(carry);
			}
			interResults[j] = removeLeadingZeroes(interResult.reverse());
		}
		
		for(int i=bLen-1;i>=0;--i)
		{
			finalResult = add(finalResult.append(0),interResults[i]);
		}
		formatComplexResult(a, b, finalResult, interResults);
	}
	
	private static void formatComplexResult(StringBuilder a,StringBuilder b, StringBuilder finalResult, StringBuilder[] interResults)
	{
		int aLen = a.length(),interResultsLen = b.length(), resultLen = finalResult.length(), bLen = interResultsLen+1;//+1 for Operator
		if(bLen>2)	//2 Since Operator Length has been included
		{
		StringBuilder finalResultSpace = genChars(' ',bLen-finalResult.length());
		StringBuilder[] interResultSpaces = new StringBuilder[interResultsLen];
		interResultSpaces[interResultsLen-1] = genChars(' ', resultLen+finalResultSpace.length() - (interResults[interResultsLen-1].length()+interResultsLen-1));
		for(int i=interResultsLen-2;i>=0;--i)
		{
			interResultSpaces[i] = genChars(' ',(interResultSpaces[i+1].length()+interResults[i+1].length()+1) - interResults[i].length());
		}
		int hyphenOneLen = max(interResults[0].length(),bLen);
		StringBuilder hyphenOne = genChars('-',hyphenOneLen);
		StringBuilder hyphenOneSpace = genChars(' ',(interResults[0].length()+interResultSpaces[0].length())-hyphenOneLen);
		StringBuilder spaceForB = genChars(' ',(hyphenOneLen+hyphenOneSpace.length())-bLen);
		StringBuilder spaceForA = genChars(' ',(hyphenOneLen+hyphenOneSpace.length())-aLen);
		int hyphenTwoLen = finalResult.length();
		StringBuilder hyphenTwo = genChars('-', hyphenTwoLen);
		StringBuilder hyphenTwoSpace = finalResultSpace;
		
		//Printing Formatted Output
		out.print(spaceForA);out.println(a);
		out.print(spaceForB);out.print('*');out.println(b);
		out.print(hyphenOneSpace);out.println(hyphenOne);
		for(int i=0;i<interResultsLen;++i)
		{
			out.print(interResultSpaces[i]);
			out.println(interResults[i]);
		}
		out.print(hyphenTwoSpace);out.println(hyphenTwo);
		out.print(finalResultSpace);out.println(finalResult);
		
		}
		else
		{
			formatSimpleResult(a, b, '*', finalResult);
		}
	}
public static void main(String[] args) throws Exception
{
	in = new BufferedReader(new InputStreamReader(System.in));
	out = new PrintWriter(new OutputStreamWriter(System.out));
	int testcases = Integer.parseInt(in.readLine());
	
	for(int t=0;t<testcases;++t)
	{
		String fullString = in.readLine();
		int operatorPos = -1;
		char operator = 0;
		for(int i=0,j=fullString.length();i<j;++i)
		{
			char curChar = fullString.charAt(i);
			if(curChar<'0' || curChar>'9')
			{
				operatorPos = i;
				operator = curChar;
				break;
			}
		}
		StringBuilder a = new StringBuilder(fullString.substring(0,operatorPos));
		StringBuilder b = new StringBuilder(fullString.substring(operatorPos+1));
		
		switch(operator)
		{
		case '+':
			formatSimpleResult(a, b, operator, add(a, b));
			break;
		case '-':
			formatSimpleResult(a, b, operator, removeLeadingZeroes(sub(a,b)));
			break;
		case '*':
			mul(a, b);
			break;
			
			default : throw new Exception("Invalid Opearator");
		}
		out.println();
	}
	
	out.flush();
	out.close();
}
}
