package zw.algorithm.search.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import zw.algorithm.search.BSTree;

class BSTreeTest {

	@Test
	void testprocess() {
		int arr[] = {1,5,4,3,2,6};
		BSTree<Integer> bsTree = new BSTree<Integer>();
		System.out.println("˳����ӣ�");
		for (int i : arr) {
			System.out.print(i + " ");
			bsTree.insert(i);
		}
		System.out.print("\nǰ�������");
		bsTree.preorder();
		System.out.print("\n���������");
		bsTree.inorder();
		System.out.print("\n���������");
		bsTree.postorder();
	}

}
