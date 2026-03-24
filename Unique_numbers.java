import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int diff = 0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            diff ^= arr[i];
        }
        int set = 1;
        while((diff&1)==0){
            diff >>= 1;
            set <<= 1;
        }
        int a = 0, b = 0;
        for(int x: arr){
            if((x&set)==set)  a ^= x;
            else    b ^= x;    
        }
        System.out.println(a+" "+b);

    }
}