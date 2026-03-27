import java.util.*;
class Main{
    public static int size(int n){   return (int)Math.pow(2,Math.ceil(Math.log(n)/Math.log(2)));}

    public static int rangeSum(int[] segmentTree, int left, int right, int node, int x, int y){
        
        int sum = 0, mid = left + (right - left)/2;

        if(left==x && right==y) return segmentTree[node];
        
        if(x<=mid) sum += rangeSum(segmentTree, left, mid, 2*node, x, Math.min(y,mid));
        
        if(y>mid)sum += rangeSum(segmentTree, mid + 1,right, 2*node + 1, Math.max(x,mid+1), y);
        
        return sum;
    }

    public static void update(int[] segmentTree, int idx, int val){
        if(idx<1)   return;
        segmentTree[idx] += val;
        update(segmentTree, idx/2, val);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = size(m);
        int[] segmentTree = new int[2*n];
        for(int i=n;i<n+m;i++)    segmentTree[i] = sc.nextInt();
        for(int i = n-1;i>0;i--)    segmentTree[i] = segmentTree[2*i] + segmentTree[2*i + 1];
        System.out.print("\nUpdate : ");
        int idx = sc.nextInt(), val = sc.nextInt();
        update(segmentTree, idx + n - 1, val);
        for(int i=n;i<n+m;i++) System.out.print(segmentTree[i]+" ");
        System.out.print("\nRange -> ");
        int l = sc.nextInt(), r = sc.nextInt(); 
        System.out.println(rangeSum(segmentTree, 1, n, 1, l, r));
        for(int x: segmentTree) System.out.print(x+" ");
        sc.close();
    }
}
