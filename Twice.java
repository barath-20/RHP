import java.util.*;
class Main{
    public static void solve(Scanner sc){
        int n = sc.nextInt();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            freq.put(x,freq.getOrDefault(x, 0)+1);
        }
        int tot = 0;
        for(int x : freq.keySet()){
            tot += freq.get(x)/2;
        }
        System.out.println(tot);

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