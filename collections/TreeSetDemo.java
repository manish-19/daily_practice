import java.util.*;

class TreeSetDemo 
{
  public static void main(String args[]) 
  {    
    TreeSet ts = new TreeSet();
    String elements[] = {"Hyderabad", "Delhi", "Bombay", "Madras", "Agra",
      "Srinagar", "Bangalore", "Delhi"};

    for(int i = 0; i < elements.length; i++)
      ts.add(elements[i]);
        
    System.out.println(ts);
    System.out.println(ts.first());
    System.out.println(ts.last());
    ts.remove("Delhi");
    System.out.println(ts);
    System.out.println(ts.size());
    System.out.println(ts.isEmpty());
    ts.clear();
    System.out.println(ts.isEmpty());
  }
}