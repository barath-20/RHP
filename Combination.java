import java.util.*;
class Main{
    public static void solve(Scanner sc){
        String s = sc.nextLine();
        int n = s.length();
        for(int i=1;i<(1<<n);i++){
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
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