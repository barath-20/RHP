import java.util.*;
public class Erothesis{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-->0){
            int n = sc.nextInt();
            boolean found = false;
            for(int i=0;i<n;i++){
                int x = sc.nextInt();
                if(x==67){
                    found = true;
                    break;
                }
            }
            if(found){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }

        sc.close();
    }
}