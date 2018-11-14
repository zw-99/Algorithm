package zw.algorithm.sort;

import zw.algorithm.util.*;

/**
 * @author 13479
 *
 */
public class ArraySort {
	
	/**
	 * ð������,����
	 * @param arr
	 */
	public static void bubbleSortAsc(double[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			boolean flag = true;	//�趨һ����־����Ϊture����˵���˴�ѭ��û�н���Ԫ�أ�������Ԫ���Ѿ����򣬼��������
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
			boolean flag = true;	//�趨һ����־����Ϊture����˵���˴�ѭ��û�н���Ԫ�أ�������Ԫ���Ѿ����򣬼��������
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
	 * ð������,����
	 * @param arr
	 * 
	 */
	public static void bubbleSortDes(double[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			boolean flag = true;	//�趨һ����־����Ϊture����˵���˴�ѭ��û�н���Ԫ�أ�������Ԫ���Ѿ����򣬼��������
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
			boolean flag = true;	//�趨һ����־����Ϊture����˵���˴�ѭ��û�н���Ԫ�أ�������Ԫ���Ѿ����򣬼��������
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
	 * ѡ����������
	 * @param arr
	 * 
	 */
	public static void selectSortAsc(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;	//ÿһ��ѭ���Ƚ�ʱ��min���ڴ�Ž�СԪ�ص������±꣬������ǰ���αȽ�������մ�ŵľ��Ǵ�������С��Ԫ�ص��±꣬����ÿ��������СԪ�ض�Ҫ���н�����
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
	 * ѡ�����򣬽���
	 * @param arr
	 * 
	 */
	public static void selectSortDes(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int max = i;	//ÿһ��ѭ���Ƚ�ʱ��max���ڴ�Žϴ�Ԫ�ص������±꣬������ǰ���αȽ�������մ�ŵľ��Ǵ���������Ԫ�ص��±꣬����ÿ�������ϴ�Ԫ�ض�Ҫ���н�����
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
	 * ������������
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
	 * �������򣬽���
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
	 * ϣ����������
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
	 * ϣ�����򣬽���
	 * @param arr
	 */
	public static void shellSortDes(int[] arr) {
		int increment = 1;
		int N = arr.length;
		while(increment < N / 3)
			increment = 3 * increment + 1;	//�趨����1��4��13��������increment = 3*increment+1
		for(; increment > 0; increment /= 3) {
			for(int i = increment; i < N; i++) {
				for(int j = i; j >= increment && arr[j] > arr[j - increment]; j -= increment) {
					Util.arrayElementSwap(arr, j, j - increment);
				}
			}
		}
	}	
	
	/**
	 * ����������
	 * ʱ�临�Ӷ�O(N*log2(N))
	 * @param arr
	 */
	public static void heapSortAsc(int[] arr) {
		//1.���������
		for(int i = arr.length / 2 - 1; i >= 0; i--) {
			//�ӵ�һ����Ҷ�ӽڵ�������ϣ�������������ṹ
			maxHeapDown(arr, i, arr.length - 1);
		}
		//2.�����Ѷ�Ԫ�����ĩβԪ�أ������¹��������
		for(int j = arr.length - 1; j > 0; j--) {
			Util.arrayElementSwap(arr, 0, j);
			//���¹��������
			maxHeapDown(arr, 0, j - 1);
		}
	}	
	
	/**
	 * (���)�ѵ����µ����㷨
	 * 
	 *  ע������ʵ�ֵĶ��У���N���ڵ�����ӵ�����ֵ��(2N+1)���Һ��ӵ�������(2N+2)��
	 *     ���У�NΪ�����±�����ֵ���������е�1������Ӧ��NΪ0��
	 *
	 * ����˵����
	 *     a -- �����������
	 *     start -- ���µ��ڵ����ʼλ��(һ��Ϊ0����ʾ�ӵ�1����ʼ)
	 *     end   -- ������Χ(һ��Ϊ���������һ��Ԫ�ص�����)
	 * @param arr
	 * @param i
	 * @param j
	 * 
	 */
	private static void maxHeapDown(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		for(int l = start * 2 + 1; l <= end; l = l * 2 + 1) {
			//l�����ӽڵ㣬l+1�����ӽڵ�
			if(l + 1 <= end) {//�ҽڵ����
				if(arr[l] < arr[l + 1]) {
					l++;	//�ҳ������ӽڵ�Ԫ�������Ԫ�صĽڵ�λ��
				}
			}
			if(arr[l] > arr[start]) {//�ӽڵ���ڸ��ڵ��򽻻�
				Util.arrayElementSwap(arr, l, start);
				start = l;	//���ڵ����ӽڵ��Ԫ�ؽ����󣬸��ڵ�Ԫ�ص�����ֵ�������ģ���Ҫ����
			}
		}
	}
	
	/**
	 * �����򣬽���
	 * ʱ�临�Ӷ�O(N*log2(N))
	 * @param arr
	 */
	public static void heapSortDes(int[] arr) {
		//1.����С����
		for(int i = arr.length / 2 - 1; i >= 0; i--) {
			//�ӵ�һ����Ҷ�ӽڵ�������ϣ�������������ṹ
			minHeapDown(arr, i, arr.length - 1);
		}
		//2.�����Ѷ�Ԫ�����ĩβԪ�أ������¹���С����
		for(int j = arr.length - 1; j > 0; j--) {
			Util.arrayElementSwap(arr, 0, j);
			//���¹���С����
			minHeapDown(arr, 0, j - 1);
		}
	}

	 /**
	 * 
	 * (��С)�ѵ����µ����㷨
	 * 
	 *  ע������ʵ�ֵĶ��У���N���ڵ�����ӵ�����ֵ��(2N+1)���Һ��ӵ�������(2N+2)��
	 *     ���У�NΪ�����±�����ֵ���������е�1������Ӧ��NΪ0��
	 *
	 * ����˵����
	 *     a -- �����������
	 *     start -- ���µ��ڵ����ʼλ��(һ��Ϊ0����ʾ�ӵ�1����ʼ)
	 *     end   -- ������Χ(һ��Ϊ���������һ��Ԫ�ص�����)
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void minHeapDown(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		for(int l = start * 2 + 1; l <= end; l = l * 2 + 1) {
			//l�����ӽڵ㣬l+1�����ӽڵ�
			if(l + 1 <= end) {//�ҽڵ����
				if(arr[l] > arr[l + 1]) {
					l++;	//�ҳ������ӽڵ�Ԫ������СԪ�صĽڵ�λ��
				}
			}
			if(arr[l] < arr[start]) {//�ӽڵ�С�ڸ��ڵ��򽻻�
				Util.arrayElementSwap(arr, l, start);
				start = l;	//���ڵ����ӽڵ��Ԫ�ؽ����󣬸��ڵ�Ԫ�ص�����ֵ�������ģ���Ҫ����
			}
		}
	}
	
	/**
	 * ������������
	 * @param arr
	 * 
	 */
	public static void quickSortAsc(int[] arr) {
		quickSortAsc(arr, 0, arr.length - 1);
	}

	private static void quickSortAsc(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int basicPoint = 0;	//ѡ���׼Ԫ��
		if (left < right) {	//�ݹ���ÿ�������
			basicPoint = partitionAsc(arr, left, right);
			quickSortAsc(arr, left, basicPoint - 1);
			quickSortAsc(arr, basicPoint + 1, right);
		}
	}
	
	/**
	 * @param arr
	 * @param left
	 * @param right
	 * @return	���ػ�׼����
	 * 
	 */
	private static int partitionAsc(int[] arr, int left, int right)
	{
		int key = left;
		while (left < right) {
			while(left < right && arr[right] >= arr[key]) {	//��ָ��
				right--;
			}
			while(left < right && arr[left] <= arr[key]) {	//��ָ��
				left++;
			}
			if (left >= right) {	//������ָ���������˳���λ
				break;
			}
			Util.arrayElementSwap(arr, left, right);	//��������ָ��Ԫ��λ��
		}
		Util.arrayElementSwap(arr, key, left);	//��󽫻�׼Ԫ�طŵ���Ӧλ��	
		return left;
	}
	
	/**
	 *�������򣬽���
	 * @param arr

	 */
	public static void quickSortDes(int[] arr) {
		quickSortDes(arr, 0, arr.length - 1);
	}

	private static void quickSortDes(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int basicPoint = 0;	//ѡ���׼Ԫ��
		if (left < right) {	//�ݹ���ÿ�������
			basicPoint = partitionDes(arr, left, right);
			quickSortDes(arr, left, basicPoint - 1);
			quickSortDes(arr, basicPoint + 1, right);
		}
	}
	
	/**
	 * @param arr
	 * @param left
	 * @param right
	 * @return	���ػ�׼����
	 */
	private static int partitionDes(int[] arr, int left, int right)
	{
		int key = left;
		while (left < right) {
			while(left < right && arr[right] <= arr[key]) {	//��ָ��
				right--;
			}
			while(left < right && arr[left] >= arr[key]) {	//��ָ��
				left++;
			}
			if (left >= right) {	//������ָ���������˳���λ
				break;
			}
			Util.arrayElementSwap(arr, left, right);	//��������ָ��Ԫ��λ��
		}
		Util.arrayElementSwap(arr, key, left);	//��󽫻�׼Ԫ�طŵ���Ӧλ��	
		return left;
	}
	
	public static void mergeSortAsc(int[] arr) {
		mergeSortAsc(arr, 0, arr.length - 1, new int[arr.length]);	//������ǰ���Ƚ���һ�����ȵ���ԭ���鳤�ȵ���ʱ���飬����ݹ���Ƶ�����ٿռ�
	}
	
	/**
	 * �鲢��������
	 * �鲢������Ҫ˼��Ϊ�ֶ���֮
	 * @param arr
	 * @param left
	 * @param right
	 * @param temp
	 */
	private static void mergeSortAsc(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int middle = (right + left) / 2;
			mergeSortAsc(arr, left, middle, temp);	//��߹鲢����ʹ�����������
			mergeSortAsc(arr, middle + 1, right, temp);	//�ұ߹鲢����ʹ�ұ���������
			mergeAsc(arr, left, middle, right, temp);	//��������������ϲ�����
		}
	}
	
	/**
	 * �ϲ���������������Ԫ�ذ�˳�����е�temp�����У��ٿ�����ԭ����
	 * @param arr
	 * @param left
	 * @param middle
	 * @param right
	 * @param temp
	 */
	private static void mergeAsc(int[] arr, int left, int middle, int right, int[] temp) {
		int l = left;	//������ָ��
		int r = middle + 1;	//������ָ��
		int t = 0;	//��ʱ�����ָ��
		while (l <= middle && r <= right) {
			if (arr[l] <= arr[r]) {
				temp[t++] = arr[l++];
			} else {
				temp[t++] = arr[r++];
			}
		}
		while (l <= middle) {	//���ʣ��Ԫ����䵽temp��
			temp[t++] = arr[l++];
		}
		while (r <= right) {	//�ұ�ʣ��Ԫ����䵽temp��
			temp[t++] = arr[r++];
		}
		t = 0;
		while (left <= right) {	//��temp��Ԫ��ȫ��������ԭ����
			arr[left++] = temp[t++];
		}
	}
	
	public static void mergeSortDes(int[] arr) {
		mergeSortDes(arr, 0, arr.length - 1, new int[arr.length]);	//������ǰ���Ƚ���һ�����ȵ���ԭ���鳤�ȵ���ʱ���飬����ݹ���Ƶ�����ٿռ�
	}
	
	/**
	 * �鲢��������
	 * �鲢������Ҫ˼��Ϊ�ֶ���֮
	 * @param arr
	 * @param left
	 * @param right
	 * @param temp
	 */
	private static void mergeSortDes(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int middle = (right + left) / 2;
			mergeSortDes(arr, left, middle, temp);	//��߹鲢����ʹ�����������
			mergeSortDes(arr, middle + 1, right, temp);	//�ұ߹鲢����ʹ�ұ���������
			mergeDes(arr, left, middle, right, temp);	//��������������ϲ�����
		}
	}
	
	/**
	 * �ϲ���������������Ԫ�ذ�˳�����е�temp�����У��ٿ�����ԭ����
	 * @param arr
	 * @param left
	 * @param middle
	 * @param right
	 * @param temp
	 */
	private static void mergeDes(int[] arr, int left, int middle, int right, int[] temp) {
		int l = left;	//������ָ��
		int r = middle + 1;	//������ָ��
		int t = 0;	//��ʱ�����ָ��
		while (l <= middle && r <= right) {
			if (arr[l] >= arr[r]) {
				temp[t++] = arr[l++];
			} else {
				temp[t++] = arr[r++];
			}
		}
		while (l <= middle) {	//���ʣ��Ԫ����䵽temp��
			temp[t++] = arr[l++];
		}
		while (r <= right) {	//�ұ�ʣ��Ԫ����䵽temp��
			temp[t++] = arr[r++];
		}
		t = 0;
		while (left <= right) {	//��temp��Ԫ��ȫ��������ԭ����
			arr[left++] = temp[t++];
		}
	}
}
