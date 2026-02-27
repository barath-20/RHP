import java.util.*;
class Main{
    public static void solve(Scanner sc){
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        HashMap<Integer,Integer> dp = new HashMap<>();
        for(int x: arr){
            int prev = dp.getOrDefault(x-1,0)+1;
            int curr = dp.getOrDefault(x,0);
            dp.put(x,Math.max(prev,curr));
        }
        int res = 1;
        for(int x : dp.keySet()){
            res = Math.max(dp.get(x),res);
        }
        System.out.println(res);
        

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(tc-->0){
            solve(sc);
        }
        sc.close();
    }
}