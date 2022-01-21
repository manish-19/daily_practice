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
	Node temp = root;

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

	// What do you update to change it to 'count of full nodes'?
	int countOfLeafNodes(Node root)		
    {
        if(root == null)
            return 0;
         
        // Create a queue
		Queue<Node> q =new LinkedList<Node>();
		int count = 0;
         
        // Enqueue Root 
        q.add(root);         
         
		while(!q.isEmpty())
        {             
			Node node = q.remove();
			if(node.left == null && node.right == null)
				count++;
			else
			{
				if(node.left  != null)
					q.add(node.left);
				if(node.right  != null)
					q.add(node.right);
			}
        }
		return count;
    }
	
	public static void main(String args[])
	{
		binaryTree tree1 = new binaryTree();
		tree1.root = new Node(10);
		tree1.insert(tree1.root, 11);
		tree1.insert(tree1.root, 7);
		tree1.insert(tree1.root, 9);
		tree1.insert(tree1.root, 15);
		tree1.insert(tree1.root, 8);
		tree1.insert(tree1.root, 12);
		tree1.insert(tree1.root, 22);
		tree1.insert(tree1.root, 2);

		System.out.print(tree1.countOfLeafNodes(tree1.root));
	}
}
