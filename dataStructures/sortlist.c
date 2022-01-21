#include <stdio.h>
#include <string.h>

struct Node
{
	char name[20];
	struct Node *next;
};

struct Node *hptr=NULL,*tptr;
char data[20];

void createList(char *s)
{
    struct Node *nptr;    
    nptr=(struct Node *)malloc(sizeof(struct Node));    
    strcpy(nptr->name,s);
    
    if(hptr==NULL)
       hptr=nptr;
    else
       tptr->next=nptr;
    tptr=nptr;
    nptr->next=NULL;
}

void display()
{
  struct Node *t;
  for(t=hptr;t!=NULL;t=t->next)
    printf("%s\n",t->name);
}

void createSortedList(struct Node **sortPtr)
{
	if(*sortPtr == NULL)
	{
		*sortPtr=(struct Node *)malloc(sizeof(struct Node));  
		strcpy((*sortPtr)->name, data);
		(*sortPtr)->next = NULL;
	}
	else if(strcmp((*sortPtr)->name, data) > 0) 
	{
		struct Node *tempptr;
		tempptr=(struct Node *)malloc(sizeof(struct Node));  
		strcpy(tempptr->name,data);
		tempptr->next=*sortPtr;
		*sortPtr=tempptr;		
	}
	else 
		createSortedList(&(*sortPtr)->next);
}

void sort()
{	
	struct Node *t= hptr;
	struct Node *sptr=NULL;
	for(;t != NULL; t = t->next)
	{
		strcpy(data, t->name);
		createSortedList(&sptr);
	}
	hptr = sptr;
}

void main(int argc, char * argv[])
{
  int i=1;

  for(; i < argc; i++)
    createList(argv[i]);
  printf("Before sorting\n");
  display();
  sort();
  printf("\nAfter sorting\n");
  display();
}
    