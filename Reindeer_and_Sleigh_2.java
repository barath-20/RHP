import java.util.*;
class Main{
    public static void solve(Scanner sc){
        int n = sc.nextInt();
        long [][] arr = new long[n][3];
        long  remwt=0, pull=0;
        for(int i=0;i<n;i++){
            arr[i][1] = sc.nextLong();
            arr[i][2] = sc.nextLong();
            arr[i][0] = arr[i][1]+arr[i][2];
            remwt += arr[i][1];
        }
        Arrays.sort(arr, (a,b)-> Long.compare(a[0], b[0]));
        int i = n-1;
        while (i >= 0 && pull < remwt) {
            remwt -= arr[i][1];
            pull += arr[i][2];
            i--;
        }
        System.out.println(i+1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-->0){
            solve(sc);
        }
        sc.close();
    }
}