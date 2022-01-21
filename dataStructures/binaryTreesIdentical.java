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
	Node root;

	binaryTree() 
    { 
		root = null; 
    }

	// Inorder traversal of a binary tree
	void inorder(Node nd)
	{
		if (nd == null)
			return;

		inorder(nd.left);
		System.out.print(nd.key + " ");
		inorder(nd.right);
	}

	// Insert element in binary tree 
	void insert(Node nd, int key)
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

	static boolean areTreesStructurallyIdentical(Node n1, Node n2)
	{
		if(n1 == null && n2 == null)
			return true;
		if(n1 == null || n2 == null)
			return false;

		return(n1.key == n2.key && areTreesStructurallyIdentical(n1.left, n2.left) 
			&& areTreesStructurallyIdentical(n1.right, n2.right));
	}
	
	public static void main(String args[])
	{
		binaryTree tree1 = new binaryTree();
		tree1.insert(tree1.root, 10);
		tree1.insert(tree1.root, 11);
		tree1.insert(tree1.root, 7);
		tree1.insert(tree1.root, 9);
		tree1.insert(tree1.root, 15);
		tree1.insert(tree1.root, 8);
		tree1.insert(tree1.root, 12);

		binaryTree tree2 = new binaryTree();
		tree2.insert(tree2.root, 10);
		tree2.insert(tree2.root, 11);
		tree2.insert(tree2.root, 7);
		tree2.insert(tree2.root, 9);
		tree2.insert(tree2.root, 15);
		tree2.insert(tree2.root, 8);
		tree2.insert(tree2.root, 12);

		System.out.print(areTreesStructurallyIdentical(tree1.root, tree2.root));
	}
}
