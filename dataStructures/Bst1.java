import java.util.*;

class BinarySearchTree 
{
    /* Class containing left and right child of current node and key value*/
    class Node 
    {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

	Node root;

    BinarySearchTree() 
    { 
         root = null; 
    }

    void insert(int key) 
    { 
         root = insertRec(root, key); 
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key)
    {
        /* If the tree is empty, return a new node */
        if (root == null) 
        {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recurse down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    void inorder(Node root)
    {
        if (root != null) 
		{
            inorder(root.left);
			System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root)
    {
        if (root != null) 
		{
			System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root)
    {
        if (root != null) 
		{
            postorder(root.left);
            postorder(root.right);
			System.out.print(root.key + " ");
        }
    }

	void levelorder(Node root)
    {
        if(root == null)
            return;
         
        // Create a queue
		Queue<Node> q =new LinkedList<Node>();
         
        // Enqueue Root 
        q.add(root);         
         
		while(!q.isEmpty())
        {             
			Node node = q.remove();
			System.out.print(node.key + " ");
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
        }
    }

	void levelOrderInReverse(Node root)
    {
        if(root == null)
            return;
         
        // Create a Stack 
        Stack<Node> stk =new Stack<Node>();         
         
        // Create a queue 
        Queue<Node> q =new LinkedList<Node>();
		q.add(root);
         
		while(!q.isEmpty())
        {             
			Node node = q.remove();
			if(node.right != null)
				q.add(node.right);
			if(node.left != null)
				q.add(node.left);

			stk.push(node);
        }
		while(!stk.empty())
			System.out.print((stk.pop()).key + " ");   
    }

	Node search(Node root, int key)
	{
		// Base Cases: root is null or key is present at root
		if (root==null || root.key==key)
			return root;

		// Key is greater than root's key
		if (root.key < key)
		   return search(root.right, key);

		// Key is smaller than root's key
		return search(root.left, key);
	}

    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
            /    \
           30     70
          /  \   /  \
        20   40 60   80	*/

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder: ");
		tree.inorder(tree.root);
		System.out.println();

		System.out.print("Preorder: ");
		tree.preorder(tree.root);
		System.out.println();

		System.out.print("postorder: ");
		tree.postorder(tree.root);
		System.out.println();

		System.out.print("levelorder: ");
		tree.levelorder(tree.root);
		System.out.println();

		System.out.print("levelorder in Reverse order: ");
		tree.levelOrderInReverse(tree.root);
		System.out.println();

		int key = 20;

		Node searchNode = tree.search(tree.root, key);
		if(searchNode != null)
			System.out.println("Node found: " + searchNode.key);
		else
			System.out.println("Node not found: " + key);
    }
}