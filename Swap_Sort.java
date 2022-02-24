/*Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.
Input:
nums = {2, 8, 5, 4}
Output:
1
Explaination:
swap 8 with 4.
*/
import java.util.*;
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int[] temp = new int[nums.length];
       Map<Integer, Integer> map = new HashMap();
       int count = 0;
       
       for(int i=0; i<nums.length; i++){
           map.put(nums[i], i);
       }
       
       temp = nums.clone();
       
       Arrays.sort(temp);
       
       for(int i=0; i<nums.length; i++){
           if(nums[i] == temp[i])
           continue;
           
           else{
               count++;
               // swap(arr[i],arr[map.get(temp[i])]);
               int tem = nums[i];
               nums[i] = nums[map.get(temp[i])];
               nums[map.get(temp[i])] = tem;
               
               map.put(tem, map.get(temp[i]));
               map.put(temp[i], i);
           }
       }
      return count;          
    }
}
