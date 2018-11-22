package zw.algorithm.search;


//红黑树性质
//(1) 每个节点或者是黑色，或者是红色。
//(2) 根节点是黑色。
//(3) 每个叶子节点是黑色。 [注意：这里叶子节点，是指为空的叶子节点！]
//(4) 如果一个节点是红色的，则它的子节点必须是黑色的。
//(5) 从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。


/**
 * 红黑树
 * @author 13479
 *
 */
public class RBTree<T extends Comparable<T>> {
	private RBTNode<T> root;	// 根节点
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	/**
	 * 红黑树节点
	 * @author 13479
	 *
	 * @param <T>
	 */
	public class RBTNode<T extends Comparable<T>>{
		T key;	// 键值
		boolean color;	// 颜色
		RBTNode<T> parent;	// 父节点
		RBTNode<T> left;	// 左子节点
		RBTNode<T> right;	// 右子节点
		
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
	 * 获取节点的颜色，空节点颜色为黑色
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
	 * 前序遍历
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
	 * 中序遍历
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
	 * 节点左旋
	 * 1. 处理当前节点与右子节点的左孩子的关系
	 * 2. 处理当前节点右节点与当前节点父节点的关系
	 * 3. 处理当前节点与右子节点的关系
	 * @param n
	 */
	private void leftRotate(RBTNode<T> n) {
		RBTNode<T> x = n.right;	// 设置x为n的右孩子
		// 1. 处理当前节点与右子节点的左孩子的关系
		n.right = x.left;	// 设置n的右孩子为x的左孩子
		if (x.left != null) {	// 如果x的左孩子不为空，则x左孩子的父节点为n
			x.left.parent = n;
		}
		// 2. 处理当前节点右节点与当前节点父节点的关系
		x.parent = n.parent;	// 将x的父节点设置为n的父节点
		if (n.parent == null) {	// 如果n的父节点为空，则x节点为根节点
			this.root = x;
		} else {	// n的父节点不为空
			if (n.parent.left == n) {	// 如果n是父节点的左子节点，那么x为左子节点
				n.parent.left = x;
			} else {	// 如果n是父节点的右子节点，那么x为右子节点
				n.parent.right = x;
			}
		}
		// 3. 处理当前节点与右子节点的关系
		x.left = n;		// 将x的左子节点设为n
		n.parent = x;	// 将n的父节点设为x
	}
	
	/**
	 * 节点右旋
	 * 1. 处理当前节点与左子节点的右孩子的关系
	 * 2. 处理当前节点左节点与当前节点父节点的关系
	 * 3. 处理当前节点与左子节点的关系
	 * @param n
	 */
	private void rightRotate(RBTNode<T> n) {
		RBTNode<T> x = n.left;	// 设置x为n的左孩子
		// 1. 处理当前节点与左子节点的右孩子的关系
		n.left = x.right;	// 设置n的左孩子为x的右孩子
		if (x.right != null) {	// 如果x的右节点不为空，则x右孩子的父节点为n
			x.right.parent = n;
		}
		// 2. 处理当前节点左节点与当前节点父节点的关系
		x.parent = n.parent;	// 将x的父节点设置为n的父节点
		if (n.parent == null) {	// 如果n的父节点为空，则x节点为根节点
			this.root = x;
		} else {	// 如果n的父节点不为空
			if (n.parent.left == n) {	// 如果n是父节点的左子节点，那么x为左子节点
				n.parent.left = x;
			} else {	// 如果n是父节点的右子节点，那么x为右子节点
				n.parent.right = x;
			}
		}
		// 3. 处理当前节点与左子节点的关系
		x.right = n;	// 将x的右子节点设为n
		n.parent = x;	// 将n的父节点设为x
	}
	
	/**
	 * 插入新的键值
	 * @param key 新值
	 */
	public void insert(T key) {
		RBTNode<T> node = new RBTNode<T>(key, BLACK, null, null, null);	//新建节点，如果失败则返回
		if (node != null) {
			insert(node);
		}
	}

