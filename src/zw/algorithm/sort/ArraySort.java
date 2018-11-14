package zw.algorithm.sort;

import zw.algorithm.util.*;

/**
 * @author 13479
 *
 */
public class ArraySort {
	
	/**
	 * 冒泡排序法,升序
	 * @param arr
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
	 * 冒泡排序法,降序
	 * @param arr
	 * 
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
	 * 选择排序，升序
	 * @param arr
	 * 
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
	 * 选择排序，降序
	 * @param arr
	 * 
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
	 * 插入排序，升序
	 * @param arr
	 * 
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
	 * 插入排序，降序
	 * @param arr
	 * 
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
	 * 希尔排序，升序
	 * @param arr
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
	 * 希尔排序，降序
	 * @param arr
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
	 * 堆排序，升序
	 * 时间复杂度O(N*log2(N))
	 * @param arr
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
	 * (最大)堆的向下调整算法
	 * 
	 *  注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
	 *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
	 *
	 * 参数说明：
	 *     a -- 待排序的数组
	 *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
	 *     end   -- 截至范围(一般为数组中最后一个元素的索引)
	 * @param arr
	 * @param i
	 * @param j
	 * 
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
	 * 堆排序，降序
	 * 时间复杂度O(N*log2(N))
	 * @param arr
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
	 * @param arr
	 * @param i
	 * @param j
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
	
	/**
	 * 快速排序，升序
	 * @param arr
	 * 
	 */
	public static void quickSortAsc(int[] arr) {
		quickSortAsc(arr, 0, arr.length - 1);
	}

	private static void quickSortAsc(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int basicPoint = 0;	//选择基准元素
		if (left < right) {	//递归调用快速排序
			basicPoint = partitionAsc(arr, left, right);
			quickSortAsc(arr, left, basicPoint - 1);
			quickSortAsc(arr, basicPoint + 1, right);
		}
	}
	
	/**
	 * @param arr
	 * @param left
	 * @param right
	 * @return	返回基准索引
	 * 
	 */
	private static int partitionAsc(int[] arr, int left, int right)
	{
		int key = left;
		while (left < right) {
			while(left < right && arr[right] >= arr[key]) {	//右指针
				right--;
			}
			while(left < right && arr[left] <= arr[key]) {	//左指针
				left++;
			}
			if (left >= right) {	//左右两指针相遇则退出移位
				break;
			}
			Util.arrayElementSwap(arr, left, right);	//交换左右指针元素位置
		}
		Util.arrayElementSwap(arr, key, left);	//最后将基准元素放到对应位置	
		return left;
	}
	
	/**
	 *快速排序，降序
	 * @param arr

	 */
	public static void quickSortDes(int[] arr) {
		quickSortDes(arr, 0, arr.length - 1);
	}

	private static void quickSortDes(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int basicPoint = 0;	//选择基准元素
		if (left < right) {	//递归调用快速排序
			basicPoint = partitionDes(arr, left, right);
			quickSortDes(arr, left, basicPoint - 1);
			quickSortDes(arr, basicPoint + 1, right);
		}
	}
	
	/**
	 * @param arr
	 * @param left
	 * @param right
	 * @return	返回基准索引
	 */
	private static int partitionDes(int[] arr, int left, int right)
	{
		int key = left;
		while (left < right) {
			while(left < right && arr[right] <= arr[key]) {	//右指针
				right--;
			}
			while(left < right && arr[left] >= arr[key]) {	//左指针
				left++;
			}
			if (left >= right) {	//左右两指针相遇则退出移位
				break;
			}
			Util.arrayElementSwap(arr, left, right);	//交换左右指针元素位置
		}
		Util.arrayElementSwap(arr, key, left);	//最后将基准元素放到对应位置	
		return left;
	}
	
	public static void mergeSortAsc(int[] arr) {
		mergeSortAsc(arr, 0, arr.length - 1, new int[arr.length]);	//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
	}
	
	/**
	 * 归并排序，升序
	 * 归并排序主要思想为分而治之
	 * @param arr
	 * @param left
	 * @param right
	 * @param temp
	 */
	private static void mergeSortAsc(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int middle = (right + left) / 2;
			mergeSortAsc(arr, left, middle, temp);	//左边归并排序，使左边序列有序
			mergeSortAsc(arr, middle + 1, right, temp);	//右边归并排序，使右边序列有序
			mergeAsc(arr, left, middle, right, temp);	//两个有序子数组合并操作
		}
	}
	
	/**
	 * 合并操作，将两部分元素按顺序排列到temp数组中，再拷贝回原数组
	 * @param arr
	 * @param left
	 * @param middle
	 * @param right
	 * @param temp
	 */
	private static void mergeAsc(int[] arr, int left, int middle, int right, int[] temp) {
		int l = left;	//左序列指针
		int r = middle + 1;	//右序列指针
		int t = 0;	//临时数组的指针
		while (l <= middle && r <= right) {
			if (arr[l] <= arr[r]) {
				temp[t++] = arr[l++];
			} else {
				temp[t++] = arr[r++];
			}
		}
		while (l <= middle) {	//左边剩余元素填充到temp中
			temp[t++] = arr[l++];
		}
		while (r <= right) {	//右边剩余元素填充到temp中
			temp[t++] = arr[r++];
		}
		t = 0;
		while (left <= right) {	//将temp的元素全部拷贝回原数组
			arr[left++] = temp[t++];
		}
	}
	
	public static void mergeSortDes(int[] arr) {
		mergeSortDes(arr, 0, arr.length - 1, new int[arr.length]);	//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
	}
	
	/**
	 * 归并排序，升序
	 * 归并排序主要思想为分而治之
	 * @param arr
	 * @param left
	 * @param right
	 * @param temp
	 */
	private static void mergeSortDes(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int middle = (right + left) / 2;
			mergeSortDes(arr, left, middle, temp);	//左边归并排序，使左边序列有序
			mergeSortDes(arr, middle + 1, right, temp);	//右边归并排序，使右边序列有序
			mergeDes(arr, left, middle, right, temp);	//两个有序子数组合并操作
		}
	}
	
	/**
	 * 合并操作，将两部分元素按顺序排列到temp数组中，再拷贝回原数组
	 * @param arr
	 * @param left
	 * @param middle
	 * @param right
	 * @param temp
	 */
	private static void mergeDes(int[] arr, int left, int middle, int right, int[] temp) {
		int l = left;	//左序列指针
		int r = middle + 1;	//右序列指针
		int t = 0;	//临时数组的指针
		while (l <= middle && r <= right) {
			if (arr[l] >= arr[r]) {
				temp[t++] = arr[l++];
			} else {
				temp[t++] = arr[r++];
			}
		}
		while (l <= middle) {	//左边剩余元素填充到temp中
			temp[t++] = arr[l++];
		}
		while (r <= right) {	//右边剩余元素填充到temp中
			temp[t++] = arr[r++];
		}
		t = 0;
		while (left <= right) {	//将temp的元素全部拷贝回原数组
			arr[left++] = temp[t++];
		}
	}
}
