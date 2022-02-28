private static int LCS(String a,String b){
    int[][] dp = new int[a.length()+1][b.length()+1];
    for(int i=1;i<dp.length();i++){
        for(int j=1;j<dp[0].length();j++){
          if(a.charAt(i-1)==B.charAt(j-1)){
                dp[i][j] = 1+dp[i-1][j-1];
          }
          else{
            dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
          }
        }
     }
   return dp[a.length()][b.length()];
}
