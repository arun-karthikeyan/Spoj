import java.io.*;import java.util.*;public class Main{public static void main(String[] args) throws Exception{PrintWriter pw=new PrintWriter(System.out);BufferedReader br = new BufferedReader(new InputStreamReader(System.in));int[] mods={ 1, 1, 4, 4, 2, 1, 1, 4, 4, 2 };int[][] lastDig = {{0},{1},{6,2,4,8},{1,3,9,7},{6,4},{5},{6},{1,7,9,3},{6,8,4,2},{1,9}};int testcases=Integer.parseInt(br.readLine());for(int t=0;t<testcases;++t){StringTokenizer st=new StringTokenizer(br.readLine());int a=Integer.parseInt(st.nextToken())%10,b=Integer.parseInt(st.nextToken());if(b==0){pw.println("1");}else{pw.println(lastDig[a][b%mods[a]]);}}pw.flush();pw.close();}}