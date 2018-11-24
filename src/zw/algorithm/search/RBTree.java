package zw.algorithm.search;


//���������
//(1) ÿ���ڵ�����Ǻ�ɫ�������Ǻ�ɫ��
//(2) ���ڵ��Ǻ�ɫ��
//(3) ÿ��Ҷ�ӽڵ��Ǻ�ɫ�� [ע�⣺����Ҷ�ӽڵ㣬��ָΪ�յ�Ҷ�ӽڵ㣡]
//(4) ���һ���ڵ��Ǻ�ɫ�ģ��������ӽڵ�����Ǻ�ɫ�ġ�
//(5) ��һ���ڵ㵽�ýڵ������ڵ������·���ϰ�����ͬ��Ŀ�ĺڽڵ㡣


/**
 * �����
 * @author 13479
 *
 */
public class RBTree<T extends Comparable<T>> {
	private RBTNode<T> root;	// ���ڵ�
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	/**
	 * ������ڵ�
	 * @author 13479
	 *
	 * @param <T>
	 */
	public class RBTNode<T extends Comparable<T>>{
		T key;	// ��ֵ
		boolean color;	// ��ɫ
		RBTNode<T> parent;	// ���ڵ�
		RBTNode<T> left;	// ���ӽڵ�
		RBTNode<T> right;	// ���ӽڵ�
		
