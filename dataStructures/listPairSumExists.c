 /*
Linked List Pair Sum
Given a linked list, and a number, check if their exist two numbers whose 
sum is equal to given number. If there exist two numbers, print them. 
If there are multiple answer, print any of them.

Examples:

Input : 1 -> 2 -> 3 -> 4 -> 5 -> NULL 
        sum = 3
Output : Pair is (1, 2)

Input : 10 -> 12 -> 31 -> 42 -> 53 -> NULL 
        sum = 15
Output : NO PAIR EXIST
*/

#include <stdio.h>

struct Node { 
	int data; 
	struct Node* next; 
}; 

/* Given a reference (pointer to pointer) to the head of a list and an int, 
	push a new node to the front of the list. */
void push(struct Node** head_ref, int new_data) 
{ 
	struct Node* new_node = (struct Node*)malloc(sizeof(struct Node)); 
	new_node->data = new_data;

	/* link the old list off the new node */
	new_node->next = *head_ref; 
	/* move the head to point to the new node */
	*head_ref = new_node; 
} 

void display(struct Node* hptr)
{
  struct Node *t;
  for(t=hptr;t!=NULL;t=t->next)
    printf("%d ",t->data);

  printf("\n");
}

/* Takes head pointer of the linked list and sum*/
int check_pair_sum(struct Node* head, int sum) 
{ 
	struct Node* p = head, *q; 
	while (p != NULL) {	
		q = p->next; 
		while (q != NULL) {
			// check if both sum is equal to given sum 
			if ((p->data) + (q->data) == sum) { 
				printf("Sum = %d pair = %d  %d", sum, p->data, q->data); 
				return 1; 
			}	 
			q = q->next;		 
		} 
		p = p->next; 
	} 
	return 0; 
} 

int main() 
{ 
	/* Start with the empty list */
	struct Node* head = NULL; 
	int res, sum;

	/* Use push() to construct linked list*/
	push(&head, 1); 
	push(&head, 4); 
	push(&head, 1); 
	push(&head, 12); 
	push(&head, 1); 
	push(&head, 18); 
	push(&head, 47); 
	push(&head, 16); 
	push(&head, 12); 
	push(&head, 14); 

	display(head);

	sum = 30;
	/* function to print the result */
	res = check_pair_sum(head, sum); 
	if (res == 0) 
		printf("NO PAIR EXIST"); 

	return 0; 
} 
