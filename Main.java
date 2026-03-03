import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        
        int i = 0, j = 0;
        long total = 0;
        int n = s.length();
        int m = t.length();

        while (i < n || j < m) {
            int countS = 0;
            int countT = 0;

            // Count consecutive 'A's in S
            while (i < n && s.charAt(i) == 'A') {
                countS++;
                i++;
            }

            // Count consecutive 'A's in T
            while (j < m && t.charAt(j) == 'A') {
                countT++;
                j++;
            }

            // Add the difference in 'A' counts to total
            total += Math.abs(countS - countT);

            // If we haven't reached the end, the characters MUST match
            if (i < n && j < m) {
                if (s.charAt(i) != t.charAt(j)) {
                    System.out.println(-1);
                    return;
                }
                // Move past the matching non-'A' character
                i++;
                j++;
            } else if (i < n || j < m) {
                // One string has non-'A' characters left, the other doesn't
                System.out.println(-1);
                return;
            }
        }

        System.out.println(total);
    }
}