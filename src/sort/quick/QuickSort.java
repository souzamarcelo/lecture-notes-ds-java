package sort.quick;

public class QuickSort {
	
	public void sort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	private void quickSort(int[] array, int start, int end) {
        int i = start;
        int j = end;
        //int pivot = array[start + (end - start)/2];
        int pivot = array[start];
        
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }

        if (start < j)
            quickSort(array, start, j);
        if (i < end)
            quickSort(array, i, end);
    }
	
	private void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
