import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ct = 0;
        int max = -1;
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(max<=x)  ct++;
            max = Math.max(max,x);
        }
        System.out.println(ct);
    }
}