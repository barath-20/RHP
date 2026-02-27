import java.util.*;
class Main{
    public static int mat[][];
    public static int R,C;
    public static void sink(int i, int j){
        if(!(0<=i && i<R && 0<=j && j<C)){
            return;
        }
        mat[i][j] = 0;
        sink(i+1,j);
        sink(i,j+1);
        sink(i-1,j);
        sink(i,j-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        mat = new int[R][C];
        int islandCount = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(mat[i][j]==1){
                    sink(i,j);
                    islandCount++;
                }
            }
        }
        System.out.println(islandCount);
        sc.close();
    }
}