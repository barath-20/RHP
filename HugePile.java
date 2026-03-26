import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void solve(Scanner sc){
        long n = sc.nextLong();
        long k = sc.nextLong();
        
        if(k==1){
            System.out.println((long)(Math.log(n)/Math.log(2)));
            return;
        }

        double exactM = Math.log((double)n/k) / Math.log(2);
 
        long m1 = (long)Math.floor(exactM);
        long m2 = (long)Math.ceil(exactM);
        

        long p1 = (long)(k * Math.pow(2,m1));
        long sub1 = (long)Math.pow(2,m1) - 1;
        if((p1-sub1) <= n && n <= (p1+sub1)){
            System.out.println(m1);
            return;
        }

        long p2 = (long)(k * Math.pow(2,m2));
        long sub2 = (long)Math.pow(2,m2) - 1;
        if((p2-sub2) <= n && n <= (p2+sub2)){
            System.out.println(m2);
            return;
        }

        System.out.println(-1);
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-->0){
            solve(sc);
        }
    }
}