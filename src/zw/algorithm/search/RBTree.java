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
