package zw.algorithm.sort.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import zw.algorithm.sort.ArraySort;

class ArraySortTest {

	@Test
	void testBubbleSortAsc() {
		double[] testArray1 = new double[]{7,6,5,4,3,2,1};
		ArraySort.bubbleSortAsc(testArray1);
		for (double d : testArray1) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
	@Test
	void testBubbleSortDes() {
		double[] testArray1 = new double[]{1,2,3,4,5,6,7};
		ArraySort.bubbleSortDes(testArray1);
		for (double d : testArray1) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
}
