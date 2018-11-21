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
	 * @param key
	 */
	public void insert(T key) {
		RBTNode<T> node = new RBTNode<T>(key, BLACK, null, null, null);
		if (node != null) {
			insert(node);
		}
	}

	private void insert(RBTree<T>.RBTNode<T> node) {
		// TODO Auto-generated method stub
		
	}
}
