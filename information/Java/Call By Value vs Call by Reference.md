## Java Parameter Passing

In general, there are the following two ways that a computer language can pass an argument to a subroutine :

1.  **call-by-value** - The call-by-value approach copies the value of an argument into the formal parameter of the subroutine. Therefore, changes made to parameter of the function or subroutine have no effect on the argument.
2.  **call-by-reference** - In call-by-reference approach, a reference to an argument (not the value of the argument) is passed to the parameter. Inside the subroutine, this reference is used to access the actual argument determined in the call. This means that changes made to the parameter will affect the argument used to call the subroutine.


## java call by value example:
  
class Test
{
    void meth(int i, int j)
    {
        i = i * 2;
        j = j / 2;
        System.out.println("\nThe value of a and b in method after performing action :");
        System.out.println("a = " + i + "\t b = " + j);
    }
}

public class JavaProgram
{   
    public static void main(String args[])
    {
         Test obj = new Test();
       	  int a = 150, b = 200
        System.out.println("The value of a and b before call :");
        System.out.println("a = " + a + "\t b = " + b);
        obj.meth(a, b);
        System.out.println("\nThe value of a and b after call : ");
        System.out.println("a = " + a + "\t b = " + b);
    }
}

## Java Call by reference example:
class Test
{
    int a, b;    
    Test(int i, int j)
    {
        a = i;
        b = j;
    }
    /* pass an object */
    void meth(Test o)
    {
        o.a = o.a * 2;
        o.b = o.b / 2;
    }
}

public class JavaProgram
{   
    public static void main(String args[])
    {   
        Test obj = new Test(150, 200);   
        int a = 150, b = 200;
        System.out.println("The value of obj.a and obj.b before call :");
        System.out.println("obj.a = " + obj.a + "\t obj.b = " + obj.b);
        obj.meth(obj);
        System.out.println("\nThe value of obj.a and obj.b after call : ");
        System.out.println("obj.a = " + obj.a + "\t obj.b = " + obj.b);
    }
}
