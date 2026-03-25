import java.util.*;
class Main{
    public static long MOD = 1_000_000_007;
    public static long helper(int node, ArrayList<ArrayList<Integer>> adj,int[] colors, HashSet<Integer> vis){
        long max = 0;
        if(!vis.contains(colors[node])){
            max += 1;   
            vis.add(colors[node]);
        }
        for(int child: adj.get(node)){
            max = Math.max(max,helper(child, adj, colors, vis));
        }
        return max;
    }
    public static int solve(int[] parents, int[] colors, int n, int query[]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n+1);
        long sum = 0;
        for(int i=0;i<n;i++){
            adj.get(parents[i]).add(i+1);
        }
        HashMap<Integer,Long> map = new HashMap<>();
        for(int q: query){
            if(!map.containsKey(q)){
                HashSet<Integer> vis = new HashSet<>();
                map.put(q, helper(q,adj,colors,vis));
            }
            sum = (sum + map.get(q))%MOD;
        }
        return (int)sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] parents = new int[n];
        int[] colors = new int[n+1];
        for(int i=0;i<n;i++){
            parents[i] = sc.nextInt();
        }
        for(int i=1;i<=n;i++){
            colors[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[] queries = new int[q];
        for(int i=0;i<q;i++){
            queries[i] = sc.nextInt();
        }
        int res = solve(parents,colors,n,queries);
        System.out.println(res);
    }
}