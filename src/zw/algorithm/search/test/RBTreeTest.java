package zw.algorithm.search.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import zw.algorithm.search.RBTree;
import zw.algorithm.search.RBTree.RBTNode;

class RBTreeTest {
	
	@Test
	void testprocess() {
		int[] arrTest ={10, 40, 30, 60, 90, 70, 20, 50, 80}; //{1,5,4,3,2,6,8,7,6};	//
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
		
//		//测试查找数据
//		int[] arrSearch = {1,5,4,3,2,6,9};
//		for (int i : arrSearch) {
//			RBTree<Integer>.RBTNode<Integer> n = tree.search(i);
//			if (n != null) {
//				System.out.print("\n查找 " + i + " --> 查找结果：" + n.getKey());
//			} else {
//				System.out.print("\n查找 " + i + " --> 查找结果：未找到");
//			}
//		}
		
		System.out.println();
		tree.print();
		
		//测试删除数据
		int[] arrRemove = {10,20};//{10, 40, 30, 60, 90, 70, 20, 50, 80};
		for (int i : arrRemove) {
			System.out.print("\n删除值 " + i);
			tree.remove(i);
		}
		System.out.print("\n中序遍历：");
		tree.inorder();
	}

}
