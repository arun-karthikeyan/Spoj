import static java.lang.Integer.*;
import java.io.*;
import java.util.*;
public class Main {
        public static void main(String[] args) throws Throwable{
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
                int arr[] = new int[parseInt(in.readLine().trim())];
                for (int i = 0; i < arr.length; i++) 
                        arr[i] = parseInt(in.readLine().trim());
                int[] f = new int[arr.length*arr.length*arr.length]; int cont=0;
                for (int a = 0; a < arr.length; a++) 
                        for (int b = 0; b < arr.length; b++)
                                for (int c = 0; c < arr.length; c++)
                                        f[cont++]=arr[a]*arr[b]+arr[c];
                Arrays.sort(f, 0, cont);
                int[][] ff = new int[2][cont]; int cont1 = 0;
                for(int i = 0, ant = -MAX_VALUE; i < cont; ant=f[i],i++)
                        if(ant!=f[i]){ff[0][cont1++]=f[i];ff[1][cont1-1]++;}
                        else ff[1][cont1-1]++;
                ff[0][cont1++]=f[f.length-1];ff[1][cont1-1]++;
                long res = 0;
                for (int d = 0; d < arr.length; d++)
                        if(arr[d]!=0)
                                for (int i = 0; i < arr.length; i++) 
                                        for (int j = 0; j < arr.length; j++)
                                                res+=cantidad(ff, arr[d]*(arr[i]+arr[j]), cont1);
                System.out.println(res);
        }
        static int cantidad(int[][] f, int num, int max_n){
                int bs = Arrays.binarySearch(f[0], 0, max_n, num);
                if(bs>=0&&bs<max_n)return f[1][bs];
                return 0;
        }
}