package com.operationjava;

public class MergeSortAlg {

	public static void main(String[] args) {

		int[] arr = { 3, 7, 21, 5, 1, 0, 12, 13, 6, 2, 2, 1, 0 };

		System.out.println("Original array: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		splitarr(arr);

		System.out.println("\nSorted array: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	static void splitarr(int[] arr) {

		int mid = arr.length / 2;

		if (mid < 1)
			return;

		int[] larr = new int[mid];
		int[] rarr = new int[arr.length - mid];

		for (int i = 0; i < mid; i++) {
			larr[i] = arr[i];
		}

		for (int i = mid; i < arr.length; i++) {
			rarr[i - mid] = arr[i];
		}

		splitarr(larr);
		splitarr(rarr);

		merge(larr, rarr, arr);

	}

	static void merge(int[] larr, int[] rarr, int[] arr) {

		int i = 0, j = 0, k = 0;

		while (i < larr.length && j < rarr.length) {
			if (larr[i] < rarr[j]) {
				arr[k] = larr[i];
				i++;
				k++;
			} else {
				arr[k] = rarr[j];
				j++;
				k++;
			}
		}

		while (i < larr.length) {
			arr[k] = larr[i];
			i++;
			k++;
		}

		while (j < rarr.length) {
			arr[k] = rarr[j];
			j++;
			k++;
		}
	}
}
