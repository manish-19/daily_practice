import java.util.*;
public class Validparanthesis{
  public static boolean isValid(String str){
      Stack<Character> st = new Stack<>();
      for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
        if(ch=='('||ch=='['||ch=='{'){
          st.push(ch);
        }
        else{
          char p = st.peek();
          if(st.isEmpty()){return false;}
          else if(ch==')' && p!='(')    return false;
          else if(ch==']' && p!='[')    return false;
          else if(ch=='}' && p!='{')    return false;
          else st.pop();
        }
      }
      return st.isEmpty();
    }
   public static void main(String [] args){
      String str = "{}{}[]";
      System.out.println(isValid(str));
   }
}
