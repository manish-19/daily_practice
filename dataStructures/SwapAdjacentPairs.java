/* 
Given a singly linked list, write a function to swap elements pairwise.

Input : 1->2->3->4->5->6->7
Output : 2->1->4->3->6->5->7,

Input : 1->2->3->4->5->6 
Output : 2->1->4->3->6->5
*/

/* This program swaps the nodes of linked list rather than swapping the field
from the nodes. */

class SwapAdjacentPairs  
{   
  static class Node  
  {  
    int data;  
    Node next;  
  } 
  static Node head = null; 
  
  /* Function to pairwise swap elements of a linked list */
  static Node pairWiseSwap(Node head)  
  {     
    // If linked list is empty or there is only one node in list  
    if (head == null || head.next == null)  
        return head;  
  
    // Fix the head and its next 
    Node curr = head.next.next;  
    Node prev = head;  
    head = head.next;  
    head.next = prev;  
    
    // Fix remaining nodes  
    while (curr != null && curr.next != null)  
    {  
      prev.next = curr.next;  
      prev = curr;  
      Node next = curr.next.next;  
      curr.next.next = curr;  
      curr = next;  
    }       
    prev.next = curr;   
    return head;  
  }  
  
  /* Function to add a node at the beginning of Linked List */
  static void push(int new_data)  
  {  
    Node new_node = new Node();  
    new_node.data = new_data;  
    new_node.next = head;  
    head = new_node;  
  }  
  
  /* Function to print nodes in a given linked list */
  static void printList(Node node)  
  {  
    while (node != null)  
    {  
      System.out.print(node.data + " ");  
      node = node.next;  
    }  
  }  

  public static void main(String[] args)  
  {  
    /* The constructed linked list is:  
    1->2->3->4->5->6->7 */

    push(6);  
    push(5);  
    push(4);  
    push(3);  
    push(2);  
    push(1);  
  
    System.out.println("Linked list before calling pairWiseSwap()");  
    printList(head);  
  
    Node start = pairWiseSwap(head);  
  
    System.out.println("Linked list after calling pairWiseSwap()");  
    printList(start);  
  } 
} 
