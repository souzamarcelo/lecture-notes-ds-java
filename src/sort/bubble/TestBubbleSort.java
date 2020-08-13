package sort.bubble;

import java.util.Arrays;

public class TestBubbleSort {
	
	public static void main(String[] args) {
		int[] intArray = {11, 5, 1, 18, 4, 4, 6, 12, 3, 9};
		BubbleSort bubbleSort = new BubbleSort();
		System.out.println(Arrays.toString(intArray));
		bubbleSort.sort(intArray);
		System.out.println(Arrays.toString(intArray));
	}
}
