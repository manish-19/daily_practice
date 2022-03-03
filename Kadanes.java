class Kadanes{
private static int MaxSubArray(int[] arr){
  int len  = arr.length;
  int max_so_far = Integer.MIN_VALUE;
  int max_ending_here = 0;
  for(int i=0;i<len;i++){
      max_ending_here = max_ending_here + arr[i];
      if(max_ending_here < arr[i]){
        max_ending_here = arr[i];
      }
      if(max_so_far < max_ending_here){
         max_so_far = max_ending_here;
      }
    return max_so_far;
  }
}
