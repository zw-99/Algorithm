package zw.algorithm.search.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zw.algorithm.sort.*;
import zw.algorithm.search.*;

class ArraySearchTest {
	int[] testData1 = new int[] {6, 5,7, 8,4, 3, 2, 1, 0};
	int testValue = 8;
	boolean testData1Result = true;
	
	@Test
	void testBinarySearch() {
		ArraySort.mergeSortAsc(testData1);
		int searchResult = ArraySearch.binarySearch(testData1, testValue);
		System.out.println("二分查找:元素索引为 " + searchResult);
	}
	
	@Test
	void testInsertionSearch() {
		ArraySort.mergeSortAsc(testData1);
		int searchResult = ArraySearch.insertionSearch(testData1, testValue);
			System.out.println("插值查找:元素索引为 " + searchResult);
	}

}
