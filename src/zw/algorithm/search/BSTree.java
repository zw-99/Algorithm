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
	 * ǰ�����Ŀ�������
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
	 * ǰ�������ǰ������
	 * 
	 */
	public void preorder() {
		preorder(this.root);
	}
	
	/**
	 * �������Ŀ�������
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
	 * ���������ǰ������
	 * 
	 */
	public void inorder() {
		inorder(this.root);
	}
	
	/**
	 * �������Ŀ��
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
	 * ���������ǰ������
	 * 
	 */
	public void postorder() {
		postorder(this.root);
	}
	
	/**
	 * (�ݹ�ʵ��)����Ŀ��������м�ֵΪkey�Ľ��
	 * @param current ��ǰ���
	 * @param key Ҫ���ҵ�Ŀ��Ԫ��
	 * @return
	 */
	public Node<T> search(Node<T> current, T key) {
		if (current == null) {	//��������û�в��ҵ�ֵΪkey�Ľ��
			return null;
		}
		int cmp = key.compareTo(current.key);
		if (cmp < 0) {	//keyС�ڵ�ǰ���ֵ���������������в���
			return search(current.left, key);
		} else if (cmp > 0) {	//key���ڵ�ǰ���ֵ���������������в���
			return search(current.right,key);
		} else {	//key���ڵ�ǰ���ֵ�����ص�ǰ���
			return current;
		}
	}
	
	/**
	 * ���ҵ�ǰ�������м�ֵΪkey�Ľ��
	 * @param key
	 * @return
	 */
	public Node<T> search(T key){
		return search(this.root, key);
	}
	
	/**
	 * ���ҵ�ǰ�������е����ֵ
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
	 * ���ҵ�ǰ�������е����ֵ���ڽ��
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
	 * ���ҵ�ǰ�������е���Сֵ
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
	 * ���ҵ�ǰ�������е���Сֵ���ڽ��
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
	 * �½�һ�����ֵkey��������뵽��������
	 * @param key
	 */
	public void insert(T key) {
		Node<T> newNode = new Node<T>(key, null, null, null);	//�½����
		if (newNode != null) {
			insert(this, newNode);
		}
	}

	/**
	 * ���������������
	 * @param bsTree ������
	 * @param newNode Ҫ����Ľ��
	 */
	private void insert(BSTree<T> bsTree, Node<T> newNode) {
		// TODO Auto-generated method stub
		int cmp;
		Node<T> c = bsTree.root;	//��ǰ���
		Node<T> p = null;	//ָ��ѭ�����Ľ��
		while (c != null) {	//	�ҵ�newNode�������λ��
			p = c;
			cmp = newNode.key.compareTo(c.key);
			if (cmp < 0) {
				c = c.left;
			} else {
				c = c.right;
			}
		}
		newNode.parent = p;	//����newNode���ĸ����
		if (p == null) {//���PΪnull,������ö�����Ϊ�գ�newNodeӦ�ñ�����Ϊ�����
			bsTree.root = newNode;
		} else {
			cmp = newNode.key.compareTo(p.key);
			if (cmp < 0) { //���newNode���ֵС��p���ֵ����newNode���Ϊp�������ӽ��
				p.left = newNode;
			} else {//���newNode���ֵ����p���ֵ����newNode���Ϊp�������ӽ��
				p.right = newNode;
			}
		}
	}
	
	/**
	 * �Ӷ�������ɾ�����key
	 * @param key
	 */
	public void remove(T key) {
		Node<T> n, node;
		if ((n = search(key)) != null) {
			if ((node = remove(this, n)) != null) {
				node = null;
			}
		}
	}

	private Node<T> remove(BSTree<T> bsTree, Node<T> n) {
		// TODO Auto-generated method stub
		Node<T> x = null;	//����Ҫɾ�������ӽ��
		Node<T> y = null;	//Ҫɾ����Ŀ����
		if (n.left == null || n.right == null) {
			y = n;
		} else {
			y = successor(n);
		}
		if (y.left != null) {
			x = y.left;
		} else {
			x = y.right;
		}
		if (x != null) {	//����ɾ�������ӽ��ĸ����Ϊɾ�����ĸ����
			x.parent = y.parent;
		}
		if (y.parent == null) {	// ���ɾ�����ĸ��ڵ�Ϊ�գ�����xΪ���ڵ�
			bsTree.root = x;
		} else if (y == y.parent.left) {	// �����ɾ����������ӽ��,�������ø��ڵ�����ӽڵ�
			y.parent.left = x;
		} else {	// �����ɾ����������ӽ��,�������ø��ڵ�����ӽڵ�
			y.parent.right = x;
		}
		
		if (y != n) 
			n.key = y.key;
		return y;
	}

	/**
	 * �ҽ��(n)�ĺ�̽�㡣��������"������������ֵ���ڸý��"��"��С���"��
	 * @param n
	 * @return
	 */
	public Node<T> successor(Node<T> n) {
		// TODO Auto-generated method stub
		if (n.right != null) {	// ���x�����Һ��ӣ���"n�ĺ�̽��"Ϊ "�����Һ���Ϊ������������С���"��
			return minNode(n.right);
		}
		// ���nû���Һ��ӡ���x���������ֿ��ܣ�
	    // (01) n��"һ������"����"n�ĺ�̽��"Ϊ "���ĸ����"��
	    // (02) n��"һ���Һ���"�������"n����͵ĸ���㣬���Ҹø����Ҫ��������"���ҵ������"��͵ĸ����"����"n�ĺ�̽��"��
		Node<T> y = n.parent;
		while ((y != null) && (y.right == n)) {
			n = y;
			y = y.parent;
		}
		return y;
	}
}