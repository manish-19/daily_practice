#include<stdio.h>
#include<string.h>
#include<stdlib.h>

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
  struct Node *ptr = hptr;
  while(ptr != NULL)
  {
    printf("%s->", ptr->name);
    ptr = ptr->next;
  }
  printf("\n");
}

// return 0 if there is no loop and 1 if there is a loop
int hasLoop()
{
  struct Node *fp = hptr;
  struct Node *sp = hptr;
  while(fp != NULL)
  {
    if(fp->next == NULL)
      fp = fp->next;
    else
      fp = fp->next->next;

    sp = sp->next;
    printf("fp = %s sp = %s \n", fp->name, sp->name);
    if(fp == sp)
    {
      printf("Has loop %s \n", fp->name);
      return 1;
    }  
  }
  return 0;
}

void main(int argc, char * argv[])
{
  int i = 1;
  // listhasloop 11  22  33  44  55  66  77  88  99  100
  for(; i < argc; i++)
    createList(argv[i]);

  display(); 
  
  // To test for has loop 
  tptr->next=hptr->next->next->next;
  printf("tptr->next %s \n", tptr->next->name);

  printf("has loop %d", hasLoop());
}