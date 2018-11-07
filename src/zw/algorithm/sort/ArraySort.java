package zw.algorithm.sort;

import zw.algorithm.util.*;

public class ArraySort {
	
	/**
	 * @param arr
	 * ð������,������������
	 */
	public static void bubbleSortAsc(double arr[]) {
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
	
	public static void bubbleSortAsc(int arr[]) {
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
	 * ð������,���ս�������
	 */
	public static void bubbleSortDes(double arr[]) {
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
	
	public static void bubbleSortDes(int arr[]) {
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
	 * ѡ�����򣬰�����������
	 */
	public static void selectSortAsc(double arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;	//ÿһ��ѭ���Ƚ�ʱ��min���ڴ�Ž�СԪ�ص������±꣬������ǰ���αȽ�������մ�ŵľ��Ǵ�������С��Ԫ�ص��±꣬����ÿ��������СԪ�ض�Ҫ���н�����
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
