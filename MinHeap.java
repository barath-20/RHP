import java.util.*;
class Main{
    public static void main(){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        int n = sc.nextInt();
        while(n-->0){
            int x = sc.nextInt();
            minheap.add(x);
            maxheap.add(x);
        }
        while(!minheap.isEmpty()){
            System.out.print(minheap.poll()+" ");
        }
        System.out.println();
        while(!maxheap.isEmpty()){
            System.out.print(maxheap.poll()+" ");
        }

    }
}