import java.util.*;
class Duplicates{
  public static void mainn(String [] args){
    int[] arr = {2,22,4,6,2,34,22,5,4};
    String[] names = { "Java", "JavaScript", "Python", "C", "Ruby", "Java" };
    Set<Integer> st = new HashSet<>();
    for(int i=0;i<arr.length;i++){
      if(st.add(i)==false){
         System.out.println(i);
      }
      Set<String> store = new HashSet<>(); 
      for (String name : names) { 
        if (store.add(name) == false) {
          System.out.println("found a duplicate element in array : " + name); 
        }
      }
    }
  }
