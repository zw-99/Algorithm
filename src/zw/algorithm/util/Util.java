package zw.algorithm.util;


public class Util {
	public static void arrayElementSwap(int []arr,int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void arrayElementSwap(Integer []arr,int a,int b){
		Integer temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void arrayElementSwap(double []arr,int a,int b){
		double temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
}
