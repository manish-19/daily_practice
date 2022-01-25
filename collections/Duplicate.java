import java.util.*;
class Duplicate{
    public void remove(int [] arr){
        Arrays.sort(arr);
        int len = arr.length;
        int j=0;
        for(int i=0;i<len-1;i++){
                if(arr[i]!=arr[i+1]){
                    arr[j++] = arr[i];
                }
        }
        arr[j++] = arr[len-1];
        for(int k=0;k<j;k++){
            System.out.println(arr[k]);
        }
    }
    public static void main(String [] args){
        int[] arr = {1,5,6,4,5,3,6};
        Duplicate obj = new Duplicate();
        obj.remove(arr);
    }
}