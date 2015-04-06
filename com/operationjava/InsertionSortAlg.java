package com.operationjava;

public class InsertionSortAlg {

	public static void main(String[] args) {
		int[] arr = { 3, 7, 21, 5, 1, 0, 12, 13, 6, 2, 2, 1, 0 };

		System.out.println("Original array: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		insertionsort(arr);

		System.out.println("\nSorted array: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	static void insertionsort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int ele = arr[i];
			int j;
			for (j = i; j > 0 && arr[j - 1] > ele; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = ele;
		}
	}

}
