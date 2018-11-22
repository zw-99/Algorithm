package zw.algorithm.search.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import zw.algorithm.search.RBTree;

class RBTreeTest {
	
	@Test
	void testprocess() {
		int[] arrTest = {1,5,4,3,2,6,8,7,6};
		RBTree<Integer> tree = new RBTree<Integer>();
		//���Բ�������
		System.out.print("˳����ӣ�");
		for (int i : arrTest) {
			System.out.print(i + " ");
			tree.insert(i);
		}
		//����ǰ��,����,�������
		System.out.print("\nǰ�������");
		tree.preorder();
		System.out.print("\n���������");
		tree.inorder();
		System.out.print("\n���������");
		tree.postorder();
		
	}

}
