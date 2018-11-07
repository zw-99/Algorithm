package zw.algorithm.sort;

import zw.algorithm.util.*;

public class ArraySort {
	
	/**
	 * @param arr
	 * 冒泡排序法,按照升序排列
	 */
	public static void bubbleSortAsc(double arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
			boolean flag = true;	//设定一个标志，若为ture，则说明此次循环没有交换元素，待排序元素已经有序，即排序完成
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					Util.arrayElementSwap(arr, j, j + 1);
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
	}
	
	public static void bubbleSortAsc(int arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
			boolean flag = true;	//设定一个标志，若为ture，则说明此次循环没有交换元素，待排序元素已经有序，即排序完成
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					Util.arrayElementSwap(arr, j, j + 1);
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
	}
	
	/**
	 * @param arr
	 * 冒泡排序法,按照降序排列
	 */
	public static void bubbleSortDes(double arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
			boolean flag = true;	//设定一个标志，若为ture，则说明此次循环没有交换元素，待排序元素已经有序，即排序完成
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] < arr[j + 1]) {
					Util.arrayElementSwap(arr, j, j + 1);
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
	}
	
	public static void bubbleSortDes(int arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
			boolean flag = true;	//设定一个标志，若为ture，则说明此次循环没有交换元素，待排序元素已经有序，即排序完成
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] < arr[j + 1]) {
					Util.arrayElementSwap(arr, j, j + 1);
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
	}
	
	/**
	 * @param arr
	 * 选择排序，按照升序排列
	 */
	public static void selectSortAsc(double arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;	//每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j] < min)
					min = j;
			}
			if(min != i) {
				Util.arrayElementSwap(arr, min, i);
			}
		}
	}
}
