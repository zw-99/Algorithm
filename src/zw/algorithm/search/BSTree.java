package zw.algorithm.search;

public class BSTree<T extends Comparable<T>> {
	private Node<T> root;
	
	public BSTree() {
		this.root = null;
	}
	
	public BSTree(Node<T> root) {
		this.root = root;
	}
	
	/**
	 * 前序遍历目标二叉树
	 * @param root
	 */
	public void preorder(Node<T> root) {
		if (root != null) {
			System.out.print(root.key +" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	/**
	 * 前序遍历当前二叉树
	 * 
	 */
	public void preorder() {
		preorder(this.root);
	}
	
	/**
	 * 中序遍历目标二叉树
	 * @param root
	 */
	public void inorder(Node<T> root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
	}
	
	/**
	 * 中序遍历当前二叉树
	 * 
	 */
	public void inorder() {
		inorder(this.root);
	}
	
	/**
	 * 后序遍历目标
	 * @param root
	 */
	public void postorder(Node<T> root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.key + " ");
		}
	}
	
	/**
	 * 后序遍历当前二叉树
	 * 
	 */
	public void postorder() {
		postorder(this.root);
	}
	
	/**
	 * (递归实现)查找目标二叉树中键值为key的结点
	 * @param current 当前结点
	 * @param key 要查找的目标元素
	 * @return
	 */
	public Node<T> search(Node<T> current, T key) {
		if (current == null) {	//二叉树中没有查找到值为key的结点
			return null;
		}
		int cmp = key.compareTo(current.key);
		if (cmp < 0) {	//key小于当前结点值，继续在左子树中查找
			return search(current.left, key);
		} else if (cmp > 0) {	//key大于当前结点值，继续在右子树中查找
			return search(current.right,key);
		} else {	//key等于当前结点值，返回当前结点
			return current;
		}
	}
	
	/**
	 * 查找当前二叉树中键值为key的结点
	 * @param key
	 * @return
	 */
	public Node<T> search(T key){
		return search(this.root, key);
	}
	
	/**
	 * 查找当前二叉树中的最大值
	 * @return
	 */
	public T maxValue() {
		Node<T> n = maxNode(root);
		if (n != null) {
			return n.key;
		}
		return null;
	}
	
	/**
	 * 查找当前二叉树中的最大值所在结点
	 * @param tree
	 * @return
	 */
	private Node<T> maxNode(Node<T> tree){
		if (tree == null) {
			return null;
		}
		while (tree.right != null) {
			tree = tree.right;
		}
		return tree;
	}
	
	/**
	 * 查找当前二叉树中的最小值
	 * @return
	 */
	public T minValue() {
		Node<T> n = minNode(root);
		if (n != null) {
			return n.key;
		}
		return null;
	}
	
	/**
	 * 查找当前二叉树中的最小值所在结点
	 * @param tree
	 * @return
	 */
	private Node<T> minNode(Node<T> tree){
		if (tree == null) {
			return null;
		}
		while (tree.left != null) {
			tree = tree.left;
		}
		return tree;
	}
	
	/**
	 * 新建一个结点值key，将其插入到二叉树中
	 * @param key
	 */
	public void insert(T key) {
		Node<T> newNode = new Node<T>(key, null, null, null);	//新建结点
		if (newNode != null) {
			insert(this, newNode);
		}
	}

	/**
	 * 将结点插入二叉树中
	 * @param bsTree 二叉树
	 * @param newNode 要插入的结点
	 */
	private void insert(BSTree<T> bsTree, Node<T> newNode) {
		// TODO Auto-generated method stub
		int cmp;
		Node<T> c = bsTree.root;	//当前结点
		Node<T> p = null;	//指向循环最后的结点
		while (c != null) {	//	找到newNode结点插入的位置
			p = c;
			cmp = newNode.key.compareTo(c.key);
			if (cmp < 0) {
				c = c.left;
			} else {
				c = c.right;
			}
		}
		newNode.parent = p;	//设置newNode结点的父结点
		if (p == null) {//如果P为null,则表明该二叉树为空，newNode应该被设置为根结点
			bsTree.root = newNode;
		} else {
			cmp = newNode.key.compareTo(p.key);
			if (cmp < 0) { //如果newNode结点值小于p结点值，则newNode结点为p结点的左子结点
				p.left = newNode;
			} else {//如果newNode结点值大于p结点值，则newNode结点为p结点的右子结点
				p.right = newNode;
			}
		}
	}
	
	/**
	 * 从二叉树中删除结点key
	 * @param key
	 */
	public void remove(T key) {
		Node<T> n, node;
		if ((n = search(key)) != null) {	// 获取要删除的结点
			if ((node = remove(this, n)) != null) {	// 删除目标结点,并重建结点间的关系
				node = null; // 将删除结点指向 null,真正完成结点的删除
			}
		}
	}

	/**
	 * 删除结点有三种情况  
	 * 1.删除结点没有左右子结点
	 * 2.删除结点有左子结点 或 右子结点
	 * 3.删除结点同时有左右子结点，通过寻找后继结点将当前情况转换为情况1，2
	 * 
	 * @param bsTree 二叉查找树
	 * @param n 要删除的结点
	 * @return 返回要删除的结点，将返回结点指向null便实现了删除结点
	 */
	private Node<T> remove(BSTree<T> bsTree, Node<T> n) {
		// TODO Auto-generated method stub
		Node<T> x = null;	// 缓存删除结点的子结点
		Node<T> y = null;	// 要删除的目标结点
		if (n.left == null || n.right == null) {	// 情况1，2
			y = n;
		} else {	// 情况3，需要找到删除结点的后继结点，将后继结点的值赋值给删除结点，再删除后继结点便间接实现了删除目标结点。
			y = successor(n);
		}
		if (y.left != null) {	// 保留删除结点的子结点
			x = y.left;
		} else {
			x = y.right;
		}
		if (x != null) {	// 更换删除结点的子结点的父结点为删除结点的父结点
			x.parent = y.parent;
		}
		if (y.parent == null) {	// 如果删除结点的父节点为空，则结点x为根节点
			bsTree.root = x;
		} else if (y == y.parent.left) {	// 如果被删除结点是左子结点,重新设置父节点的左子节点
			y.parent.left = x;
		} else {	// 如果被删除结点是右子结点,重新设置父节点的右子节点
			y.parent.right = x;
		}
		
		if (y != n) // 针对情况3，将后继结点的值赋值给删除结点，再删除后继结点便间接实现了删除目标结点
			n.key = y.key;
		return y;
	}

	/**
	 * 找结点(n)的后继结点。即，查找"二叉树中数据值大于该结点"的"最小结点"。
	 * @param n
	 * @return
	 */
	public Node<T> successor(Node<T> n) {
		// TODO Auto-generated method stub
		if (n.right != null) {	// 如果x存在右孩子，则"n的后继结点"为 "以其右孩子为根的子树的最小结点"。
			return minNode(n.right);
		}
		// 如果n没有右孩子。则x有以下两种可能：
	    // 1. n是"一个左孩子"，则"n的后继结点"为 "它的父结点"。
	    // 2. n是"一个右孩子"，则查找"n的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"n的后继结点"。
		Node<T> y = n.parent;
		while ((y != null) && (y.right == n)) {
			n = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * 找结点(n)的前驱结点。即，查找"二叉树中数据值小于该结点"的"最大结点"。
	 * @param n
	 * @return
	 */
	public Node<T> predecessor(Node<T> n) {
		// TODO Auto-generated method stub
		if (n.left != null) {	// 如果x存在右孩子，则"n的后继结点"为 "以其右孩子为根的子树的最小结点"。
			return minNode(n.left);
		}
		// 如果n没有右孩子。则x有以下两种可能：
	    // 1. n是"一个右孩子"，则"n的前驱结点"为 "它的父结点"。
	    // 2. n是"一个左孩子"，则查找"n的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"n的前驱结点"。
		Node<T> y = n.parent;
		while ((y != null) && (y.left == n)) {
			n = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * 销毁二叉树
	 * 
	 */
	public void clear() {
		destory(this.root);
		this.root = null;
	}

	private void destory(Node<T> node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		if (node.left != null) {
			destory(node.left);
		} else if (node.right != null) {
			destory(node.right);
		}
		node = null;	
	}
}
