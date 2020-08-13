package sort.bubble;

public class BubbleSort {
	public void sort(int[] array) {
		for(int i = 0; i < array.length; i++)
			for(int j = 0; j < array.length - (i + 1); j++)
				if(array[j] > array[j + 1])
					swap(j, j + 1, array);
	}
	
	private void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	//Exercise 2
	public void sort2(int[] array) {
		for(int i = 0; i < array.length; i++) {
			boolean change = false;
			for(int j = 0; j < array.length - (i + 1); j++)
				if(array[j] > array[j + 1]) {
					swap(j, j + 1, array);
					change = true;
				}
			if(!change) return;
		}
	}
}
