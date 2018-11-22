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
			cmp = n.key.compareTo(y.key);
			if (cmp < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
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
				setRed(parent);
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
				setRed(parent);
				setRed(grandParent);
				leftRotate(grandParent);
			}
		}
		setBlack(this.root);	//���ڵ�����Ϊ��ɫ
	}
}
