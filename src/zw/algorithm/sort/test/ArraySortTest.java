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
		System.out.print("ð������-����");
		int[] testArray = testData1;
		ArraySort.bubbleSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("�������");
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
		System.out.print("ð������-����");
		int[] testArray = testData1;
		ArraySort.bubbleSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("�������");
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
		System.out.print("ѡ������-����");
		int[] testArray = testData1;
		ArraySort.selectSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("�������");
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
		System.out.print("ѡ������-����");
		int[] testArray = testData1;
		ArraySort.selectSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("�������");
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
		System.out.print("��������-����");
		int[] testArray = testData1;
		ArraySort.insertionSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("�������");
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
		System.out.print("��������-����");
		int[] testArray = testData1;
		ArraySort.insertionSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("�������");
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
		System.out.print("ϣ������-����");
		int[] testArray = testData1;
		ArraySort.shellSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("�������");
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
		System.out.print("ϣ������-����");
		int[] testArray = testData1;
		ArraySort.shellSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("�������");
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
		System.out.print("������-����");
		int[] testArray = testData1;
		ArraySort.heapSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("�������");
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
		System.out.print("������-����");
		int[] testArray = testData1;
		ArraySort.heapSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("�������");
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
		System.out.print("��������-����");
		int[] testArray = testData1;
		ArraySort.quickSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("�������");
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
		System.out.print("��������-����");
		int[] testArray = testData1;
		ArraySort.quickSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("�������");
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
		System.out.print("�鲢����-����");
		int[] testArray = testData1;
		ArraySort.mergeSortAsc(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultAsc[i]) {
				fail("�������");
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
		System.out.print("�鲢����-����");
		int[] testArray = testData1;
		ArraySort.mergeSortDes(testArray);
		for (int i = 0; i < testArray.length; i++) {
			if (testArray[i] != testData1ResultDes[i]) {
				fail("�������");
				break;
			}
		}
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
