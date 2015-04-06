package com.operationjava;

public class SelectionSortAlg {

	public static void main(String[] args) {
		int[] arr = { 3, 7, 21, 5, 1, 0, 12, 13, 6, 2, 2, 1, 0 };

		System.out.println("Original array: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		selectionsort(arr);

		System.out.println("\nSorted array: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	static void selectionsort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int minpos = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minpos] > arr[j]) {
					minpos = j;
				}
			}

			int temp = arr[i];
			arr[i] = arr[minpos];
			arr[minpos] = temp;
		}
	}

}
