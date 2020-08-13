package sort.merge;

public class MergeSort {
	
	int[] tempMergArr;
	
	public void sort(int array[]) {
        tempMergArr = new int[array.length];
        mergeSort(array, 0, array.length - 1);
    }
	
	private void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = start + ((end - start) / 2);
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }
 
    private void merge(int[] array, int start, int middle, int end) {
        for (int i = start; i <= end; i++)
            tempMergArr[i] = array[i];
        
        int i = start;
        int j = middle + 1;
        int k = start;
        while (i <= middle && j <= end) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
        while (j <= end) {
            array[k] = tempMergArr[j];
            k++;
            j++;
        }
    }
}