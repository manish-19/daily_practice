import java.util.*;
class MaxProductSubArray{
  public int maxProduct(int[] arr,int n){
    int max = arr[0];
    int min = arr[0];
    int res = arr[0];
    int temp1,temp2;
    for(int i=0;i<n;i++){
      if(arr[i]==0){
        max=1;
        min=1;
      }
      temp1 = arr[i]*max;
      temp2 = arr[i]*min;
      max = Math.max(temp1,max);
      max = Math.max(max,arr[i]);
      min = Math.min(temp2,min);
      min = Math.min(min,arr[i]);
      res = Math.max(res,max);
    }
    return res;
  }
  public static void main(String [] args){ 
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
      arr[i] = sc.nextInt();
    }
    System.out.println(maxProduct(arr,n));
  }
}
  
