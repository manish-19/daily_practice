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

	public static Node copyTree(Node root)
    {
        if (root == null)
        {
            return null;
        }
        Node newNode = new Node(root.key);
        newNode.left= copyTree(root.left);
        newNode.right= copyTree(root.right);
        return newNode;
    }

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
			nd = new Node(key);
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

	static Node mirror(Node mroot)
	{
		Node temp;
		if (mroot == null)		
			return null;		
		else {
			Node left = mirror(mroot.left);
			Node right = mirror(mroot.right);
			mroot.left = right;
			mroot.right = left;
		}
		return mroot;
	}	

	static Boolean areMirrors(Node original, Node mirror)
	{
		if(original == null && mirror == null)
			return true;
		if(original == null || mirror == null)
			return false;
		// System.out.println(original.key + " " + mirror.key);
		if(original.key != mirror.key)
			return false;
		else 
			return areMirrors(original.left, mirror.right) && areMirrors(original.right, mirror.left);

	}

	public static void main(String args[])
	{
		/* Let us create following BT
              50
           /     \
          70      40
         /  \    /  \
       80   35  45   10 
	  / \
	 5  15

	 5, 80, 70, 35, 50, 45, 40 10

	 10, 40, 45, 50, 35, 70, 80, 5
	   */

		Node root = new Node(50);
		insert(root, 70);
		insert(root, 40);
		insert(root, 80);
		insert(root, 35);
		insert(root, 45);
		insert(root, 10);
		insert(root, 5);
		insert(root, 15);

		System.out.print("Inorder traversal: ");
		inorder(root);
		System.out.println();

		Node croot = copyTree(root);
		System.out.print("Copy Inorder traversal: ");
		inorder(croot);
		System.out.println();

		Node mroot = mirror(croot);
		System.out.print("Mirror Inorder traversal: ");
		inorder(mroot);
		System.out.println();

		System.out.println(areMirrors(root, mroot));
	}
}