	/**
	 * 在红黑树中插入新节点
	 * 
	 * ① 情况说明：被插入的节点是根节点。（破坏了平衡）
	 *  处理方法：直接把此节点涂为黑色。
	 * ② 情况说明：被插入的节点的父节点是黑色。（未破坏平衡）
	 * 处理方法：什么也不需要做。节点被插入后，仍然是红黑树。
	 * ③ 情况说明：被插入的节点的父节点是红色。（破坏了平衡）
	 * 处理方法：那么，该情况与红黑树的“特性(5)”相冲突。这种情况下，被插入节点是一定存在非空祖父节点的；进一步的讲，被插入节点也一定存在叔叔节点(即使叔叔节点为空，
	 * 也视之为存在，空节点本身就是黑色节点)。依据"叔叔节点的情况"，将这种情况进一步划分为3种情况(Case)。
	 * case1: 当前节点的父节点是红色，且当前节点的祖父节点的另一个子节点（叔叔节点）也是红色。
	 * case2:当前节点的父节点是红色，叔叔节点是黑色，且当前节点是其父节点的右孩子
	 * case3:当前节点的父节点是红色，叔叔节点是黑色，且当前节点是其父节点的左孩子
	 * @param n
	 */
	private void insert(RBTree<T>.RBTNode<T> n) {
		// 1.将红黑树当作二叉查找树，将节点插入到二叉查找树中
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
		// 2.将节点颜色设置为红色
		n.color = RED;
		// 3. 将树修复为红黑树树
		insertFix(n);
	}

	/**
	 * 红黑树插入修正方法
	 * 在红黑树失去平衡时才使用次方法
	 * 
	 * 
	 *  case1: 当前节点的父节点是红色，且当前节点的祖父节点的另一个子节点（叔叔节点）也是红色。
	 *  处理方法：
	 * (01) 将“父节点”设为黑色。
	 * (02) 将“叔叔节点”设为黑色。
	 * (03) 将“祖父节点”设为“红色”。
	 * (04) 将“祖父节点”设为“当前节点”(红色节点)；即，之后继续对“当前节点”进行操作。
	 * 
	 * case2:当前节点的父节点是红色，叔叔节点是黑色，且当前节点是其父节点的右孩子
	 * 处理方法	:
	 * (01) 将“父节点”作为“新的当前节点”。
	 * (02) 以“新的当前节点”为支点进行左旋。
	 * 
	 * case3:当前节点的父节点是红色，叔叔节点是黑色，且当前节点是其父节点的左孩子
	 * 处理方法：
	 * (01) 将“父节点”设为“黑色”。
	 * (02) 将“祖父节点”设为“红色”。
	 * (03) 以“祖父节点”为支点进行右旋。

	 * @param n
	 */
	private void insertFix(RBTree<T>.RBTNode<T> n) {
		// TODO Auto-generated method stub
		RBTNode<T> grandParent,parent;
		while ((parent = getParent(n)) != null && isRed(parent)) {	// 祖父节点为红色
			grandParent = getParent(parent);	// 得到当前节点的祖父节点
			if (parent == grandParent.left) {	// 父节点是祖父节点的左孩子
				RBTNode<T> uncle = grandParent.right;	// 得到叔叔节点
				// case1:  当前节点的父节点是红色，且当前节点的祖父节点的另一个子节点（叔叔节点）也是红色。
				if (uncle != null && isRed(uncle)) {	// 叔叔节点为红色
					setBlack(parent);	// 父节点设为黑色
					setBlack(uncle);	// 叔叔节点设为黑色
					setRed(grandParent);	// 祖父节点设为红色
					n = grandParent;		// 将祖父节点设为当前节点
					continue;
				}
				// case2: 当前节点的父节点是红色，叔叔节点是黑色，且当前节点是其父节点的右孩子	
				if (parent.right == n) {
					leftRotate(parent);
					// 左旋操作导致当前节点与父节点关系发生对调，因此 n与 parent 需要对调以适应
					RBTNode<T> temp = n;
					n = parent;
					parent = temp;
				}
				// case3: 当前节点的父节点是红色，叔叔节点是黑色，且当前节点是其父节点的左孩子
				setRed(parent);
				setRed(grandParent);
				rightRotate(grandParent);
			} else {	// 父节点是祖父节点的右孩子
				RBTNode<T> uncle = grandParent.left;	// 得到叔叔节点
				// case1:  当前节点的父节点是红色，且当前节点的祖父节点的另一个子节点（叔叔节点）也是红色。
				if (uncle != null && isRed(uncle)) {	// 叔叔节点为红色
					setBlack(parent);	// 父节点设为黑色
					setBlack(uncle);	// 叔叔节点设为黑色
					setRed(grandParent);	// 祖父节点设为红色
					n = grandParent;		// 将祖父节点设为当前节点
					continue;
				}
				// case2: 当前节点的父节点是红色，叔叔节点是黑色，且当前节点是其父节点的左孩子	
				if (parent.left == n) {
					rightRotate(parent);
					// 左旋操作导致当前节点与父节点关系发生对调，因此 n与 parent 需要对调以适应
					RBTNode<T> temp = n;
					n = parent;
					parent = temp;
				}
				// case3: 当前节点的父节点是红色，叔叔节点是黑色，且当前节点是其父节点的右孩子
				setRed(parent);
				setRed(grandParent);
				leftRotate(grandParent);
			}
		}
		setBlack(this.root);	//根节点设置为黑色
	}
}
