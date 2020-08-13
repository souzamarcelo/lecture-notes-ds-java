package sort.selection;

public class SelectionSort {
	
	public void sort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[min])
					min = j;
			}
			swap(min, i, array);
		}
	}
	
	private void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
