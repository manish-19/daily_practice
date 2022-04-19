import java.util.*;
public class KthLargest{
    public static int findKlargest(List<Integer> ints, int k){
        if(ints==null || ints.size() < k){
            System.exit(-1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(ints.subList(0,k));
        for(int i=k;i<ints.size();i++){
           if(ints.get(i)>pq.peek())
           {
             pq.poll();
             pq.add(ints.get(i));
           }
        }
        return pq.peek();
     }
     public static void main(String[] args)
    {
        List<Integer> ints = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 3;
 
        System.out.println("k'th largest array element is " + findKlargest(ints, k));
    }
}
                                                  
                                                        
