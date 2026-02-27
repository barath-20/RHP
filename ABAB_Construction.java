import java.util.*;
class Main{
    public static void solve(Scanner sc){
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        if(n%2==1 && s.charAt(0)=='b'){
            System.out.println("NO");
            return;
        }
        int i = n%2;
        for(;i<n;i+=2){
            if(s.charAt(i)==s.charAt(i+1) && s.charAt(i)!='?'){
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