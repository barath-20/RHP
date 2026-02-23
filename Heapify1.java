import java.util.*;
class Main{
    public static void solve(Scanner sc){
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 1;i<=n;i+=2){
            List<Integer> lis = new ArrayList<>();
            for(int j = i;j<=n;j = j*2){
                lis.add(arr[j]);
            }
            Collections.sort(lis);
            int idx = 0;
            for(int j = i;j<=n;j=j*2){
                arr[j] = lis.get(idx++);
            }
        }
        for(int i=1;i<=n;i++){
            if(arr[i]!=i){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
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