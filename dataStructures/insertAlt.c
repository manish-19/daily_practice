#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#define MAX 3

struct Node
{
  char name[20];
  struct Node *next;
};

struct Node *hptr=NULL,*tptr;

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

void insertAlternative(char str[MAX][20])
{
  int count = 0;
  struct Node *t= hptr;

  for(; t!=NULL && count < MAX; )
  {
    struct Node *nptr;
    nptr=(struct Node *)malloc(sizeof(struct Node));
    strcpy(nptr->name,str[count]);
    nptr->next = t->next;
    t->next = nptr;
    t=t->next->next;
    count++;
  }
}

void main()
{
  int i;
  char str[MAX][20];
  createList("one");
  createList("two");
  createList("three");
  createList("four");

  printf("Enter data for 3 elements \n");
  for(i=0;i<MAX;i++)
  {
    scanf("%s",str[i]);
  }
  insertAlternative(str);
  printf("\n");
  display();
}

// a b c

// one -> a -> two -> b -> three -> c -> four