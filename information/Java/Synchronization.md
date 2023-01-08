Why synchronization is done? 
For Concurrency management. Synchronization Mechanism developed by using the synchronized keyword in java language. It is built on top of the locking mechanism, this locking mechanism is taken care of by Java Virtual Machine (JVM). The synchronized keyword is only applicable for methods and blocks, it can’t apply to classes and variables.

If we use the Synchronized keywords in any method then that method is Synchronized Method. 

-   It is used to lock an object for any shared resources. 
-   The object gets the lock when the synchronized method is called. 
-   The lock won’t be released until the thread completes its function.
-    Has significant overhead use mostly in case of multithreading scenarios.
-    Given an object instance always created on exactly one thread.

// A Class used to send a message 
class Sender 
{ 
  public void sendMessage(String message)
  { 
    System.out.println("\nSending "  + message);
    try
    { 
      Thread.sleep(1000); 
    } 
    catch (Exception e) 
    { 
      System.out.println("Thread interrupted."); 
    } 
    System.out.println("\n" +message+ "Sent");
  }
} 
// Class for sending a message using Threads 
class SendUsingThreads extends Thread 
{ 
  private String message; 
  Sender sender; 

  // Receives a message object and a string message to be sent 
  SendUsingThreads(String msg, Sender object)
  { 
    message = msg;
    sender = object; 
  } 

  public void run() 
  { 
    // This will ensure that only one thread sends a message at a time. 
    synchronized(sender) 
    { 
      // synchronizing the send object 
      sender.sendMessage(message);
    } 
  } 
} 
// Driver class 
public class Demo
{ 
  public static void main(String args[]) 
  { 
    Sender sender = new Sender(); 
    SendUsingThreads sender1 = new SendUsingThreads( "Hello " , sender);
     SendUsingThreads sender2 =  new SendUsingThreads( "Welcome to TechVidvan Tutorials ", sender);

 // Start two threads of SendUsingThreads type 
    sender1.start(); 
    sender2.start(); 

 // wait for threads to end 
    try
    { 
      sender1.join(); 
      sender2.join(); 
    } 
    catch(Exception e) 
    { 
      System.out.println("Interrupted"); 
    } 
  } 
}