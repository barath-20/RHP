import java.util.*;
class Main{
    public static void solve(Scanner sc){
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            B[i] = sc.nextInt();
        }
        int curr = 0;
        int stock = 0;
        for(int i=0;i<n;i++){
            stock += A[i];
            int need = B[i];
            while(need > 0){
                if(A[curr] <= need){
                    need -= A[curr];
                    stock -= A[curr];
                    A[curr] = 0;
                    curr += 1;
                }
                else{
                    A[curr] -= need;
                    stock -= need;
                    need = 0;
                }
            }
            while(curr < i && i - curr >= d){
                stock -= A[curr];
                A[curr] = 0;
                curr++;
            }
        }
        System.out.println(stock);

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