package zw.algorithm.sort;

import zw.algorithm.util.*;

/**
 * @author 13479
 *
 */
public class ArraySort {
	
	/**
	 * @param arr
	 * ð������,����
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
	 * @param arr
	 * ð������,����
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
	 * @param arr
	 * ѡ����������
	 */
	public static void selectSortAsc(double[] arr) {
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
	 * @param arr
	 * ѡ�����򣬽���
	 */
	public static void selectSortDes(double[] arr) {
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
	 * @param arr
	 * ������������
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
	 * �������򣬽���
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
	 * ϣ����������
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
	 * ϣ�����򣬽���
	 */
	public static void shellSortDes(double[] arr) {
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
}