		public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
			this.key = key;
			this.color = color;
			this.left = left;
			this.right = right;
		}
		public T getKey() {
			return this.key;
		}
	}
	
	public RBTree() {
		// TODO Auto-generated constructor stub
	}
	
	private boolean isRed(RBTNode<T> n) {
		return ((n != null) && (n.color == RED)) ? true : false;
	}
	
	private boolean isBlack(RBTNode<T> n) {
		return ((n != null) && (n.color == BLACK)) ? true : false;
	}
	
	/**
	 * ��ȡ�ڵ����ɫ���սڵ���ɫΪ��ɫ
	 * @param n
	 * @return
	 */
	private boolean getColor(RBTNode<T> n) {
		return n != null ? n.color : BLACK;
	}
	
	private RBTNode<T> getParent(RBTNode<T> n) {
		return n != null ? n.parent : null;
	}
	
	private void setRed(RBTNode<T> n) {
		if (n != null) {
			n.color = RED;
		}
	}
	
	private void setBlack(RBTNode<T> n) {
		if (n != null) {
		n.color = BLACK;
		}
	}
	
	private void setParent(RBTNode<T> n, RBTNode<T> pNode) {
		if (n != null) {
			n.parent = pNode;
		}
	}
	
	private void setColor(RBTNode<T> n, boolean color) {
		if (n != null) {
			n.color = color;
		}
	}
	
	/**
	 * ǰ�����
	 * 
	 */
	public void preorder() {
		preorder(this.root);
	}
	
	private void preorder(RBTree<T>.RBTNode<T> n) {
		// TODO Auto-generated method stub
		if (n != null) {
			System.out.print(n.key + " ");
			preorder(n.left);
			preorder(n.right);
		}
	}
	
	/**
	 * 
	 * �������
	 */
	public void inorder() {
		inorder(this.root);
	}

	private void inorder(RBTree<T>.RBTNode<T> n) {
		// TODO Auto-generated method stub
		if (n != null) {
			inorder(n.left);
			System.out.print(n.key + " ");
			inorder(n.right);
		}
	}

	public void postorder() {
		postorder(this.root);
	}
	
	private void postorder(RBTree<T>.RBTNode<T> n) {
		// TODO Auto-generated method stub
		if (n != null) {
			postorder(n.left);
			postorder(n.right);
			System.out.print(n.key + " ");
		}
	}

	/**
	 * �ڵ�����
	 * 1. ����ǰ�ڵ������ӽڵ�����ӵĹ�ϵ
	 * 2. ����ǰ�ڵ��ҽڵ��뵱ǰ�ڵ㸸�ڵ�Ĺ�ϵ
	 * 3. ����ǰ�ڵ������ӽڵ�Ĺ�ϵ
	 * @param n
	 */
	private void leftRotate(RBTNode<T> n) {
		RBTNode<T> x = n.right;	// ����xΪn���Һ���
		// 1. ����ǰ�ڵ������ӽڵ�����ӵĹ�ϵ
		n.right = x.left;	// ����n���Һ���Ϊx������
		if (x.left != null) {	// ���x�����Ӳ�Ϊ�գ���x���ӵĸ��ڵ�Ϊn
			x.left.parent = n;
		}
		// 2. ����ǰ�ڵ��ҽڵ��뵱ǰ�ڵ㸸�ڵ�Ĺ�ϵ
		x.parent = n.parent;	// ��x�ĸ��ڵ�����Ϊn�ĸ��ڵ�
		if (n.parent == null) {	// ���n�ĸ��ڵ�Ϊ�գ���x�ڵ�Ϊ���ڵ�
			this.root = x;
		} else {	// n�ĸ��ڵ㲻Ϊ��
			if (n.parent.left == n) {	// ���n�Ǹ��ڵ�����ӽڵ㣬��ôxΪ���ӽڵ�
				n.parent.left = x;
			} else {	// ���n�Ǹ��ڵ�����ӽڵ㣬��ôxΪ���ӽڵ�
				n.parent.right = x;
			}
		}
		// 3. ����ǰ�ڵ������ӽڵ�Ĺ�ϵ
		x.left = n;		// ��x�����ӽڵ���Ϊn
		n.parent = x;	// ��n�ĸ��ڵ���Ϊx
	}
	
	/**
	 * �ڵ�����
	 * 1. ����ǰ�ڵ������ӽڵ���Һ��ӵĹ�ϵ
	 * 2. ����ǰ�ڵ���ڵ��뵱ǰ�ڵ㸸�ڵ�Ĺ�ϵ
	 * 3. ����ǰ�ڵ������ӽڵ�Ĺ�ϵ
	 * @param n
	 */
	private void rightRotate(RBTNode<T> n) {
		RBTNode<T> x = n.left;	// ����xΪn������
		// 1. ����ǰ�ڵ������ӽڵ���Һ��ӵĹ�ϵ
		n.left = x.right;	// ����n������Ϊx���Һ���
		if (x.right != null) {	// ���x���ҽڵ㲻Ϊ�գ���x�Һ��ӵĸ��ڵ�Ϊn
			x.right.parent = n;
		}
		// 2. ����ǰ�ڵ���ڵ��뵱ǰ�ڵ㸸�ڵ�Ĺ�ϵ
		x.parent = n.parent;	// ��x�ĸ��ڵ�����Ϊn�ĸ��ڵ�
		if (n.parent == null) {	// ���n�ĸ��ڵ�Ϊ�գ���x�ڵ�Ϊ���ڵ�
			this.root = x;
		} else {	// ���n�ĸ��ڵ㲻Ϊ��
			if (n.parent.left == n) {	// ���n�Ǹ��ڵ�����ӽڵ㣬��ôxΪ���ӽڵ�
				n.parent.left = x;
			} else {	// ���n�Ǹ��ڵ�����ӽڵ㣬��ôxΪ���ӽڵ�
				n.parent.right = x;
			}
		}
		// 3. ����ǰ�ڵ������ӽڵ�Ĺ�ϵ
		x.right = n;	// ��x�����ӽڵ���Ϊn
		n.parent = x;	// ��n�ĸ��ڵ���Ϊx
	}
	
	/**
	 * �ҵ�ָ���ڵ㿪ʼ����С�ڵ�
	 * @param n ��ʼ�ڵ�
	 * @return
	 */
	private RBTree<T>.RBTNode<T> minNode(RBTree<T>.RBTNode<T> n) {
		if (n == null) {
			return null;
		}
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	/**
	 * �����µļ�ֵ
	 * @param key ��ֵ
	 */
	public void insert(T key) {
		RBTNode<T> node = new RBTNode<T>(key, BLACK, null, null, null);	//�½��ڵ㣬���ʧ���򷵻�
		if (node != null) {
			insert(node);
		}
	}

	/**
	 * �ں�����в����½ڵ�
	 * 
	 * �� ���˵����������Ľڵ��Ǹ��ڵ㡣���ƻ���ƽ�⣩
	 *  ��������ֱ�ӰѴ˽ڵ�ͿΪ��ɫ��
	 * �� ���˵����������Ľڵ�ĸ��ڵ��Ǻ�ɫ����δ�ƻ�ƽ�⣩
	 * ��������ʲôҲ����Ҫ�����ڵ㱻�������Ȼ�Ǻ������
	 * �� ���˵����������Ľڵ�ĸ��ڵ��Ǻ�ɫ�����ƻ���ƽ�⣩
	 * ����������ô��������������ġ�����(5)�����ͻ����������£�������ڵ���һ�����ڷǿ��游�ڵ�ģ���һ���Ľ���������ڵ�Ҳһ����������ڵ�(��ʹ����ڵ�Ϊ�գ�
	 * Ҳ��֮Ϊ���ڣ��սڵ㱾����Ǻ�ɫ�ڵ�)������"����ڵ�����"�������������һ������Ϊ3�����(Case)��
	 * case1: ��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ���游�ڵ����һ���ӽڵ㣨����ڵ㣩Ҳ�Ǻ�ɫ��
	 * case2:��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ������ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ����丸�ڵ���Һ���
	 * case3:��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ������ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ����丸�ڵ������
	 * @param n
	 */
	private void insert(RBTree<T>.RBTNode<T> n) {
		// 1.�������������������������ڵ���뵽�����������
		int cmp;
		RBTNode<T> x = this.root;
		RBTNode<T> y = null;
		while (x != null) {
			y = x;
			cmp = n.key.compareTo(x.key);
			if (cmp < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		n.parent = y;
		if (y == null) {
			this.root = n;
		} else {
			cmp = n.key.compareTo(y.key);
			if (cmp < 0) {
				y.left = n;
			} else {
				y.right = n;
			}
		}
		// 2.���ڵ���ɫ����Ϊ��ɫ
		n.color = RED;
		// 3. �����޸�Ϊ�������
		insertFix(n);
	}

	/**
	 * �����������������
	 * �ں����ʧȥƽ��ʱ��ʹ�ôη���
	 * 
	 * 
	 *  case1: ��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ���游�ڵ����һ���ӽڵ㣨����ڵ㣩Ҳ�Ǻ�ɫ��
	 *  ��������
	 * (01) �������ڵ㡱��Ϊ��ɫ��
	 * (02) ��������ڵ㡱��Ϊ��ɫ��
	 * (03) �����游�ڵ㡱��Ϊ����ɫ����
	 * (04) �����游�ڵ㡱��Ϊ����ǰ�ڵ㡱(��ɫ�ڵ�)������֮������ԡ���ǰ�ڵ㡱���в�����
	 * 
	 * case2:��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ������ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ����丸�ڵ���Һ���
	 * ������	:
	 * (01) �������ڵ㡱��Ϊ���µĵ�ǰ�ڵ㡱��
	 * (02) �ԡ��µĵ�ǰ�ڵ㡱Ϊ֧�����������
	 * 
	 * case3:��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ������ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ����丸�ڵ������
	 * ��������
	 * (01) �������ڵ㡱��Ϊ����ɫ����
	 * (02) �����游�ڵ㡱��Ϊ����ɫ����
	 * (03) �ԡ��游�ڵ㡱Ϊ֧�����������

	 * @param n
	 */
	private void insertFix(RBTree<T>.RBTNode<T> n) {
		// TODO Auto-generated method stub
		RBTNode<T> grandParent,parent;
		while ((parent = getParent(n)) != null && isRed(parent)) {	// �游�ڵ�Ϊ��ɫ
			grandParent = getParent(parent);	// �õ���ǰ�ڵ���游�ڵ�
			if (parent == grandParent.left) {	// ���ڵ����游�ڵ������
				RBTNode<T> uncle = grandParent.right;	// �õ�����ڵ�
				// case1:  ��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ���游�ڵ����һ���ӽڵ㣨����ڵ㣩Ҳ�Ǻ�ɫ��
				if (uncle != null && isRed(uncle)) {	// ����ڵ�Ϊ��ɫ
					setBlack(parent);	// ���ڵ���Ϊ��ɫ
					setBlack(uncle);	// ����ڵ���Ϊ��ɫ
					setRed(grandParent);	// �游�ڵ���Ϊ��ɫ
					n = grandParent;		// ���游�ڵ���Ϊ��ǰ�ڵ�
					continue;
				}
				// case2: ��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ������ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ����丸�ڵ���Һ���	
				if (parent.right == n) {
					leftRotate(parent);
					// �����������µ�ǰ�ڵ��븸�ڵ��ϵ�����Ե������ n�� parent ��Ҫ�Ե�����Ӧ
					RBTNode<T> temp = n;
					n = parent;
					parent = temp;
				}
				// case3: ��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ������ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ����丸�ڵ������
				setBlack(parent);
				setRed(grandParent);
				rightRotate(grandParent);
			} else {	// ���ڵ����游�ڵ���Һ���
				RBTNode<T> uncle = grandParent.left;	// �õ�����ڵ�
				// case1:  ��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ���游�ڵ����һ���ӽڵ㣨����ڵ㣩Ҳ�Ǻ�ɫ��
				if (uncle != null && isRed(uncle)) {	// ����ڵ�Ϊ��ɫ
					setBlack(parent);	// ���ڵ���Ϊ��ɫ
					setBlack(uncle);	// ����ڵ���Ϊ��ɫ
					setRed(grandParent);	// �游�ڵ���Ϊ��ɫ
					n = grandParent;		// ���游�ڵ���Ϊ��ǰ�ڵ�
					continue;
				}
				// case2: ��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ������ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ����丸�ڵ������	
				if (parent.left == n) {
					rightRotate(parent);
					// �����������µ�ǰ�ڵ��븸�ڵ��ϵ�����Ե������ n�� parent ��Ҫ�Ե�����Ӧ
					RBTNode<T> temp = n;
					n = parent;
					parent = temp;
				}
				// case3: ��ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ������ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ����丸�ڵ���Һ���
				setBlack(parent);
				setRed(grandParent);
				leftRotate(grandParent);
			}
		}
		setBlack(this.root);	//���ڵ�����Ϊ��ɫ
	}
	
	public RBTNode<T> search(T key) {
		return search(this.root, key);
	}

	/**
	 * �ں�����в���Ŀ��ֵ
	 * 
	 * @param n ��ʼ���ҵĽڵ�
	 * @param key ���ҵ�ֵ
	 * @return ���ҽ��
	 */
	private RBTree<T>.RBTNode<T> search(RBTree<T>.RBTNode<T> n, T key) {
		// TODO Auto-generated method stub
		if (n == null) {
			return n;
		}
		int cmp = key.compareTo(n.key);
		if (cmp < 0) {
			return search(n.left, key);
		} else if (cmp > 0) {
			return search(n.right, key);
		} else {
			return n;
		}
	}
	
	public void remove(T key) {
		RBTNode<T> node;
		if ((node = search(key)) != null) {	// ���ҵ��ڵ㣬��ɾ���ýڵ�
			remove(node);
			System.out.println("�鿴ƽ����");
			print();
			System.out.println();
		}
	}

	/**
	 * ɾ��ĳ���ڵ�
	 * 
	 * ��Ϊ�������:
	 * �� ��ɾ���ڵ�û�ж��ӣ���ΪҶ�ڵ㡣��ô��ֱ�ӽ��ýڵ�ɾ����OK�ˡ�
	 * �� ��ɾ���ڵ�ֻ��һ�����ӡ���ô��ֱ��ɾ���ýڵ㣬���øýڵ��Ψһ�ӽڵ㶥������λ�á�
	 * �� ��ɾ���ڵ����������ӡ���ô�����ҳ����ĺ�̽ڵ㣻Ȼ��ѡ����ĺ�̽ڵ�����ݡ����Ƹ����ýڵ�����ݡ���֮��ɾ�������ĺ�̽ڵ㡱��
	 * �������̽ڵ��൱�������ڽ���̽ڵ�����ݸ��Ƹ�"��ɾ���ڵ�"֮���ٽ���̽ڵ�ɾ��������������Ľ�����ת��Ϊ"ɾ����̽ڵ�"������ˣ�����Ϳ��Ǻ�̽ڵ㡣 
	 * ��"��ɾ���ڵ�"�������ǿ��ӽڵ������£����ĺ�̽ڵ㲻������˫�ӷǿա���Ȼ"�ĺ�̽ڵ�"������˫�Ӷ��ǿգ�����ζ��"�ýڵ�ĺ�̽ڵ�"Ҫôû�ж��ӣ�Ҫôֻ��һ�����ӡ�
	 * ��û�ж��ӣ���"����� "���д�����ֻ��һ�����ӣ���"����� "���д���
	 * @param n
	 */
	private void remove(RBTree<T>.RBTNode<T> n) {
		// TODO Auto-generated method stub
		RBTNode<T> replace;	// ����ȡ����ɾ���ڵ��λ��
		RBTNode<T> x; //����ɾ���ڵ���ӽڵ�
		if (n.left == null || n.right == null) {	// û�л���һ���ӽڵ� 
			replace = n;
		} else {	// �������ӽڵ����ҳ���̽ڵ�
			replace = successor(n);
		}
		if (replace.left != null) {	// ����ɾ�������ӽ��
			x = replace.left;
		} else {
			x = replace.right;
		}
		if (x != null) {	// ����ɾ�������ӽ��ĸ����Ϊɾ�����ĸ����
			x.parent = replace.parent;
		}
		if (replace.parent == null) {	// ���replace�ĸ��ڵ�Ϊ�գ������replace�Ǹ��ڵ�
			this.root = x;
		} else if (replace == replace.parent.left) {	// �����ɾ����������ӽ��,�������ø��ڵ�����ӽڵ�
			replace.parent.left = x;
		} else {	// �����ɾ����������ӽ��,�������ø��ڵ�����ӽڵ�
			replace.parent.right = x;
		}
		if (replace != n) // ����̽���ֵ��ֵ��ɾ����㣬��ɾ����̽�����ʵ����ɾ��Ŀ����
			n.key = replace.key;
		if (getColor(replace) == BLACK) {
			deleteFixUp(x);
		}
		replace = null;	
	}

	/**
	 * ɾ���ڵ������ʧ�⣬����ƽ��
	 * @param n �������ڵ�
	 */
	private void deleteFixUp(RBTree<T>.RBTNode<T> n) {
		// TODO Auto-generated method stub
		RBTNode<T> parent = n.parent;
		RBTNode<T> w;	// �ֵܽڵ�
		while ((n == null || isBlack(n)) && (n != this.root)) {
			if (n == parent.left) {		// nΪ����
				w = parent.right;
				// case1: x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��(��ʱx�ĸ��ڵ��x���ֵܽڵ���ӽڵ㶼�Ǻڽڵ�)��
				if (isRed(w)) {
					setBlack(w);	// �ֵܽڵ���Ϊ��ɫ
					setRed(parent);	// ���ڵ���Ϊ��ɫ
					leftRotate(parent);	// ���ڵ�����
					w = parent.right;	// Ѱ���µ��ֵܽڵ�
				}
				// case2: x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��x���ֵܽڵ���������Ӷ��Ǻ�ɫ��
				if ((w.left == null || isBlack(w.left)) && (w.right == null || isBlack(w.right))) {
					setRed(w);	// �ֵܽڵ���Ϊ��ɫ
					n = parent;	// �ҵ��µĵ�ǰ�ڵ�
					parent = getParent(n);	// �ҵ��µĸ��ڵ�
				} else {
					if (w.right == null || isBlack(w.right)) {		// case3 :x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��x���ֵܽڵ�������Ǻ�ɫ���Һ����Ǻ�ɫ�ġ�
						setBlack(w.left);	// �ֵܽڵ�����ӱ��
						setRed(w);
						rightRotate(w);		// �ֵܽڵ�����
						w = parent.right;	// ��������������x���ֵܽڵ㡣
					}
					// case4: x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��x���ֵܽڵ���Һ����Ǻ�ɫ�ġ�
					setColor(w, getColor(parent));	// ��x���ڵ���ɫ ��ֵ�� x���ֵܽڵ㡣
					setBlack(parent);	// ���ڵ���Ϊ����ɫ����
					setBlack(w.right);	// �ֵ��Һ�����Ϊ��ɫ
					leftRotate(parent);	// ���ڵ�����
					n = this.root;	// n ��Ϊ���ڵ㣬Ȼ���˳�ѭ��
					break;
				}
			} else {	// nΪ�Һ���
				w = parent.left;
				// case1: x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��(��ʱx�ĸ��ڵ��x���ֵܽڵ���ӽڵ㶼�Ǻڽڵ�)��
				if (isRed(w)) {
					setBlack(w);	// �ֵܽڵ���Ϊ��ɫ
					setRed(parent);	// ���ڵ���Ϊ��ɫ
					rightRotate(parent);	// ���ڵ�����
					w = parent.left;	// Ѱ���µ��ֵܽڵ�
				}
				// case2: x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��x���ֵܽڵ���������Ӷ��Ǻ�ɫ��
				if ((w.right == null || isBlack(w.right)) && (w.left == null || isBlack(w.left))) {
					setRed(w);	// �ֵܽڵ���Ϊ��ɫ
					n = parent;	// �ҵ��µĵ�ǰ�ڵ�
					parent = getParent(n);	// �ҵ��µĸ��ڵ�
				} else {
					if (w.left == null || isBlack(w.left)) {		// case3 :x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��x���ֵܽڵ���Һ����Ǻ�ɫ�������Ǻ�ɫ�ġ�
						setBlack(w.right);	// �ֵܽڵ���Һ��ӱ��
						setRed(w);
						leftRotate(w);		// �ֵܽڵ�����
						w = parent.left;	// ��������������x���ֵܽڵ㡣
					}
					// case4: x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��x���ֵܽڵ���Һ����Ǻ�ɫ�ġ�
					setColor(w, getColor(parent));	// ��x���ڵ���ɫ ��ֵ�� x���ֵܽڵ㡣
					setBlack(parent);	// ���ڵ���Ϊ����ɫ����
					setBlack(w.left);	// �ֵ�������Ϊ��ɫ
					rightRotate(parent);	// ���ڵ�����
					n = this.root;	// n ��Ϊ���ڵ㣬Ȼ���˳�ѭ��
					break;
				}
			}
		}
		if (n != null) {
			setBlack(n);
		}
	}

	/**
	 * �ҵ�Ŀ��ڵ�ĺ�̽ڵ�
	 * @param n
	 * @return
	 */
	private RBTree<T>.RBTNode<T> successor(RBTree<T>.RBTNode<T> n) {
		// TODO Auto-generated method stub
		if (n.right != null) {	// ����ҽڵ㲻Ϊ�գ��� n �ĺ�̽ڵ�Ϊ n.right����С�ڵ�
			return minNode(n.right);
		} 
		// ���nû���Һ��ӡ���x���������ֿ��ܣ�
	    // 1. n��"һ������"����"n�ĺ�̽��"Ϊ "���ĸ����"��
	    // 2. n��"һ���Һ���"�������"n����͵ĸ���㣬���Ҹø����Ҫ��������"���ҵ������"��͵ĸ����"����"n�ĺ�̽��"��
		RBTNode<T> y = n.parent;
		while(y != null && y.right == n) {
			n = y;
			y = y.parent;
		}
		return y;
	}

	public void print() {
		if (this.root != null) {
			print(this.root, root.key, 0);
		}
	}
	
	/*
	 *  ��ӡ"�����"
     *
     * key        -- �ڵ�ļ�ֵ 
     * direction  --  0����ʾ�ýڵ��Ǹ��ڵ�
     *               -1����ʾ�ýڵ������ĸ���������;
     *                1����ʾ�ýڵ������ĸ������Һ��ӡ�
     */
    private void print(RBTNode<T> tree, T key, int direction) {
 
         if(tree != null) {
 
             if(direction==0)    // tree�Ǹ��ڵ�
                 System.out.printf("%2d(B) is root\n", tree.key);
             else                // tree�Ƿ�֧�ڵ�
                 System.out.printf("%2d(%s) is %2d's %6s child \n", tree.key, isRed(tree)?"R":"B", key, direction==1?"right" : "left");
 
             print(tree.left, tree.key, -1);
             print(tree.right,tree.key,  1);
        }
     }
}
