/*
Swap nodes in a linked list without swapping data
Given a linked list and two keys in it, swap nodes for two given keys. 
Nodes should be swapped by changing links. Swapping data of nodes may 
be expensive in many situations when data contains many fields.
It may be assumed that all keys in linked list are distinct.

Examples:

Input:  10->15->12->13->20->14,  x = 12, y = 20
Output: 10->15->20->13->12->14

Input:  10->15->12->13->20->14,  x = 10, y = 20
Output: 20->15->12->13->10->14

Input:  10->15->12->13->20->14,  x = 12, y = 13
Output: 10->15->13->12->20->14

This may look a simple problem, but is interesting question as it has
following cases to be handled.
1) x and y may or may not be adjacent.
2) Either x or y may be a head node.
3) Either x or y may be last node.
4) x and/or y may not be present in linked list.
*/

#include<stdio.h> 
#include<stdlib.h> 
  
/* A linked list node */
struct Node 
{ 
  int data; 
  struct Node *next; 
}; 
  
/* Function to swap nodes x and y in linked list by 
   changing links */
void swapNodes(struct Node **head_ref, int x, int y) 
{ 
 // Search for x (keep track of prevX and CurrX) 
 struct Node *prevX = NULL, *currX = *head_ref;   
 
 // Search for y (keep track of prevY and CurrY) 
 struct Node *prevY = NULL, *currY = *head_ref; 

 struct Node *temp;

 // Nothing to do if x and y are same 
 if (x == y) return; 

 while (currX && currX->data != x) 
 { 
   prevX = currX; 
   currX = currX->next; 
 } 

 while (currY && currY->data != y) 
 { 
   prevY = currY; 
   currY = currY->next; 
 } 

 // If either x or y is not present, nothing to do 
 if (currX == NULL || currY == NULL) 
   return; 

 // If x is not head of linked list 
 if (prevX != NULL) 
   prevX->next = currY; 
 else // Else make y as new head 
   *head_ref = currY;   

 // If y is not head of linked list 
 if (prevY != NULL) 
   prevY->next = currX; 
 else  // Else make x as new head 
   *head_ref = currX; 

 // Swap next pointers 
 temp = currY->next; 
 currY->next = currX->next; 
 currX->next  = temp; 
} 
  
/* Function to add a node at the begining of List */
void push(struct Node** head_ref, int new_data) 
{ 
  /* allocate node */
  struct Node* new_node = 
      (struct Node*) malloc(sizeof(struct Node)); 

  /* put in the data  */
  new_node->data  = new_data; 

  /* link the old list off the new node */
  new_node->next = *head_ref; 

  /* move the head to point to the new node */
  *head_ref    = new_node; 
} 
  
/* Function to print nodes in a given linked list */
void printList(struct Node *node) 
{ 
  while(node != NULL) 
  { 
    printf("%d ", node->data); 
    node = node->next; 
  } 
} 
  
int main() 
{ 
  struct Node *start = NULL; 

  /* The constructed linked list is: 
   1->2->3->4->5->6->7 */
  push(&start, 7); 
  push(&start, 6); 
  push(&start, 5); 
  push(&start, 4); 
  push(&start, 3); 
  push(&start, 2); 
  push(&start, 1); 

  printf("Linked list before calling swapNodes()\n"); 
  printList(start); 

  swapNodes(&start, 7, 1); 

  printf("\nLinked list after calling swapNodes()\n"); 
  printList(start); 

  return 0; 
} 
