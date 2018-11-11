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
	public static void selectSortAsc(int[] arr) {
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
	public static void selectSortDes(int[] arr) {
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
	public static void insertionSortAsc(int[] arr) {
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
	public static void insertionSortDes(int[] arr) {
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
	public static void shellSortAsc(int[] arr) {
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
	public static void shellSortDes(int[] arr) {
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
	
	
	/**
	 * @param arr
	 * 堆排序，升序
	 * 时间复杂度O(N*log2(N))
	 */
	public static void heapSortAsc(int[] arr) {
		//1.构建大根堆
		for(int i = arr.length / 2 - 1; i >= 0; i--) {
			//从第一个非叶子节点从下至上，从右至左调整结构
			maxHeapDown(arr, i, arr.length - 1);
		}
		//2.交换堆顶元素与堆末尾元素，并重新构建大根堆
		for(int j = arr.length - 1; j > 0; j--) {
			Util.arrayElementSwap(arr, 0, j);
			//重新构建大根堆
			maxHeapDown(arr, 0, j - 1);
		}
	}
	
	
	/**
	 * @param arr
	 * @param i
	 * @param j
	 * 
	 * (最大)堆的向下调整算法
	 * 
	 *  注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
	 *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
	 *
	 * 参数说明：
	 *     a -- 待排序的数组
	 *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
	 *     end   -- 截至范围(一般为数组中最后一个元素的索引)
	 */
	private static void maxHeapDown(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		for(int l = start * 2 + 1; l <= end; l = l * 2 + 1) {
			//l是左子节点，l+1是右子节点
			if(l + 1 <= end) {//右节点存在
				if(arr[l] < arr[l + 1]) {
					l++;	//找出左右子节点元素中最大元素的节点位置
				}
			}
			if(arr[l] > arr[start]) {//子节点大于父节点则交换
				Util.arrayElementSwap(arr, l, start);
				start = l;	//父节点与子节点的元素交换后，父节点元素的索引值发生更改，需要更新
			}
		}
	}
	
	/**
	 * @param arr
	 * 堆排序，降序
	 * 时间复杂度O(N*log2(N))
	 */
	public static void heapSortDes(int[] arr) {
		//1.构建小根堆
		for(int i = arr.length / 2 - 1; i >= 0; i--) {
			//从第一个非叶子节点从下至上，从右至左调整结构
			minHeapDown(arr, i, arr.length - 1);
		}
		//2.交换堆顶元素与堆末尾元素，并重新构建小根堆
		for(int j = arr.length - 1; j > 0; j--) {
			Util.arrayElementSwap(arr, 0, j);
			//重新构建小根堆
			minHeapDown(arr, 0, j - 1);
		}
	}


	 /**
	 * @param arr
	 * @param i
	 * @param j
	 * 
	 * (最小)堆的向下调整算法
	 * 
	 *  注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
	 *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
	 *
	 * 参数说明：
	 *     a -- 待排序的数组
	 *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
	 *     end   -- 截至范围(一般为数组中最后一个元素的索引)
	 */
	private static void minHeapDown(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		for(int l = start * 2 + 1; l <= end; l = l * 2 + 1) {
			//l是左子节点，l+1是右子节点
			if(l + 1 <= end) {//右节点存在
				if(arr[l] > arr[l + 1]) {
					l++;	//找出左右子节点元素中最小元素的节点位置
				}
			}
			if(arr[l] < arr[start]) {//子节点小于父节点则交换
				Util.arrayElementSwap(arr, l, start);
				start = l;	//父节点与子节点的元素交换后，父节点元素的索引值发生更改，需要更新
			}
		}
	}
}
