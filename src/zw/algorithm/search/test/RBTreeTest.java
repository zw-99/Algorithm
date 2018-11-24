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
		
//		//���Բ�������
//		int[] arrSearch = {1,5,4,3,2,6,9};
//		for (int i : arrSearch) {
//			RBTree<Integer>.RBTNode<Integer> n = tree.search(i);
//			if (n != null) {
//				System.out.print("\n���� " + i + " --> ���ҽ����" + n.getKey());
//			} else {
//				System.out.print("\n���� " + i + " --> ���ҽ����δ�ҵ�");
//			}
//		}
		
		System.out.println();
		tree.print();
		
		//����ɾ������
		int[] arrRemove = {10,20};//{10, 40, 30, 60, 90, 70, 20, 50, 80};
		for (int i : arrRemove) {
			System.out.print("\nɾ��ֵ " + i);
			tree.remove(i);
		}
		System.out.print("\n���������");
		tree.inorder();
	}

}
