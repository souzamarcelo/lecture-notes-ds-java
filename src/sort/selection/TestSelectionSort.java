package sort.selection;

import java.util.Arrays;

public class TestSelectionSort {
	
	public static void main(String[] args) {
		int[] intArray = {11, 5, 1, 18, 4, 4, 6, 12, 3, 9};
		SelectionSort selectionSort = new SelectionSort();
		System.out.println(Arrays.toString(intArray));
		selectionSort.sort(intArray);
		System.out.println(Arrays.toString(intArray));
	}
}
