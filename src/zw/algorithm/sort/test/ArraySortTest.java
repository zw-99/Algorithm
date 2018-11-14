package zw.algorithm.sort.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import zw.algorithm.sort.ArraySort;

class ArraySortTest {

	int[] testData1 = new int[] {6, 5,7, 8,4, 3, 2, 1, 1};
	int[] testData1ResultAsc = new int[testData1.length];
	int[] testData1ResultDes = new int[testData1.length];
	
	@BeforeEach
	void BeforeTestExecution() {
		testData1ResultAsc = Arrays.copyOf(testData1, testData1.length);
		Arrays.sort(testData1ResultAsc);
		for (int i = 0, j = testData1ResultAsc.length -1; j >= 0; i++,j--) {
			testData1ResultDes[i] = testData1ResultAsc[j];
		}
	}
	
	@Test
	void testBubbleSortAsc() {
		System.out.print("Ã°ÅÝÅÅÐò-ÉýÐò£º");
		int[] testArray = testData1;
		ArraySort.bubbleSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testBubbleSortDes() {
		System.out.print("Ã°ÅÝÅÅÐò-½µÐò£º");
		int[] testArray = testData1;
		ArraySort.bubbleSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testSelectSortAsc() {
		System.out.print("Ñ¡ÔñÅÅÐò-ÉýÐò£º");
		int[] testArray = testData1;
		ArraySort.selectSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testSelectSortDes() {
		System.out.print("Ñ¡ÔñÅÅÐò-½µÐò£º");
		int[] testArray = testData1;
		ArraySort.selectSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testInsertionSortAsc() {
		System.out.print("²åÈëÅÅÐò-ÉýÐò£º");
		int[] testArray = testData1;
		ArraySort.insertionSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testInsertionSortDes() {
		System.out.print("²åÈëÅÅÐò-½µÐò£º");
		int[] testArray = testData1;
		ArraySort.insertionSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testShellSortAsc() {
		System.out.print("Ï£¶ûÅÅÐò-ÉýÐò£º");
		int[] testArray = testData1;
		ArraySort.shellSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testShellSortDes() {
		System.out.print("Ï£¶ûÅÅÐò-½µÐò£º");
		int[] testArray = testData1;
		ArraySort.shellSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testHeapSortAsc() {
		System.out.print("¶ÑÅÅÐò-ÉýÐò£º");
		int[] testArray = testData1;
		ArraySort.heapSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testHeapSortDes() {
		System.out.print("¶ÑÅÅÐò-½µÐò£º");
		int[] testArray = testData1;
		ArraySort.heapSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testquickSortAsc() {
		System.out.print("¿ìËÙÅÅÐò-ÉýÐò£º");
		int[] testArray = testData1;
		ArraySort.quickSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testquickSortDes() {
		System.out.print("¿ìËÙÅÅÐò-½µÐò£º");
		int[] testArray = testData1;
		ArraySort.quickSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testmergeSortAsc() {
		System.out.print("¹é²¢ÅÅÐò-ÉýÐò£º");
		int[] testArray = testData1;
		ArraySort.mergeSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	void testmergeSortDes() {
		System.out.print("¹é²¢ÅÅÐò-½µÐò£º");
		int[] testArray = testData1;
		ArraySort.mergeSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("ÅÅÐò´íÎó");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
