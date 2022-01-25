import java.util.*;

class treeSet2 
{
  public static void main(String args[]) 
  {    
    TreeSet<String> ts = new TreeSet<String>();
    String elements[] = {"Hyderabad", "Delhi", "Bombay", "Madras", "Agra",
      "Srinagar", "Bangalore", "Delhi"};

    for(int i = 0; i < elements.length; i++)
      ts.add(elements[i]);

    System.out.println("treeset lower:" + " " + ts.lower("Delhi")); 
    System.out.println("treeset floor:" + " " + ts.floor("Delhi")); 

    System.out.println("treeset higher:" + " " + ts.higher("Delhi")); 
    System.out.println("treeset ceiling:" + " " + ts.ceiling("Delhi")); 

    System.out.println("treeset pollFirst:" + " " + ts.pollFirst()); 
    System.out.println("treeset pollLast:" + " " + ts.pollLast()); 

    NavigableSet<String> dts = ts.descendingSet();
    System.out.println("descending treeset:" + " " + dts); 
  }
}

