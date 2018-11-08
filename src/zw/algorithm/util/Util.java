package zw.algorithm.util;


public class Util {
	public static void arrayElementSwap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
	}
	
	public static void arrayElementSwap(double []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
	}
	
	public static void arrayElementSwap(Comparable []arr,int a,int b){
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
	}
}
