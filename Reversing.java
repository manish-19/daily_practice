import java.util.*;
class Reverse{
  public int reverse(int n){
    int rev;
    while(n!=0){
     int rem = n%10;
     rev = rev*10+rem;
     n = n/10;
     }
     return n;
   }
  public static void main(String [] args){
  Scanner sc = new Scanner(System.in);
  long num = 542238;
  int n = sc.nextInt();
  System.out.println(Reverse(n));
  }
}
  
  
  
