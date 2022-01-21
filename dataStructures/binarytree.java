import java.util.*;

class binaryTree 
{
	static class Node {
		int key;
		Node left, right;

		Node(int key)
		{
			this.key = key;
			left = null;
			right = null;
		}
	}
	static Node root;

	// Inorder traversal of a binary tree
	static void inorder(Node nd)
	{
		if (nd == null)
			return;

		inorder(nd.left);
		System.out.print(nd.key + " ");
		inorder(nd.right);
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
		root = new Node(10);
		insert(root, 11);
		insert(root, 7);
		insert(root, 9);
		insert(root, 15);
		insert(root, 8);

		System.out.print("Inorder traversal:");
		inorder(root);
		System.out.println();
		insert(root, 12);

		System.out.println("Inorder traversal after insertion:");
		inorder(root);
		System.out.println();
	}
}
