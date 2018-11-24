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
	 * 找到指定节点开始的最小节点
	 * @param n 起始节点
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
				setBlack(parent);
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
				setBlack(parent);
				setRed(grandParent);
				leftRotate(grandParent);
			}
		}
		setBlack(this.root);	//根节点设置为黑色
	}
	
	public RBTNode<T> search(T key) {
		return search(this.root, key);
	}

	/**
	 * 在红黑树中查找目标值
	 * 
	 * @param n 开始查找的节点
	 * @param key 查找的值
	 * @return 查找结果
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
		if ((node = search(key)) != null) {	// 先找到节点，再删除该节点
			remove(node);
			System.out.println("查看平衡性");
			print();
			System.out.println();
		}
	}

	/**
	 * 删除某个节点
	 * 
	 * 分为三种情况:
	 * ① 被删除节点没有儿子，即为叶节点。那么，直接将该节点删除就OK了。
	 * ② 被删除节点只有一个儿子。那么，直接删除该节点，并用该节点的唯一子节点顶替它的位置。
	 * ③ 被删除节点有两个儿子。那么，先找出它的后继节点；然后把“它的后继节点的内容”复制给“该节点的内容”；之后，删除“它的后继节点”。
	 * 在这里，后继节点相当于替身，在将后继节点的内容复制给"被删除节点"之后，再将后继节点删除。这样就巧妙的将问题转换为"删除后继节点"的情况了，下面就考虑后继节点。 
	 * 在"被删除节点"有两个非空子节点的情况下，它的后继节点不可能是双子非空。既然"的后继节点"不可能双子都非空，就意味着"该节点的后继节点"要么没有儿子，要么只有一个儿子。
	 * 若没有儿子，则按"情况① "进行处理；若只有一个儿子，则按"情况② "进行处理
	 * @param n
	 */
	private void remove(RBTree<T>.RBTNode<T> n) {
		// TODO Auto-generated method stub
		RBTNode<T> replace;	// 用于取代被删除节点的位置
		RBTNode<T> x; //缓存删除节点的子节点
		if (n.left == null || n.right == null) {	// 没有或有一个子节点 
			replace = n;
		} else {	// 有两个子节点则找出后继节点
			replace = successor(n);
		}
		if (replace.left != null) {	// 保留删除结点的子结点
			x = replace.left;
		} else {
			x = replace.right;
		}
		if (x != null) {	// 更换删除结点的子结点的父结点为删除结点的父结点
			x.parent = replace.parent;
		}
		if (replace.parent == null) {	// 如果replace的父节点为空，则表明replace是根节点
			this.root = x;
		} else if (replace == replace.parent.left) {	// 如果被删除结点是左子结点,重新设置父节点的左子节点
			replace.parent.left = x;
		} else {	// 如果被删除结点是右子结点,重新设置父节点的右子节点
			replace.parent.right = x;
		}
		if (replace != n) // 将后继结点的值赋值给删除结点，再删除后继结点便间接实现了删除目标结点
			n.key = replace.key;
		if (getColor(replace) == BLACK) {
			deleteFixUp(x);
		}
		replace = null;	
	}

	/**
	 * 删除节点后红黑树失衡，重新平衡
	 * @param n 待修正节点
	 */
	private void deleteFixUp(RBTree<T>.RBTNode<T> n) {
		// TODO Auto-generated method stub
		RBTNode<T> parent = n.parent;
		RBTNode<T> w;	// 兄弟节点
		while ((n == null || isBlack(n)) && (n != this.root)) {
			if (n == parent.left) {		// n为左孩子
				w = parent.right;
				// case1: x是“黑+黑”节点，x的兄弟节点是红色。(此时x的父节点和x的兄弟节点的子节点都是黑节点)。
				if (isRed(w)) {
					setBlack(w);	// 兄弟节点设为黑色
					setRed(parent);	// 父节点设为红色
					leftRotate(parent);	// 父节点左旋
					w = parent.right;	// 寻找新的兄弟节点
				}
				// case2: x是“黑+黑”节点，x的兄弟节点是黑色，x的兄弟节点的两个孩子都是黑色。
				if ((w.left == null || isBlack(w.left)) && (w.right == null || isBlack(w.right))) {
					setRed(w);	// 兄弟节点设为红色
					n = parent;	// 找到新的当前节点
					parent = getParent(n);	// 找到新的父节点
				} else {
					if (w.right == null || isBlack(w.right)) {		// case3 :x是“黑+黑”节点，x的兄弟节点是黑色；x的兄弟节点的左孩子是红色，右孩子是黑色的。
						setBlack(w.left);	// 兄弟节点的左孩子变红
						setRed(w);
						rightRotate(w);		// 兄弟节点右旋
						w = parent.right;	// 右旋后，重新设置x的兄弟节点。
					}
					// case4: x是“黑+黑”节点，x的兄弟节点是黑色；x的兄弟节点的右孩子是红色的。
					setColor(w, getColor(parent));	// 将x父节点颜色 赋值给 x的兄弟节点。
					setBlack(parent);	// 父节点设为“黑色”。
					setBlack(w.right);	// 兄弟右孩子设为黑色
					leftRotate(parent);	// 父节点左旋
					n = this.root;	// n 设为根节点，然后退出循环
					break;
				}
			} else {	// n为右孩子
				w = parent.left;
				// case1: x是“黑+黑”节点，x的兄弟节点是红色。(此时x的父节点和x的兄弟节点的子节点都是黑节点)。
				if (isRed(w)) {
					setBlack(w);	// 兄弟节点设为黑色
					setRed(parent);	// 父节点设为红色
					rightRotate(parent);	// 父节点左旋
					w = parent.left;	// 寻找新的兄弟节点
				}
				// case2: x是“黑+黑”节点，x的兄弟节点是黑色，x的兄弟节点的两个孩子都是黑色。
				if ((w.right == null || isBlack(w.right)) && (w.left == null || isBlack(w.left))) {
					setRed(w);	// 兄弟节点设为红色
					n = parent;	// 找到新的当前节点
					parent = getParent(n);	// 找到新的父节点
				} else {
					if (w.left == null || isBlack(w.left)) {		// case3 :x是“黑+黑”节点，x的兄弟节点是黑色；x的兄弟节点的右孩子是红色，左孩子是黑色的。
						setBlack(w.right);	// 兄弟节点的右孩子变红
						setRed(w);
						leftRotate(w);		// 兄弟节点左旋
						w = parent.left;	// 左旋后，重新设置x的兄弟节点。
					}
					// case4: x是“黑+黑”节点，x的兄弟节点是黑色；x的兄弟节点的右孩子是红色的。
					setColor(w, getColor(parent));	// 将x父节点颜色 赋值给 x的兄弟节点。
					setBlack(parent);	// 父节点设为“黑色”。
					setBlack(w.left);	// 兄弟左孩子设为黑色
					rightRotate(parent);	// 父节点右旋
					n = this.root;	// n 设为根节点，然后退出循环
					break;
				}
			}
		}
		if (n != null) {
			setBlack(n);
		}
	}

	/**
	 * 找到目标节点的后继节点
	 * @param n
	 * @return
	 */
	private RBTree<T>.RBTNode<T> successor(RBTree<T>.RBTNode<T> n) {
		// TODO Auto-generated method stub
		if (n.right != null) {	// 如果右节点不为空，则 n 的后继节点为 n.right的最小节点
			return minNode(n.right);
		} 
		// 如果n没有右孩子。则x有以下两种可能：
	    // 1. n是"一个左孩子"，则"n的后继结点"为 "它的父结点"。
	    // 2. n是"一个右孩子"，则查找"n的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"n的后继结点"。
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
	 *  打印"红黑树"
     *
     * key        -- 节点的键值 
     * direction  --  0，表示该节点是根节点
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(RBTNode<T> tree, T key, int direction) {
 
         if(tree != null) {
 
             if(direction==0)    // tree是根节点
                 System.out.printf("%2d(B) is root\n", tree.key);
             else                // tree是分支节点
                 System.out.printf("%2d(%s) is %2d's %6s child \n", tree.key, isRed(tree)?"R":"B", key, direction==1?"right" : "left");
 
             print(tree.left, tree.key, -1);
             print(tree.right,tree.key,  1);
        }
     }
}
