import java.util.*;
class Pairs{
  public void Sum(int[] arr,int high,int low){
    while(low<high){
       if(arr[low]+arr[high]>sum){
         high--;
       }
      else if(arr[low]+arr[high]<sum){
        low++;
      }
      else if(arr[low]+arr[high]==sum){
        System.out.println("pair is"+arr[low]+""+arr[high]);
      }
    }
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[20];
    for(int i=0;i<10;i++){
      arr[i]=sc.nextInt();
    }
    int low = 0;
    int high = arr.length-1;
    Sum(arr,high,low);
  }
