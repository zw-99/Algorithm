package zw.algorithm.search;

public class ArraySearch {
	/**
	 * ���ֲ��ҷ�
	 * Ԫ�ر���������ģ�������������Ҫ�Ƚ������������
	 * ����ʱ�临�Ӷ�ΪO(log2n)
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearch(int[] arr, int value) {
		return binarySearch(arr, value, 0, arr.length - 1);
	}
	
	private static int binarySearch(int[] arr, int value, int start, int end) {
		int mid = start + (end - start) / 2;	//�ҵ��м�ڵ�
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
	 * ��ֵ���ҷ�
	 * ��Ԫ�ر���������ģ�������������Ҫ�Ƚ������������
	 * ���ҳɹ�����ʧ�ܵ�ʱ�临�ӶȾ�ΪO(log2(log2n))��
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int insertionSearch(int[] arr, int value) {
		return insertionSearch(arr, value, 0, arr.length - 1);
	}
	
	private static int insertionSearch(int[] arr, int value, int start, int end) {
		if (value > arr[end]) {	//���value�����������Ԫ�أ������Ŀ��Ԫ�ز���������
			return -1;
		}
		int mid = start + (value - arr[start]) / (arr[end] - arr[start]) * (end - start);	//ȷ���ָ��
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
