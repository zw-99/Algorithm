package zw.algorithm.sort.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import zw.algorithm.sort.ArraySort;

class ArraySortTest {

	@Test
	void testBubbleSortAsc() {
		System.out.println("ð������-����");
		double[] testArray1 = new double[]{7,6,5,4,3,2,1};
		ArraySort.bubbleSortAsc(testArray1);
		for (double d : testArray1) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
	@Test
	void testBubbleSortDes() {
		System.out.println("ð������-����");
		double[] testArray1 = new double[]{1,2,3,4,5,6,7};
		ArraySort.bubbleSortDes(testArray1);
		for (double d : testArray1) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
	@Test
	void testSelectSortAsc() {
		System.out.println("ѡ������-����");
		double[] testArray1 = new double[]{7,6,5,4,3,2,1};
		ArraySort.selectSortAsc(testArray1);
		for (double d : testArray1) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
	@Test
	void testSelectSortDes() {
		System.out.println("ѡ������-����");
		double[] testArray1 = new double[]{1,2,3,4,5,6,7};
		ArraySort.selectSortDes(testArray1);
		for (double d : testArray1) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
	@Test
	void testInsertionSortAsc() {
		System.out.println("��������-����");
		double[] testArray1 = new double[]{7,6,5,4,3,2,1};
		ArraySort.insertionSortAsc(testArray1);
		for (double d : testArray1) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
	@Test
	void testInsertionSortDes() {
		System.out.println("��������-����");
		double[] testArray1 = new double[]{1,2,3,4,5,6,7};
		ArraySort.insertionSortDes(testArray1);
		for (double d : testArray1) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
	@Test
	void testshellSortAsc() {
		System.out.println("ϣ������-����");
		double[] testArray1 = new double[]{7,6,5,4,3,2,1};
		ArraySort.shellSortAsc(testArray1);
		for (double d : testArray1) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
	@Test
	void testshellSortDes() {
		System.out.println("ϣ������-����");
		double[] testArray1 = new double[]{1,2,3,4,5,6,7};
		ArraySort.shellSortDes(testArray1);
		for (double d : testArray1) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
}
