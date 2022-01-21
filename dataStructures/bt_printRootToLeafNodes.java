// Print all the nodes from root to leaf

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
	
	// Given a binary tree, print out all of its root-to-leaf paths, one per line. 

	static void printPaths(Node node)
	{
		int path[] = new int[1000];
		printPathsRecursive(node, path, 0);
	}

	/* Given a node, and an array containing the path from the root node up to 
	but not including this node, print out all the root-leaf paths */

	static void printPathsRecursive(Node node, int path[], int pathLen)
	{
		if (node == null)
			return;

		/* append this node to the path array */
		path[pathLen] = node.data;
		pathLen++;

		/* it's a leaf, print the path */
		if (node.left == null && node.right == null)
			printArray(path, pathLen);
		else
		{
			/* otherwise try both subtrees */
			printPathsRecursive(node.left, path, pathLen);
			printPathsRecursive(node.right, path, pathLen);
		}
	}

	/* Utility function that prints out an array on a line. */
	static void printArray(int ints[], int len)
	{
		int i;
		for (i = 0; i < len; i++)
		{
			System.out.print(ints[i] + " ");
		}
		System.out.println("");
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
		
		/* Inorder traversal */
		printPaths(root);
	}
}

