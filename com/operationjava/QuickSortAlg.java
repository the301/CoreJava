package com.operationjava;

public class QuickSortAlg {

	public static void main(String[] args) {

		int[] arr = { 3, 7, 21, 5, 1, 0, 12, 13, 6, 2, 2, 1, 0 };

		System.out.println("Original array: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		int low = 0;
		int high = arr.length - 1;

		quicksort(arr, low, high);

		System.out.println("\nSorted array: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	static void quicksort(int[] arr, int low, int high) {

		if(low < high) {
			int temp_pivot_index = partition(arr, low, high);
			quicksort(arr, low, temp_pivot_index - 1);
			quicksort(arr, temp_pivot_index + 1, high);
		}
	}

	static int partition(int[] arr, int low, int high) {

		int pivot_index = low;
		int pivot = arr[high];

		for (int i = low; i < high; i++) {

			if (arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[pivot_index];
				arr[pivot_index] = temp;
				pivot_index++;
			}

		}

		int temp = arr[pivot_index];
		arr[pivot_index] = arr[high];
		arr[high] = temp;

		return pivot_index;
	}

}
