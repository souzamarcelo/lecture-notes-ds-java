package sort.quick;

import java.util.Arrays;
public class TestQuickSort {
	
	public static void main(String[] args) {
		int[] intArray = {11, 5, 1, 18, 4, 4, 6, 12, 3, 9};
		QuickSort quickSort = new QuickSort();
		System.out.println(Arrays.toString(intArray));
		quickSort.sort(intArray);
		System.out.println(Arrays.toString(intArray));
	}
}
