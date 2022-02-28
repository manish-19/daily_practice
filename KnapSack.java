public static int KnapSack(int[] wt,int[] profit, int w,int n){
  if(n==0||w==0){
    return 0;
  }
  if(wt[n]>w){
    return KnapSack(wt,profitw,n-1);
  }
  else{
    return Math.max(KnapSack(wt,profit,W,n-1),profit[n]+KnapSack(wt,profit,w-wt[n],n-1));
  }
}
