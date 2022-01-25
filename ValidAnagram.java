/*
AlphaCipher is a string formed from another by rearranging its letters

You are given two strings A and B,
Print true, if B is an AlphaCipher of A,
Otherwise false

Input Format:
-------------
Two space separated strings, A and B

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
dormitory dirtyroom

Sample Output-1:
----------------
true


Sample Input-2:
---------------
listen silent

Sample Output-2:
----------------
true


Sample Input-3:
---------------
car rat

Sample Output-3:
----------------
false

==== HINT ====
	- Since both A and B contain only letters from a-z, create a simple array counter[] of size 26.
	- increment the counter for each letter in A and decrement the counter for each letter in B, 
		- then check if the counter[i] reaches back to zero or not, where 0 <= i < 26
		- if any counter[i] is not equal to 0, return false.
	- return true.
*/
import java.util.*;
class ValidAnagram{
  public boolean IsAnagram(String s,String t){
    int [] alphabet = new alphabet[26];
    for(int i=0;i<s.length();i++) alphabet[s.charAt(i) - 'a']++;
    for(int i=0;i<t.length();i++) alphabet[t.charAt(i) - 'a']--;
    for(int i: alphabet) if(i!=0) return false;
    return true;
   }
   public static void main(String [] args){
     Scanner sc = new Scanner(System.in);
     String s = sc.nextInt();
     String t = sc.nextInt();
     System.out.println(new ValidAnagram().isAnagram(s,t));
     }
}
