package zw.algorithm.search.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import zw.algorithm.search.BSTree;
import zw.algorithm.search.Node;

class BSTreeTest {

	@Test
	void testprocess() {
		int[] arrTest = {1,5,4,3,2,6,8,7,6};
		BSTree<Integer> bsTree = new BSTree<Integer>();
		
		//测试插入数据
		System.out.print("顺序添加：");
		for (int i : arrTest) {
			System.out.print(i + " ");
			bsTree.insert(i);
		}
		
		//测试前序,中序,后序遍历
		System.out.print("\n前序遍历：");
		bsTree.preorder();
		System.out.print("\n中序遍历：");
		bsTree.inorder();
		System.out.print("\n后序遍历：");
		bsTree.postorder();
		
		//测试查找数据
		int[] arrSearch = {1,5,4,3,2,6,9};
		for (int i : arrSearch) {
			Node<Integer> n = bsTree.search(i);
			if (n != null) {
				System.out.print("\n查找 " + i + " --> 查找结果：" + n.getKey());
			} else {
				System.out.print("\n查找 " + i + " --> 查找结果：未找到");
			}
		}
		
		//测试删除数据
		int[] arrRemove = {1,6,9,6};
		for (int i : arrRemove) {
			System.out.print("\n删除值 " + i);
			bsTree.remove(i);
		}
		System.out.print("\n中序遍历：");
		bsTree.inorder();
		
		//销毁二叉树测试
		bsTree.clear();
		bsTree.inorder();
	}

}
