package zw.algorithm.sort;

import zw.algorithm.util.*;

/**
 * @author 13479
 *
 */
public class ArraySort {
	
	/**
	 * @param arr
	 * 冒泡排序法,升序
	 */
	public static void bubbleSortAsc(double[] arr) {
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
	
	public static void bubbleSortAsc(int[] arr) {
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
	 * 冒泡排序法,降序
	 */
	public static void bubbleSortDes(double[] arr) {
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
	
	public static void bubbleSortDes(int[] arr) {
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
	 * 选择排序，升序
	 */
	public static void selectSortAsc(double[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;	//每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[min])
					min = j;
			}
			if(min != i) {
				Util.arrayElementSwap(arr, min, i);
			}
		}
	}
	
	/**
	 * @param arr
	 * 选择排序，降序
	 */
	public static void selectSortDes(double[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int max = i;	//每一趟循环比较时，max用于存放较大元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最大的元素的下标，避免每次遇到较大元素都要进行交换。
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j] > arr[max])
					max = j;
			}
			if(max != i) {
				Util.arrayElementSwap(arr, max, i);
			}
		}
	}
	
	/**
	 * @param arr
	 * 插入排序，升序
	 */
	public static void insertionSortAsc(double[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int j = i;
			while(j > 0 && arr[j -1] > arr[j]) {
				Util.arrayElementSwap(arr, j, j - 1);
				j--;
			}
		}
	}
	
	/**
	 * @param arr
	 * 插入排序，降序
	 */
	public static void insertionSortDes(double[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int j = i;
			while(j > 0 && arr[j -1] < arr[j]) {
				Util.arrayElementSwap(arr, j, j - 1);
				j--;
			}
		}
	}
	
	/**
	 * @param arr
	 * 希尔排序，升序
	 */
	public static void shellSortAsc(double[] arr) {
		int increment = 1;
		int N = arr.length;
		while(increment < N / 3)
			increment = 3 * increment + 1;
		for(; increment > 0; increment /= 3) {
			for(int i = increment; i < N; i++) {
				for(int j = i; j >= increment && arr[j] < arr[j - increment]; j -= increment) {
					Util.arrayElementSwap(arr, j, j - increment);
				}
			}
		}
	}	
	
	/**
	 * @param arr
	 * 希尔排序，降序
	 */
	public static void shellSortDes(double[] arr) {
		int increment = 1;
		int N = arr.length;
		while(increment < N / 3)
			increment = 3 * increment + 1;	//设定增量1，4，13····increment = 3*increment+1
		for(; increment > 0; increment /= 3) {
			for(int i = increment; i < N; i++) {
				for(int j = i; j >= increment && arr[j] > arr[j - increment]; j -= increment) {
					Util.arrayElementSwap(arr, j, j - increment);
				}
			}
		}
	}	
}
