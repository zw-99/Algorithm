package zw.algorithm.search;

public class ArraySearch {
	/**
	 * 二分查找法
	 * 元素必须是有序的，如果是无序的则要先进行排序操作。
	 * 期望时间复杂度为O(log2n)
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearch(int[] arr, int value) {
		return binarySearch(arr, value, 0, arr.length - 1);
	}
	
	private static int binarySearch(int[] arr, int value, int start, int end) {
		int mid = start + (end - start) / 2;	//找到中间节点
		if (value == arr[mid]) {
			return mid;
		}
		if (value < arr[mid]) {
			return insertionSearch(arr, value, start, mid - 1);
		} 
		if (value > arr[mid]) {
			return insertionSearch(arr, value, mid + 1, end);
		}
		return -1;
	}
	
	/**
	 * 插值查找法
	 * 数元素必须是有序的，如果是无序的则要先进行排序操作。
	 * 查找成功或者失败的时间复杂度均为O(log2(log2n))。
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int insertionSearch(int[] arr, int value) {
		return insertionSearch(arr, value, 0, arr.length - 1);
	}
	
	private static int insertionSearch(int[] arr, int value, int start, int end) {
		if (value > arr[end]) {	//如果value大于数组最大元素，则表明目标元素不在数组中
			return -1;
		}
		int mid = start + (value - arr[start]) / (arr[end] - arr[start]) * (end - start);	//确定分割点
		if (value == arr[mid]) {
			return mid;
		}
		if (value < arr[mid]) {
			return insertionSearch(arr, value, start, mid - 1);
		} 
		if (value > arr[mid]) {
			return insertionSearch(arr, value, mid + 1, end);
		}
		return -1;
	}
}
