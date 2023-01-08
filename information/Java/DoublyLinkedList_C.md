struct node{
	int data;
	struct node *next;
	struct node *prev;
} struct node *head;

## Insertion:
1) Beginning:
  void insertFront(struct Node** head, int data){
     struct Node* newNode = newNode;
	 newNode -> data = data;
	 newNode->next = *head;
	 newNode->prev = NULL;
	 if(*head!=NULL){
	    *head->prev = newNode
	 }
	 *head = newNode;
  }
   
2) Specified Position:
   void inserAfter(struct Node* prev_node,int data){
       temp = head;
	   for(int i=0;i<pos-1;i++){
	     temp=temp->next;
	   }
	   newNode->data = data;
	   newNode->next = temp->next;
   }
   ------
   --
   -
   
   
  3) End:
     void InsertEnd(struct Node** head,int data){
	   struct *temp = *head;
	   newNode->data = data;
	  newNode->next=NULL;
	   while(temp->next!=NULL){
	    	temp = temp->next;
	   }
	   temp->next = newNode;
	   newNode->prev = temp;
	 }
  
## Deletion
1) Beginning:
void deleBegninning(struct node*  head, struct Node* del)
```
  if(*head == del_node){
     *head = del_node->next;
  }
  if(del_node->prev != NULL)
   del_node->prev->next = del_node->next;
 ```
   
  2) Specfied Position:
   void deleteNodeAtGivenPos(struct Node** head_ref,` `int` `n)
   { 
   struct` `Node* current = *head_ref;`
    int i;
   /* traverse up to the node at position 'n' from`
    the beginning */`
	for(int i = 1; current != NULL && i < n; i++)`
  		current = current->next;`
	/* if 'n' is greater than the number of nodes in the doubly linked list */`
	if(current == NULL)`
			return ;
   /* delete the node pointed to by 'current' */`
      deleteGivenPosNode(head_ref, current);`
	 }
	 
```
void deleteGivenPos(struct node*  head, struct Node* del)
if (del_node->next != NULL)
    del_node->next->prev = del_node->prev;

if (del_node->prev != NULL)
    del_node->prev->next = del_node->next;
```

3) At End:
void deleteEnd(struct Node* head, struct Node* del_node){
		if(del_node->prev != NULL)
		  del_node->prev->next = del_node->next;
}



static` `Node push(Node head_ref,` `char` `new_data)`
{`
Node new_node = newNode();`
    new_node.data = new_data;`
    new_node.next = head_ref;`
    new_node.prev = null;
    if(head_ref != null);
    head_ref.prev = new_node ;
    head_ref = new_node;
    return head_ref;

}
// Function to check if list is palindrome or not`

static  boolean  isPalindrome(Node left)`
{
if(left  == null)
    return  true;
    
 Find rightmost node`
    Node right = left;
   
   while(right.next !=null)
        right = right.next;
		
   while(left != right)
    {
        if(left.data != right.data)`
            return false;
			left = left.next;
			right = right.prev;`
    }
	
   return true;
   }