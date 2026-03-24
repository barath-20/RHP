import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        long res = 0;
        long MOD = 1_000_000_007L;
        for(int i=0;i<n;i++)    maxH.add(sc.nextInt());
        for(int i=0;i<n;i++)    minH.add(sc.nextInt());
        for(int i=0;i<n;i++){
            int ones = maxH.poll();
            while(ones-->0)     res = (res<<1 | 1)%MOD;
            int zeros = minH.poll();
            res = (res<<zeros)%MOD; 
        }
        System.out.println(res);
        
        sc.close();
    }
}