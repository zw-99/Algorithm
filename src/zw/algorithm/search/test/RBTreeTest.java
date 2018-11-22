package zw.algorithm.search.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import zw.algorithm.search.RBTree;

class RBTreeTest {
	
	@Test
	void testprocess() {
		int[] arrTest = {1,5,4,3,2,6,8,7,6};
		RBTree<Integer> tree = new RBTree<Integer>();
		//测试插入数据
		System.out.print("顺序添加：");
		for (int i : arrTest) {
			System.out.print(i + " ");
			tree.insert(i);
		}
		//测试前序,中序,后序遍历
		System.out.print("\n前序遍历：");
		tree.preorder();
		System.out.print("\n中序遍历：");
		tree.inorder();
		System.out.print("\n后序遍历：");
		tree.postorder();
		
	}

}
