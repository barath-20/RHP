import java.util.*;
class Main{
    public static void solve(Scanner sc){
        String s = sc.nextLine();
        int n = s.length();
        HashMap<Integer,Integer> fom = new HashMap<>();
        fom.put(0,-1);
        int ctr = 0;
        int maxLen = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            ctr += (ch=='a')?1:-1;
            if(fom.containsKey(ctr)){
                maxLen = Math.max(maxLen, i - fom.get(ctr));
            }
            else{
                fom.put(ctr,i);
            }
        }
        System.out.println(maxLen);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        sc.nextLine();
        while(tc-->0){
            solve(sc);
        }
        sc.close();
    }
}