import java.util.*;
class Main{
    static long MOD = 1_000_000_007;
    static class Track{
        public int ct = 0, sum = 0, lidx = 0;
        public Track(int idx){
            ct++;
            sum+=idx;
            this.lidx = idx;
        }
        public void set(int idx){
            this.sum += idx;
            this.lidx  = idx;
            this.ct++;
        }
    }
    public static void solve(char[] str, int n){
        int total = 0;
        HashMap<Character, Track> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(str[i])){  
                Track curr = map.get(str[i]);
                int ct = curr.ct, idx = curr.lidx, sum = curr.sum;
                if(i<curr.lidx+2 && ct>1){
                    ct-=1;
                    sum-=idx;
                }
                total += (ct*i - sum - ct)%MOD;
                curr.ct++;
                curr.sum+=i;
                curr.lidx = i;
                //System.out.println(i+" -> "+total);
            }
            else    map.put(str[i], new Track(i));
            //System.out.println(map.get(str[i]).ct+" "+map.get(str[i]).sum+" "+map.get(str[i]).lidx+" <- "+i);
        }
        System.out.println("MY method -> "+total);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] str = "aababa".toCharArray();
        int n = str.length;//sc.nextInt();
        int[] lt = new int[26];
        int[] rt = new int[26];
        for(char ch: str){
            rt[ch-'a']++;
        }
        int ct = 0;
        for(char ch:str){
            rt[ch-'a']--;
            for(int i=0;i<26;i++){
                ct += lt[i]*rt[i];
            }
            lt[ch-'a']++;
        }
        System.out.println("REal -> "+ct);
        solve(str,n);
    }
}