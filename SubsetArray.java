import java.util.*;
class SubsetArray{
    static boolean isSubset(int arr1[],int arr2[],int m,int n)
    {
        HashSet<Integer> hset = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if (!hset.contains(arr1[i]))
                hset.add(arr1[i]);
        }
 
        // loop to check if all elements
        //  of arr2 also lies in arr1
        for (int i = 0; i < n; i++)
        {
            if (!hset.contains(arr2[i]))
                return false;
        }
        return true;
    }
             
   public static void main(String [] args){
     Scanner sc = new Scanner(System.in);
     int[] arr1 = new int[20];
     int[] arr2 = {11,3,7,1}; //give any array of your choice
     for(int i=0;i<n;i++){
       arr1[i]=sc.nextInt();
     }
     int m = arr1.length();
     int n = arr2.length();
     SubsetArray(arr11,arr2,m,n);
   }
}
