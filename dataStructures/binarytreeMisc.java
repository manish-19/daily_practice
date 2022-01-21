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
	static Node temp = root;

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

    public static int maxElementInBTree(Node root) {
        if (null == root)
            return Integer.MIN_VALUE;
 
        int currentNodeValue = root.key;
        int left = maxElementInBTree(root.left);
        int right = maxElementInBTree(root.right);
        return Math.max(Math.max(left, right), currentNodeValue);
    }
 
    public static int minElementInBTree(Node root) {
        if (null == root)
            return Integer.MAX_VALUE;
 
        int currentNodeValue = root.key;
        int left = minElementInBTree(root.left);
        int right = minElementInBTree(root.right);
        return Math.min(Math.min(left, right), currentNodeValue);
    }	

	public static int sumOfElementsInBTree(Node root) {
        if (root == null)
            return 0;
		else
			return(root.key + sumOfElementsInBTree(root.left) + sumOfElementsInBTree(root.right));
    }

	public static void main(String args[])
	{
		root = new Node(10);
		insert(root, 11);
		insert(root, 7);
		insert(root, 9);
		insert(root, 15);
		insert(root, 8);
		insert(root, 12);

		System.out.print("Inorder traversal: ");
		inorder(root);
		System.out.println();

		System.out.print("Max element in Binary tree: ");
		System.out.println(maxElementInBTree(root));

		System.out.print("Min element in Binary tree: ");
		System.out.println(minElementInBTree(root));

		System.out.print("Sum of elements in Binary tree: ");
		System.out.println(sumOfElementsInBTree(root));
	}
}
