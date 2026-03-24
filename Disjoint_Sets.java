import java.util.*;
class Main{
    public static int find(int[] ldr, int node){
        if(ldr[node]!=node) ldr[node] = find(ldr, ldr[node]);
        return ldr[node];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        int[] ldr = new int[v];
        for(int i=0;i<v;i++){
            ldr[i] = i;
        }
        for(int i=0;i<v;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            if(find(ldr,l)!= find(ldr,r)){
                
            }
        }
    }
}