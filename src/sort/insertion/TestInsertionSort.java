package sort.insertion;

import java.util.Arrays;

public class TestInsertionSort {
	
	public static void main(String[] args) {
		int[] intArray = {11, 5, 1, 18, 4, 4, 6, 12, 3, 9};
		InsertionSort insertionSort = new InsertionSort();
		System.out.println(Arrays.toString(intArray));
		insertionSort.sort(intArray);
		System.out.println(Arrays.toString(intArray));
	}
}
