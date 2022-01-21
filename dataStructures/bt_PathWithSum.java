import java.util.*;

class Node
{
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree
{
	static Node root;
	
	/*
     Given a tree and a sum, return true if there is a path
     from the root down to a leaf, such that adding up all
     the values along the path equals the given sum.
 
     Strategy: subtract the node value from the sum when
     recurring down, and check to see if the sum is 0 you reach the leaf node.
     */
 
    static boolean hasPathSum(Node node, int sum)
    {
      boolean ans = false;
	  if(node == null)
		  return false;

      int subSum = sum - node.data;
      if(subSum == 0 && node.left == null && node.right == null)
        return (ans = true);

      if(node.left != null)          
        // ans || hasPathSum... has no utility if the ans is false
        ans = ans || hasPathSum(node.left, subSum);       
      
      if(node.right != null)         
        // But if it is true then we can avoid calling hasPathSum
        // here as answer is found
        ans = ans || hasPathSum(node.right, subSum);   
      return(ans);
    }

	// Insert element in binary tree 
	static void insert(Node nd, int key)
	{
		if (nd == null) {
			root = new Node(key);
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(nd);

		// Do level order traversal until we find an empty place
		while (!q.isEmpty()) {
			nd = q.remove();

			if (nd.left == null) {
				nd.left = new Node(key);
				break;
			}
			else
				q.add(nd.left);

			if (nd.right == null) {
				nd.right = new Node(key);
				break;
			}
			else
				q.add(nd.right);
		}
	}

	public static void main(String args[])
	{
		/* Let us create following BT
              50
           /     \
          70      40
         /  \    /  \
       80   35  45   10 
	  / 
	 5 
	   */

		root = new Node(50);
		insert(root, 70);
		insert(root, 40);
		insert(root, 80);
		insert(root, 35);
		insert(root, 45);
		insert(root, 10);
		insert(root, 5);

		int sum = 90;
		
		if (hasPathSum(root, sum))
            System.out.println("There is a root to leaf path with sum: " + sum);
        else
            System.out.println("There is no root to leaf path with sum: " + sum);
	}
}

