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
		
		//���Բ�������
		System.out.print("˳����ӣ�");
		for (int i : arrTest) {
			System.out.print(i + " ");
			bsTree.insert(i);
		}
		
		//����ǰ��,����,�������
		System.out.print("\nǰ�������");
		bsTree.preorder();
		System.out.print("\n���������");
		bsTree.inorder();
		System.out.print("\n���������");
		bsTree.postorder();
		
		//���Բ�������
		int[] arrSearch = {1,5,4,3,2,6,9};
		for (int i : arrSearch) {
			Node<Integer> n = bsTree.search(i);
			if (n != null) {
				System.out.print("\n���� " + i + " --> ���ҽ����" + n.getKey());
			} else {
				System.out.print("\n���� " + i + " --> ���ҽ����δ�ҵ�");
			}
		}
		
		//����ɾ������
		int[] arrRemove = {1,6,9,6};
		for (int i : arrRemove) {
			System.out.print("\nɾ��ֵ " + i);
			bsTree.remove(i);
		}
		System.out.print("\n���������");
		bsTree.inorder();
		
		//���ٶ���������
		bsTree.clear();
		bsTree.inorder();
	}

}
